package com.vihaan.code.filteringObservables;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by vihaanverma on 13/12/17.
 */

public class Filter {

    public static void main(String[] args) {
        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 5;
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if (integer % 2 == 0) {
                            return true;
                        }
                        return false;
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
                    public ObservableSource<Integer> apply(final Integer integer) throws Exception {
                        return Observable.range(1, 10)
                                .map(new Function<Integer, Integer>() {
                                    @Override
                                    public Integer apply(Integer range) throws Exception {
                                        return integer * range;
                                    }
                                });
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
                    public ObservableSource<Integer> apply(final Integer integer) throws Exception {
                        return Observable.range(1, 10)
                                .map(new Function<Integer, Integer>() {
                                    @Override
                                    public Integer apply(Integer range) throws Exception {
                                        return integer * range;
                                    }
                                });
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        if(integer%2==0)
                        {
                            return true;
                        }
                        return false;
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
