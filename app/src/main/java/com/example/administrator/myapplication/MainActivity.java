package com.example.administrator.myapplication;

import android.accounts.Account;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import static android.R.attr.name;

/**
 *
 */

public class MainActivity extends AppCompatActivity {

    private final String tag = "qjp";
    private EditText ed = null;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*OkHttpClient mOKHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();*/

        ImageLoader il = new ImageLoader();
        il.displayImage("1");
        il.displayImage("2");
        il.displayImage("3");
        il.displayImage("4");
        il.displayImage("5");
        il.displayImage("6");
        il.displayImage("7");il.displayImage("8");




    }

    public class ImageLoader{

        ImageCache mImageCache = new ImageCache();

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        public void displayImage(final String tag){

            pool.submit(new Runnable() {
                @Override
                public void run() {
                    MImage bitmap1 = downloadImage(tag);
                    Log.i("qjp","tag:"+tag+" mimage.tag:"+bitmap1.getTag());
                }
            });
        }
        public MImage downloadImage(String imageUrl){
            MImage m = new MImage();

            try {
                if(count==0){
                    count++;
                    Thread.sleep(3000);
                }else{
                    Thread.sleep(2000);
                }
                m.setTag(imageUrl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return m;
        }
    }

    public class ImageCache{

    }
    public class MImage{
        private String tag;

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getTag() {
            return tag;
        }
    }
    private int count = 0;

    //重写子类接口后原来接口失效
    /*Me xx = new Me() {
        @Override
        protected int sizeOf() {
            return 2;
        }
    };
    Log.i("qjp","@@@:"+xx.callSize()+" cpu:"+Runtime.getRuntime().availableProcessors());

    class Me {
        protected int sizeOf() {
            return 1;
        }
        public int callSize(){
            return sizeOf();
        }
    }*/
    //线程同步 线程唤醒。
    /* Account acct = new Account("俊鹏",0);
        new DrawThread("取钱者",acct,800).start();
        new DepositThread("存款者A",acct,800).start();
        new DepositThread("存款者B",acct,800).start();
        new DepositThread("存款者C",acct,800).start();

    public class  Account{
        private String accountNo;
        private double balance;
        public Account(){};

        public Account(String AccountNo,double balance){
            this.accountNo = accountNo;
            this.balance = balance;
        }

        public double getBalance(){
            return this.balance;
        }

        public synchronized void draw(double drawAmount){
            Log.i("qjp",Thread.currentThread().getName()+" draw:");
            try{
                if(!flag){
                    wait();
                }else{
                    System.out.println(Thread.currentThread().getName()+"取钱"+drawAmount);
                    balance-=drawAmount;
                    Log.i("qjp","账号余额为:"+balance);
                    flag = false;
                    notifyAll();
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }

        public synchronized void deposit(double depopsitAmount){
            Log.i("qjp",Thread.currentThread().getName()+" deposit:");
            try{
                if(flag){
                    wait();
                }else{
                    Log.i("qjp", Thread.currentThread().getName()+" 存款:"+depopsitAmount);
                    balance+=depopsitAmount;
                    Log.i("qjp","账户余额为："+balance);
                    flag= true;
                    notifyAll();
                }
            }catch (InterruptedException ex){ex.printStackTrace();}
        }
    }

    public class DrawThread extends  Thread{
        private  Account account;
        private double drawAmount;
        public DrawThread(String name,Account account,double drawAmount){
            super(name);
            this.account = account;
            this.drawAmount = drawAmount;
        }
        public void run(){
            for(int i =0;i<100;i++){
                account.draw(drawAmount);
            }
        }
    }

    public class DepositThread extends Thread{
        private  Account account;
                private double depositAmount;
                public DepositThread(String name,Account account,double depositAmount){
            super(name);
            this.account = account;
            this.depositAmount = depositAmount;
        }
        public void run(){
            for(int i =0;i<100;i++){
                account.deposit(depositAmount);
            }
        }
    }*/



    /*class Thread1 extends  Thread{
        private Account account = null;
        public Thread1(Account account){
            this.account = account;
        };
        @Override
        public void run() {
            super.run();
            for(int i=0;i<10;i++){
                account.plus();
            }

        }
    }

    class Thread2 extends  Thread{
        private Account account = null;
        public Thread2(Account account){
            this.account = account;
        };
        @Override
        public void run() {
            super.run();
            for(int i=0;i<3;i++){
                account.minus();
            }

        }
    }


    class Account {
        private int count = 0;

        public synchronized void plus() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            Log.i("qjp", "plus count:" + count);
            Thread.yield();
        }

        public synchronized void minus() {
            Log.i("qjp", "minus count before:" + count);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            Log.i("qjp", "minus count after:" + count);
        }
    }*/
    
    /*test t = new test();

        Thread2 th = new Thread2(t);
        th.setPriority(Thread.MAX_PRIORITY);
        th.start();
        new Thread1(t).start();

    class Thread1 extends  Thread{
        private test tt = null;
        public Thread1(test t){
            tt = t;
        };
        @Override
        public void run() {
            super.run();
            tt.A();
        }
    }

    class Thread2 extends  Thread{
        private test tt = null;
        public Thread2(test t){
            tt = t;
        };
        @Override
        public void run() {
            super.run();
            tt.B();
        }
    }

    class test{
        public  synchronized  void A(){
            Log.i(tag,"=====AAA1");
            //B();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.i(tag,"=====AAA3");
        }

        public synchronized void B(){
            Log.i(tag,"=====BBB");
        }
    }*/



   /* @Override
    protected void onResume() {
        super.onResume();
        Log.i("qjp", "======onResume:");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("qjp", "======onPause:");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("qjp", "======onStart:");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("qjp", "======onRestart:");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("qjp", "======onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("qjp", "======onDestroy:");
    }*/
}
