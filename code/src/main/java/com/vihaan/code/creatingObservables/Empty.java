package com.vihaan.code.creatingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class Empty {
    public static void main(String[] args) throws InterruptedException {
        empty();
    }

    public static void empty(){

        Observable empty = Observable.empty();

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        empty.subscribe(observer);
        Observable observable = empty.defaultIfEmpty("empty");

        observable.subscribe(observer);
    }
}
