package com.vihaan.code.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 * Created by vihaanverma on 01/01/18.
 */

public class FlowableTest {
    public static void main(String[] args) throws InterruptedException {

//        test();
//        getData();
        listTest();
    }

    private static void listTest(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        Flowable<String> stringFlowable = Flowable.fromIterable(map.values());
                stringFlowable.subscribe(new Subscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(2);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

                stringFlowable
                        .toList()
                        .subscribe(new SingleObserver<List<String>>() {
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

                stringFlowable
                        .toList()
                        .toFlowable()
                        .subscribe(new Subscriber<List<String>>() {
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

    }

    private static void getTasks() {
        Map<String, String> data;
        data = new LinkedHashMap<>();
        data.put("Build tower in Pisa", "Ground looks good, no foundation work required.");
        data.put("Finish bridge in Tacoma", "Found awesome girders at half the cost!");

        Flowable.fromIterable(data.values())
                .delay(5000, TimeUnit.MILLISECONDS)
                .toList()
                .toFlowable()
                .flatMap(tasks -> Flowable.fromIterable(tasks).doOnNext(task -> { }).toList().toFlowable())
                .doOnComplete(()->{});

//        Flowable.fromIterable()
    }


    private static void getData() throws InterruptedException {
        Map<String, String> data;
        data = new LinkedHashMap<>();
        data.put("Build tower in Pisa", "Ground looks good, no foundation work required.");
        data.put("Finish bridge in Tacoma", "Found awesome girders at half the cost!");

        Flowable<String> stringFlowable = Flowable.fromIterable(data.values());

        Subscriber<String> subscriber = new Subscriber<String>() {
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

        Thread.sleep(20 * 1000);
    }

    private static void test() throws InterruptedException {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Flowable<Integer> just = Flowable.just(1, 2, 3, 4, 5, 6);


        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
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
        Thread.sleep(1000 * 10);

    }


}
