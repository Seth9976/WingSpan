package com.voxelbusters.essentialkit.uiviews;

public interface IUiViews {
    public interface IButtonClickListener {
        void onClick(int arg1);
    }

    public interface IDatePickerListener {
        void onCancel();

        void onSuccess(int arg1, int arg2, int arg3);
    }

    public interface ITimePickerListener {
        void onCancel();

        void onSuccess(int arg1, int arg2);
    }

}

