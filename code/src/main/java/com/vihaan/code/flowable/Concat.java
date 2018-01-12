package com.vihaan.code.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

/**
 * Created by vihaanverma on 07/01/18.
 */

public class Concat {
    public static void main(String[] args) throws InterruptedException {
        concat();
    }

    public static void concat() throws InterruptedException {

        Flowable
                .concat(getEvenNumbers(), getOddNumbers())
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

        Thread.sleep(10*1000);
    }

    public static Flowable<Integer> getOddNumbers(){
        return Flowable
                .range(1,10)
                .filter(number->number%2!=0);
    }

    public static Flowable<Integer> getEvenNumbers(){
        return Flowable
                .range(1,10)
                .filter(number -> number%2==0);
    }
}
