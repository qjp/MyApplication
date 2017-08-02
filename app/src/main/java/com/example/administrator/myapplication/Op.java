package com.example.administrator.myapplication;

import android.util.Log;

/**
 * Created by Administrator on 2017/2/9.
 */

public class Op {
    public synchronized void plus(String name){
        Log.i("qjp","====plus1 threadname:"+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("qjp","====plus2 threadname:"+name);
    }

    public void minus(String name){
        Log.i("qjp","====minus1 threadname:"+name);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i("qjp","====minus2 threadname:"+name);
    }
}
