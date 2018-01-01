package com.vihaan.code.creatingObservables;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class Timer {
    public static void main(String[] args) throws InterruptedException {
        timer();
    }

    public static void timer() throws InterruptedException {
        Observable<Long> timer = Observable.timer(3, TimeUnit.SECONDS);

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println();
            }

            @Override
            public void onNext(Object o) {

                System.out.println();
            }

            @Override
            public void onError(Throwable e) {

                System.out.println();
            }

            @Override
            public void onComplete() {

                System.out.println();
            }
        };

        timer.subscribe(observer);
        Thread.sleep(1000* 10);
    }
}
