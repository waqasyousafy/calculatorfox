package com.code4rox.calculatorfox;

import android.app.Activity;

import androidx.fragment.app.ListFragment;

public class HeadlinesFragment extends ListFragment {
    OnHeadlineSelectedListener callback;

    public void setOnHeadlineSelectedListener(OnHeadlineSelectedListener callback) {
        this.callback = callback;
    }

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int position);
    }

    // ...
}
