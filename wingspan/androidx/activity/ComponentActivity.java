package androidx.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract.SynchronousResult;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements OnBackPressedDispatcherOwner, ContextAware, ActivityResultCaller, ActivityResultRegistryOwner, OnMultiWindowModeChangedProvider, OnNewIntentProvider, OnPictureInPictureModeChangedProvider, OnConfigurationChangedProvider, OnTrimMemoryProvider, MenuHost, HasDefaultViewModelProviderFactory, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {
    static class Api19Impl {
        static void cancelPendingInputEvents(View view0) {
            view0.cancelPendingInputEvents();
        }
    }

    static final class NonConfigurationInstances {
        Object custom;
        ViewModelStore viewModelStore;

    }

    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private Factory mDefaultFactory;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList mOnNewIntentListeners;
    private final CopyOnWriteArrayList mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(() -> this.invalidateOptionsMenu());
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController savedStateRegistryController0 = SavedStateRegistryController.create(this);
        this.mSavedStateRegistryController = savedStateRegistryController0;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            @Override
            public void run() {
                try {
                    ComponentActivity.this.super.onBackPressed();
                }
                catch(IllegalStateException illegalStateException0) {
                    if(!TextUtils.equals(illegalStateException0.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw illegalStateException0;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() {
            @Override  // androidx.activity.result.ActivityResultRegistry
            public void onLaunch(int v, ActivityResultContract activityResultContract0, Object object0, ActivityOptionsCompat activityOptionsCompat0) {
                Bundle bundle1;
                ComponentActivity componentActivity0 = ComponentActivity.this;
                SynchronousResult activityResultContract$SynchronousResult0 = activityResultContract0.getSynchronousResult(componentActivity0, object0);
                if(activityResultContract$SynchronousResult0 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            Object object0 = activityResultContract$SynchronousResult0.getValue();
                            androidx.activity.ComponentActivity.2.this.dispatchResult(v, object0);
                        }
                    });
                    return;
                }
                Intent intent0 = activityResultContract0.createIntent(componentActivity0, object0);
                if(intent0.getExtras() != null && intent0.getExtras().getClassLoader() == null) {
                    intent0.setExtrasClassLoader(componentActivity0.getClassLoader());
                }
                if(intent0.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    Bundle bundle0 = intent0.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    intent0.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    bundle1 = bundle0;
                }
                else {
                    bundle1 = activityOptionsCompat0 == null ? null : activityOptionsCompat0.toBundle();
                }
                if("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intent0.getAction())) {
                    String[] arr_s = intent0.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if(arr_s == null) {
                        arr_s = new String[0];
                    }
                    ActivityCompat.requestPermissions(componentActivity0, arr_s, v);
                    return;
                }
                if("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intent0.getAction())) {
                    IntentSenderRequest intentSenderRequest0 = (IntentSenderRequest)intent0.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        ActivityCompat.startIntentSenderForResult(componentActivity0, intentSenderRequest0.getIntentSender(), v, intentSenderRequest0.getFillInIntent(), intentSenderRequest0.getFlagsMask(), intentSenderRequest0.getFlagsValues(), 0, bundle1);
                    }
                    catch(IntentSender.SendIntentException intentSender$SendIntentException0) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent0 = new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", intentSender$SendIntentException0);
                                androidx.activity.ComponentActivity.2.this.dispatchResult(v, 0, intent0);
                            }
                        });
                    }
                    return;
                }
                ActivityCompat.startActivityForResult(componentActivity0, intent0, v, bundle1);
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList();
        if(this.getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity\'s constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        this.getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override  // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
                if(lifecycle$Event0 == Event.ON_STOP) {
                    Window window0 = ComponentActivity.this.getWindow();
                    View view0 = window0 == null ? null : window0.peekDecorView();
                    if(view0 != null) {
                        Api19Impl.cancelPendingInputEvents(view0);
                    }
                }
            }
        });
        this.getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override  // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
                if(lifecycle$Event0 == Event.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.clearAvailableContext();
                    if(!ComponentActivity.this.isChangingConfigurations()) {
                        ComponentActivity.this.getViewModelStore().clear();
                    }
                }
            }
        });
        this.getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override  // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().removeObserver(this);
            }
        });
        savedStateRegistryController0.performAttach();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        if(Build.VERSION.SDK_INT <= 23) {
            this.getLifecycle().addObserver(new ImmLeaksCleaner(this));
        }
        this.getSavedStateRegistry().registerSavedStateProvider("android:support:activity-result", () -> {
            Bundle bundle0 = new Bundle();
            this.mActivityResultRegistry.onSaveInstanceState(bundle0);
            return bundle0;
        });
        this.addOnContextAvailableListener((Context context0) -> {
            Bundle bundle0 = this.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
            if(bundle0 != null) {
                this.mActivityResultRegistry.onRestoreInstanceState(bundle0);
            }
        });
    }

    public ComponentActivity(int v) {
        this.mContentLayoutId = v;
    }

    @Override  // android.app.Activity
    public void addContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initViewTreeOwners();
        super.addContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider0) {
        this.mMenuHostHelper.addMenuProvider(menuProvider0);
    }

    @Override  // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider0, LifecycleOwner lifecycleOwner0) {
        this.mMenuHostHelper.addMenuProvider(menuProvider0, lifecycleOwner0);
    }

    @Override  // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider0, LifecycleOwner lifecycleOwner0, State lifecycle$State0) {
        this.mMenuHostHelper.addMenuProvider(menuProvider0, lifecycleOwner0, lifecycle$State0);
    }

    @Override  // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer consumer0) {
        this.mOnConfigurationChangedListeners.add(consumer0);
    }

    @Override  // androidx.activity.contextaware.ContextAware
    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener0) {
        this.mContextAwareHelper.addOnContextAvailableListener(onContextAvailableListener0);
    }

    @Override  // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer consumer0) {
        this.mOnMultiWindowModeChangedListeners.add(consumer0);
    }

    @Override  // androidx.core.app.OnNewIntentProvider
    public final void addOnNewIntentListener(Consumer consumer0) {
        this.mOnNewIntentListeners.add(consumer0);
    }

    @Override  // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer consumer0) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer0);
    }

    @Override  // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer consumer0) {
        this.mOnTrimMemoryListeners.add(consumer0);
    }

    void ensureViewModelStore() {
        if(this.mViewModelStore == null) {
            NonConfigurationInstances componentActivity$NonConfigurationInstances0 = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
            if(componentActivity$NonConfigurationInstances0 != null) {
                this.mViewModelStore = componentActivity$NonConfigurationInstances0.viewModelStore;
            }
            if(this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override  // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override  // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        CreationExtras creationExtras0 = new MutableCreationExtras();
        if(this.getApplication() != null) {
            Application application0 = this.getApplication();
            ((MutableCreationExtras)creationExtras0).set(AndroidViewModelFactory.APPLICATION_KEY, application0);
        }
        ((MutableCreationExtras)creationExtras0).set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        ((MutableCreationExtras)creationExtras0).set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if(this.getIntent() != null && this.getIntent().getExtras() != null) {
            Bundle bundle0 = this.getIntent().getExtras();
            ((MutableCreationExtras)creationExtras0).set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, bundle0);
        }
        return creationExtras0;
    }

    @Override  // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public Factory getDefaultViewModelProviderFactory() {
        if(this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory(this.getApplication(), this, (this.getIntent() == null ? null : this.getIntent().getExtras()));
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances componentActivity$NonConfigurationInstances0 = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
        return componentActivity$NonConfigurationInstances0 == null ? null : componentActivity$NonConfigurationInstances0.custom;
    }

    @Override  // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override  // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override  // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    @Override  // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if(this.getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can\'t request ViewModel before onCreate call.");
        }
        this.ensureViewModelStore();
        return this.mViewModelStore;
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.set(this.getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.set(this.getWindow().getDecorView(), this);
    }

    // 检测为 Lambda 实现
    @Override  // androidx.core.view.MenuHost
    public void invalidateMenu() [...]

    // 检测为 Lambda 实现
    Bundle lambda$new$0$androidx-activity-ComponentActivity() [...]

    // 检测为 Lambda 实现
    void lambda$new$1$androidx-activity-ComponentActivity(Context context0) [...]

    @Override  // android.app.Activity
    @Deprecated
    protected void onActivityResult(int v, int v1, Intent intent0) {
        if(!this.mActivityResultRegistry.dispatchResult(v, v1, intent0)) {
            super.onActivityResult(v, v1, intent0);
        }
    }

    @Override  // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.onBackPressed();
    }

    @Override  // android.app.Activity
    public void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        for(Object object0: this.mOnConfigurationChangedListeners) {
            ((Consumer)object0).accept(configuration0);
        }
    }

    @Override  // androidx.core.app.ComponentActivity
    protected void onCreate(Bundle bundle0) {
        this.mSavedStateRegistryController.performRestore(bundle0);
        this.mContextAwareHelper.dispatchOnContextAvailable(this);
        super.onCreate(bundle0);
        ReportFragment.injectIfNeededIn(this);
        int v = this.mContentLayoutId;
        if(v != 0) {
            this.setContentView(v);
        }
    }

    @Override  // android.app.Activity
    public boolean onCreatePanelMenu(int v, Menu menu0) {
        if(v == 0) {
            super.onCreatePanelMenu(0, menu0);
            MenuInflater menuInflater0 = this.getMenuInflater();
            this.mMenuHostHelper.onCreateMenu(menu0, menuInflater0);
        }
        return true;
    }

    @Override  // android.app.Activity
    public boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        if(super.onMenuItemSelected(v, menuItem0)) {
            return true;
        }
        return v == 0 ? this.mMenuHostHelper.onMenuItemSelected(menuItem0) : false;
    }

    @Override  // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        for(Object object0: this.mOnMultiWindowModeChangedListeners) {
            ((Consumer)object0).accept(new MultiWindowModeChangedInfo(z));
        }
    }

    @Override  // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration0) {
        for(Object object0: this.mOnMultiWindowModeChangedListeners) {
            ((Consumer)object0).accept(new MultiWindowModeChangedInfo(z, configuration0));
        }
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        super.onNewIntent(intent0);
        for(Object object0: this.mOnNewIntentListeners) {
            ((Consumer)object0).accept(intent0);
        }
    }

    @Override  // android.app.Activity
    public void onPanelClosed(int v, Menu menu0) {
        this.mMenuHostHelper.onMenuClosed(menu0);
        super.onPanelClosed(v, menu0);
    }

    @Override  // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        for(Object object0: this.mOnPictureInPictureModeChangedListeners) {
            ((Consumer)object0).accept(new PictureInPictureModeChangedInfo(z));
        }
    }

    @Override  // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration0) {
        for(Object object0: this.mOnPictureInPictureModeChangedListeners) {
            ((Consumer)object0).accept(new PictureInPictureModeChangedInfo(z, configuration0));
        }
    }

    @Override  // android.app.Activity
    public boolean onPreparePanel(int v, View view0, Menu menu0) {
        if(v == 0) {
            super.onPreparePanel(0, view0, menu0);
            this.mMenuHostHelper.onPrepareMenu(menu0);
        }
        return true;
    }

    @Override  // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        Intent intent0 = new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", arr_s).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", arr_v);
        if(!this.mActivityResultRegistry.dispatchResult(v, -1, intent0)) {
            super.onRequestPermissionsResult(v, arr_s, arr_v);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() [...] // Inlined contents

    @Override  // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        ViewModelStore viewModelStore0 = this.mViewModelStore;
        if(viewModelStore0 == null) {
            NonConfigurationInstances componentActivity$NonConfigurationInstances0 = (NonConfigurationInstances)this.getLastNonConfigurationInstance();
            if(componentActivity$NonConfigurationInstances0 != null) {
                viewModelStore0 = componentActivity$NonConfigurationInstances0.viewModelStore;
            }
        }
        if(viewModelStore0 == null) {
            return null;
        }
        NonConfigurationInstances componentActivity$NonConfigurationInstances1 = new NonConfigurationInstances();
        componentActivity$NonConfigurationInstances1.custom = null;
        componentActivity$NonConfigurationInstances1.viewModelStore = viewModelStore0;
        return componentActivity$NonConfigurationInstances1;
    }

    @Override  // androidx.core.app.ComponentActivity
    protected void onSaveInstanceState(Bundle bundle0) {
        Lifecycle lifecycle0 = this.getLifecycle();
        if(lifecycle0 instanceof LifecycleRegistry) {
            ((LifecycleRegistry)lifecycle0).setCurrentState(State.CREATED);
        }
        super.onSaveInstanceState(bundle0);
        this.mSavedStateRegistryController.performSave(bundle0);
    }

    @Override  // android.app.Activity
    public void onTrimMemory(int v) {
        super.onTrimMemory(v);
        for(Object object0: this.mOnTrimMemoryListeners) {
            ((Consumer)object0).accept(v);
        }
    }

    @Override  // androidx.activity.contextaware.ContextAware
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.peekAvailableContext();
    }

    @Override  // androidx.activity.result.ActivityResultCaller
    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract0, ActivityResultCallback activityResultCallback0) {
        return this.registerForActivityResult(activityResultContract0, this.mActivityResultRegistry, activityResultCallback0);
    }

    @Override  // androidx.activity.result.ActivityResultCaller
    public final ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract0, ActivityResultRegistry activityResultRegistry0, ActivityResultCallback activityResultCallback0) {
        return activityResultRegistry0.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract0, activityResultCallback0);
    }

    @Override  // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider menuProvider0) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider0);
    }

    @Override  // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer consumer0) {
        this.mOnConfigurationChangedListeners.remove(consumer0);
    }

    @Override  // androidx.activity.contextaware.ContextAware
    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener0) {
        this.mContextAwareHelper.removeOnContextAvailableListener(onContextAvailableListener0);
    }

    @Override  // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer consumer0) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer0);
    }

    @Override  // androidx.core.app.OnNewIntentProvider
    public final void removeOnNewIntentListener(Consumer consumer0) {
        this.mOnNewIntentListeners.remove(consumer0);
    }

    @Override  // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer consumer0) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer0);
    }

    @Override  // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer consumer0) {
        this.mOnTrimMemoryListeners.remove(consumer0);
    }

    @Override  // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if(Trace.isEnabled()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        }
        finally {
            Trace.endSection();
        }
    }

    @Override  // android.app.Activity
    public void setContentView(int v) {
        this.initViewTreeOwners();
        super.setContentView(v);
    }

    @Override  // android.app.Activity
    public void setContentView(View view0) {
        this.initViewTreeOwners();
        super.setContentView(view0);
    }

    @Override  // android.app.Activity
    public void setContentView(View view0, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        this.initViewTreeOwners();
        super.setContentView(view0, viewGroup$LayoutParams0);
    }

    @Override  // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent0, int v) {
        super.startActivityForResult(intent0, v);
    }

    @Override  // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent0, int v, Bundle bundle0) {
        super.startActivityForResult(intent0, v, bundle0);
    }

    @Override  // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3);
    }

    @Override  // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender0, int v, Intent intent0, int v1, int v2, int v3, Bundle bundle0) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender0, v, intent0, v1, v2, v3, bundle0);
    }
}

