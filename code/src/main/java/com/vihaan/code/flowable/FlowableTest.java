package com.vihaan.code.flowable;

import android.util.TimeUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class FlowableTest {
    public static void main(String[] args) throws InterruptedException {

//        test();
        getData();
    }

    private static void getData() throws InterruptedException {
        Map<String, String> data;
        data = new LinkedHashMap<>();
        data.put("Build tower in Pisa", "Ground looks good, no foundation work required.");
        data.put("Finish bridge in Tacoma", "Found awesome girders at half the cost!");

        Flowable<String> stringFlowable = Flowable.fromIterable(data.values());

        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

                s.request(1);
            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        stringFlowable.subscribe(subscriber);
        Single<List<String>> listSingle = stringFlowable.delay(5000, TimeUnit.MILLISECONDS)
                .toList();

        listSingle.subscribe(new SingleObserver<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<String> strings) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });

        listSingle.toFlowable().subscribe(new Subscriber<List<String>>() {
            @Override
            public void onSubscribe(Subscription s) {

                s.request(1);
            }

            @Override
            public void onNext(List<String> strings) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });

        Thread.sleep(20*1000);
    }

    private static void test() throws InterruptedException {
        int [] numbers = new int[]{1,2,3,4,5,6,7,8,9,10};
        Flowable<Integer> just = Flowable.just(1, 2, 3, 4, 5, 6);



        Subscriber<Integer> subscriber= new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println();
                s.request(10);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println();

            }

            @Override
            public void onError(Throwable t) {
                System.out.println();

            }

            @Override
            public void onComplete() {
                System.out.println();

            }
        };


        just.subscribe(subscriber);


        Single<List<Integer>> listSingle = just.toList();
        listSingle.subscribe(new SingleObserver<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<Integer> integers) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });

        listSingle.toFlowable()
                .subscribe(new Subscriber<List<Integer>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Thread.sleep(1000*10);

    }


}