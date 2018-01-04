package com.vihaan.code.transformingObservables;

import io.reactivex.Observable;

/**
 * Created by vihaanverma on 04/01/18.
 */

public class Map {

    public static void main(String[] args) throws InterruptedException {
        map();
    }

    private static void map(){

        Observable
                .range(1, 10)
                .map(number -> number %2==0? number*2: number*3)
                .subscribe(number -> {
                    System.out.println(number);
                });
    }
}
