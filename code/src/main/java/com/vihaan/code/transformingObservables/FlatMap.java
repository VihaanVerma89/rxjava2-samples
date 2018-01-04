package com.vihaan.code.transformingObservables;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by vihaanverma on 13/12/17.
 */

public class FlatMap {

    public static void main(String []args) {

//        flatMap();
        flatMapLamda();
    }


    private static void flatMapLamda(){

        Observable
                .range(1,10)
                .flatMap(number -> {
                    return Observable
                            .range(1,10)
                            .flatMap(value -> {
                                return Observable.just(number * value);
                            });

                })
                .subscribe(number -> {
                    System.out.println(number);
                });
    }

    private static void flatMap(){

        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer*10;
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .flatMap(new Function<Integer, ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer integer) throws Exception {
                        return Observable.just(integer*1, integer*2, integer*3, integer*4,
                                integer*5);
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
