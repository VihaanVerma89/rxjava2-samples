package com.vihaan.code.creatingObservables;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by vihaanverma on 13/12/17.
 */

public class From {

    public static void main(String[] args) {

        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * 10;
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


        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int array1[] = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int array2[] = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

        Observable.fromArray(array,array1,array2)
                .map(new Function<int[], int[]>() {

                    @Override
                    public int[] apply(int[] ints) throws Exception {
                        int i=0;
                        for (int n : ints) {
                            ints[i++] = n * 10;
                        }
                        return ints;
                    }
                }).subscribe(new Observer<int[]>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(int[] ints) {
                System.out.println(Arrays.toString(ints));
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,4,5,6,7,8,9,10));

        Observable.fromIterable(arrayList)
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

    }


}
