package com.vihaan.code.transformingObservables;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

/**
 * Created by vihaanverma on 04/01/18.
 */

public class Scan {
    public static void main(String []args) {
//        scan();
        scanLambda();
    }

    private static void scanLambda(){
        Observable
                .range(1,10)
                .scan((number1, number2)-> number1+number2)
                .subscribe(number -> {
                    System.out.println(number);
                });
    }

    private static void scan(){
        Observable
                .range(1,10)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer, Integer integer2) throws Exception {
                        return integer+integer2;
                    }
                })
                .subscribe(number -> {
                    System.out.println(number);
                });
    }
}
