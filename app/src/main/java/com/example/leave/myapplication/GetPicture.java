package com.example.leave.myapplication;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * Created by leave on 2017/12/11.
 */

public class GetPicture {
    private static String result;
    private ImageView imageView;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            imageView.setImageBitmap((Bitmap) msg.obj);
        }
    };

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     */
    public void useHttpUrlConnection(final String url, ImageView iv){
        this.imageView = iv;
        new Thread(new Runnable(){
            public void run(){
                Bitmap bitmap = UseHttpURLConnection.GetPic(url);
                Message message = Message.obtain();
                message.obj = bitmap;
                handler.sendMessage(message);
            }
        }).start();
    }

    /**
     *  创建一个获取图片的线程并执行
     *
     */
    public static String useHttpUrlConnectionGetThread(final String url,final String parameter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                result = UseHttpURLConnection.sendGet(url,parameter);
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
