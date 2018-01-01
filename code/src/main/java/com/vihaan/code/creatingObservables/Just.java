package com.vihaan.code.creatingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class Just {
    public static void main(String[] args) throws InterruptedException {
        just();
    }

    public static void just(){
        Observable<Integer> just = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println();
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
            }
        };

        just.subscribe(observer);

    }
}
