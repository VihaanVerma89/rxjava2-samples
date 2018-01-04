package com.vihaan.code.transformingObservables;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;


/**
 * Created by vihaanverma on 04/01/18.
 */

public class GroupBy {
    public static void main(String[] args) throws InterruptedException {
//        groupBy();
//        groupByLambda();
        groupByOddEven();
    }

    private static void groupByLambda(){
        Observable
                .range(1,10)
                .groupBy(number ->number%2)
                .subscribe( group -> { group.subscribe(number -> {
                    System.out.println(group.getKey() + " " + number);
                });});
    }

    private static void groupByOddEven(){

        Observable
                .range(1,10)
                .groupBy(number -> number%2==0? "EVEN":"ODD", number -> number%2==0?
                        number*2:number*3)
                .subscribe(group -> {
                    group.subscribe(number -> {
                        System.out.println(group.getKey() + " " + number);
                    });
                });

    }

    private static void groupBy() throws InterruptedException {
        Observable
                .range(1, 10)
                .groupBy(new Function<Integer, Integer>() {
                             @Override
                             public Integer apply(Integer integer) throws Exception {
                                 if (integer % 2 == 0)
                                     return 0;
                                 else
                                     return 1;
                             }
                         }
                    )
                .subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GroupedObservable<Integer, Integer> groupedObservable) {
                        Integer key = groupedObservable.getKey();
                        groupedObservable.subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                                public void onNext(Integer integer) {
                                System.out.println("key:" + key + " " + integer);

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Thread.sleep(10*1000);
    }

}
