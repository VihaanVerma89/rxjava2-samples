package com.vihaan.code.transformingObservables;

import io.reactivex.Observable;

/**
 * Created by vihaanverma on 04/01/18.
 */

public class Window {

    public static void main(String []args) {
        window();
    }

    private static void window(){

        Observable
                .range(1,10)
                .window(3)
                .subscribe(windowsObservable-> {
                    windowsObservable.subscribe(number->{
                        System.out.println(number);
                    });
                });
    }
}
