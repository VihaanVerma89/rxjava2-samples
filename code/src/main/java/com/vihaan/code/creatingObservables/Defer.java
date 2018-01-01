package com.vihaan.code.creatingObservables;


import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class Defer {

    public static void main(String[] args) throws InterruptedException {
        defer();
    }

    public static int value = 0;

    public static void defer() throws InterruptedException {
        Observable<Integer> defer = Observable.defer(new Callable<ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> call() throws Exception {
                ObservableSource<Integer> observableSource = new ObservableSource<Integer>() {
                    @Override
                    public void subscribe(Observer<? super Integer> observer) {

                        observer.onNext(value++);
                    }

                };
                System.out.println("returning observable : " + observableSource.toString());
                return observableSource;
            }
        });

        Observer observer1 = new Observer() {
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

        defer.subscribe(observer1);

        Thread.sleep(2000);

        Observer observer2 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println();
            }

            @Override
            public void onNext(Integer integer) {

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

        defer.subscribe(observer2);
        Thread.sleep(2000);

        Observer observer3 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println();
            }

            @Override
            public void onNext(Integer integer) {

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

        defer.subscribe(observer3);
        Thread.sleep(2000);
        Observer observer4 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println();
            }

            @Override
            public void onNext(Integer integer) {

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
        defer.subscribe(observer4);


    }


}
