package com.example.leave.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;

import static com.example.leave.myapplication.R.*;

public class MainActivity extends AppCompatActivity {
    private Picture pic;
    private ArrayList<Picture> pics;
    private int i=1;
    private JSONArray ja;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        pics = new ArrayList<>();

        String result = GetPicture.useHttpUrlConnectionGetThread("https://api.imjad.cn/pixiv/v1/","content=ugoira&page="+i+"&per_page=10");

        JSONObject jsonObject = JSONObject.fromString(result);
        String str = jsonObject.get("response").toString();
        ja = JSONArray.fromString(str);
        Gson gson = new Gson();
        pic = new Gson().fromJson(ja.getString(1), Picture.class);
        for(int i=0;i<ja.length();i++)
        {
            Picture p = new Gson().fromJson(ja.getString(i), Picture.class);
            pics.add(p);
        }
    }

    /*public void picture(View view) {
        ImageView iv = (ImageView) findViewById(R.id.show);
        String url = "https://i.pximg.net/c/480x960/img-master/img/2017/12/10/19/08/07/66238370_p0_master1200.jpg";
        new GetPicture().useHttpUrlConnection(pic.getImage_urls().get("px_480mw").toString(),iv);
    }

    public void text(View view) {
        for(int i=0;i<(int)pics.size();i++)
        {
            Toast.makeText(this,pics.get(i).getTitle(),Toast.LENGTH_SHORT).show();
        }
    }*/


    public void test(View view) {
        ArrayList<String> title = new ArrayList<>();
        for(int i=0; i<pics.size();i++)
        {
            title.add(pics.get(i).getTitle());
        }
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, title);
        final ListView lv = (ListView) findViewById(R.id.oses);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = lv.getItemAtPosition(position).toString();
                int i=0;
                for(; i<pics.size();i++)
                {
                    if(title.equals(pics.get(i).getTitle()))
                    {
                        break;
                    }
                }
                ImageView iv = (ImageView) findViewById(R.id.show);
                new GetPicture().useHttpUrlConnection(pics.get(i).getImage_urls().get("px_480mw"),iv);
            }
        });
    }
}
