package com.vihaan.code.creatingObservables;


import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Source;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class Interval {

    public static void main(String[] args) throws InterruptedException {
        interval();
        intervalDelay();
    }

    public static void interval() throws InterruptedException {

        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);

        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(d.toString());
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        interval.subscribe(observer);

        Thread.sleep(1000* 60);
    }

    public static void intervalDelay() throws InterruptedException {

        Observable<Long> interval = Observable.interval(5,1, TimeUnit.SECONDS);

        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println(d.toString());
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println(aLong);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        interval.subscribe(observer);

        Thread.sleep(1000* 60);
    }

}
