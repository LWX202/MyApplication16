package cn.edu.sdwu.android02.home.sn170507180220;

import android.app.Service;

import android.content.Intent;

import android.os.Binder;

import android.os.IBinder;

import android.util.Log;



import java.util.Random;



public class MyService2 extends Service {

    private Random random ;

    private MyBinder myBinder;

    @Override

    public void onCreate() {

        super.onCreate();

        random = new Random();

        myBinder=new MyBinder();

    }

    public MyService2() {

    }



    @Override

    public IBinder onBind(Intent intent) {

        //返回值，会返回给调用者，以后调用者与服务进行交互，都会使用此返回值。

        // TODO: Return the communication channel to the service.

        Log.i( MyService2.class.toString(),"onBind");

        return  myBinder;

    }

    @Override

    public boolean onUnbind(Intent intent) {

        Log.i(MyService2.class.toString(), "onUnbind");

        return super.onUnbind(intent);

    }

    public class MyBinder extends Binder {

        public MyService2 getRandomService() {



            return MyService2. this;

        }

    }



    //实际 与调用者进行交互的方法public int genRandom) {

    public int genRandom() {

        return random.nextInt();

    }

}