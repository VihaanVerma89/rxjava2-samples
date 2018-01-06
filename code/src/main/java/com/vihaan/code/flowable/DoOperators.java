package com.vihaan.code.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

/**
 * Created by vihaanverma on 06/01/18.
 */

public class DoOperators {
    public static void main(String[] args) throws InterruptedException {
        doOnNext();
    }

    private static void doOnNext(){

        Flowable
                .range(1,10)
                .doOnNext(number -> System.out.println(number))
                .filter(number -> number%2==0)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(10);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("error");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("complete");
                    }
                });

    }
}
