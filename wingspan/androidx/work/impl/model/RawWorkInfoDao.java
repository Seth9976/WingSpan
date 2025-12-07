package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\'J\u001C\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b2\u0006\u0010\u0005\u001A\u00020\u0006H\'¨\u0006\t"}, d2 = {"Landroidx/work/impl/model/RawWorkInfoDao;", "", "getWorkInfoPojos", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "query", "Landroidx/sqlite/db/SupportSQLiteQuery;", "getWorkInfoPojosLiveData", "Landroidx/lifecycle/LiveData;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface RawWorkInfoDao {
    List getWorkInfoPojos(SupportSQLiteQuery arg1);

    LiveData getWorkInfoPojosLiveData(SupportSQLiteQuery arg1);
}

