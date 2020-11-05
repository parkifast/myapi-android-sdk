package com.parkifast.mymappi.myapisdk.network.wrappers;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Abstract helper base class to handle thread configuration parameters.
 * @param <T>       The specific type of response we are assigning thread management to.
 */
public abstract class BaseApiWrapper<T> {
    Single<T> assignObservableThread(Single<T> observable, boolean observeOnMainThread) {
        if(observeOnMainThread) {
            observable = observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
        return observable;
    }
}
