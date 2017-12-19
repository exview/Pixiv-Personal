package com.example.leave.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by leave on 2017/12/11.
 */

public class UseHttpURLConnection {

    /**
     * 通过URL获取图片
     * @param url
     * @return
     */
    public static Bitmap GetPic(String url)
    {
        Bitmap bitmap;
        try{
            URL myurl = new URL(url);
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) myurl.openConnection();
            con.setConnectTimeout(6000);
            con.setReadTimeout(60000);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Connection","Keep-Alive");
            con.connect();
            InputStream is = con.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            return bitmap;
        }catch(FileNotFoundException e){
            System.out.println("找不到图片");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 请求返回值为String类型
     * @param url
     * @param param     参数格式为type=content&type=content
     * @return
     */
    public static String sendGet(String url, String param)
    {
        String result = "";
        String urlName = url;
        if(param != null)
            urlName = url + "?" + param;
        try {
            URL readUrl = new URL(urlName);
            HttpURLConnection con = (HttpURLConnection) readUrl.openConnection();
            con.setConnectTimeout(6000);
            con.setReadTimeout(60000);
            con.setDoInput(true);
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.setRequestProperty("Connection","Keep-Alive");
            con.connect();
            try(BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
                String line;
                while((line = in.readLine()) != null)
                {
                    result += "\n" + line;
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
