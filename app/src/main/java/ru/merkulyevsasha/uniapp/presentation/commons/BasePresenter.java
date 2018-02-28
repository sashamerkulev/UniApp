package ru.merkulyevsasha.uniapp.presentation.commons;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public abstract class BasePresenter<T> {

    protected T view;
    private CompositeDisposable compositeDisposable;

    protected BasePresenter() {
        compositeDisposable = new CompositeDisposable();
    }

    public void bindView(T view) {
        this.view = view;
    }

    void unbindView() {
        this.view = null;
    }

    void onDestroy() {
        compositeDisposable.dispose();
    }

}