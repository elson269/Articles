package com.elsonji.articles.domain.interactors;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class Interactor<T, Params>{
    private final CompositeDisposable compositeDisposable;

    public Interactor() {
        compositeDisposable = new CompositeDisposable();
    }

    abstract Observable<T> buildInteractorObservable(Params params);

    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = buildInteractorObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }}
