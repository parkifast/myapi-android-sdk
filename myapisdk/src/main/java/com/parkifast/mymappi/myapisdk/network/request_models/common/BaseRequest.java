package com.parkifast.mymappi.myapisdk.network.request_models.common;

public abstract class BaseRequest<T> {
    /**
     * Determines whether the request should be observed in the background or in the main thread.
     */
    public boolean observeOnMainThread;

    public static abstract class Builder<T extends Builder<T>> {
        public boolean observeOnMainThread = true;

        public T observeOnMainThread(boolean observeOnMainThread) {
            this.observeOnMainThread = observeOnMainThread;
            return (T) this;
        }
    }
}
