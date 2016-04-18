package com.example.wangwei.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;


public class fragment1 extends Fragment {

    //@Override
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);
    }*/
    public fragment1()
    {

    }
    private View mMainView;
    private RelativeLayout relativeLayout1;
    private String   text;
    private TextView tv = null;
    private TextView qulity=null;
    private ListView listview;
    private  final  String a[]=new String[]{"first","second","third","fourth","fifth"};
    @SuppressLint("ValidFragment")
    public fragment1(String text){
        super();
        this.text = text;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.v("huahua", "fragment1-->onCreate()");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        mMainView = inflater.inflate(R.layout.activity_fragment1, (ViewGroup)getActivity().findViewById(R.id.viewPager), false);
        tv = (TextView)mMainView.findViewById(R.id.tv1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("aaa","进入点击事件");
            }
        });
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.v("aaa","进入长按事件");
                /*listview= (ListView) mMainView.findViewById(R.id.listView1);
                new AlertDialog.Builder(mMainView.getContext())
                        .setTitle("标题")
                        .setMessage("简单消息框")
                        .setPositiveButton("确定", null)
                        .show();*/
                //listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,a));
                return true;
            }
        });
        qulity=(TextView)mMainView.findViewById(R.id.quality);
        ondata();
    }

    /**
     * 覆盖此函数，先通过inflater inflate函数得到view最后返回
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*View v = inflater.inflate(R.layout.activity_fragment1, container, false);
        tv = (TextView)v.findViewById(R.id.tv1);
        ondata();
        return v;*/
        ViewGroup p = (ViewGroup) mMainView.getParent();
        if (p != null) {
            p.removeAllViewsInLayout();
            Log.v("huahua", "fragment1-->移除已存在的View");
        }
        return  mMainView;
    }

    private void ondata()
    {
        new  AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... params) {
                try {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BufferedReader content=new BufferedReader(new InputStreamReader(new URL("http://www.pm25.in/api/querys/pm2_5.json?city=%E4%B8%8A%E6%B5%B7&token=5j1znBVAsnSf5xQyNQyq").openStream(),"utf-8"));
                    StringBuffer buffer=new StringBuffer();
                    String data=null;
                    while ((data=content.readLine())!=null)
                    {
                        buffer.append(data.toString());
                    }
                    content.close();
                    return  buffer.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                String aqiobjectString=null;
                String quality=null;
                //String dqstring=null;
                if(s!=null)
                {
                    try {
                        TransfromJson json=new TransfromJson();
                        Map<String,Object> ptmap=json.Pt(s);
                        JSONArray array=new JSONArray(s);
                        JSONObject Ptobject=array.getJSONObject(0);
                        aqiobjectString= (String) ptmap.get("aqi");
                        quality=(String) ptmap.get("quality");

                        //tv.setTextSize(60f);
                        if(Integer.parseInt(aqiobjectString)>=0&&Integer.parseInt(aqiobjectString)<=50)
                        {
                            tv.setTextColor(Color.GREEN);
                            qulity.setTextColor(Color.GREEN);
                        }
                        else if (Integer.parseInt(aqiobjectString)>=51&&Integer.parseInt(aqiobjectString)<=100)
                        {
                            tv.setTextColor(Color.YELLOW);
                            qulity.setTextColor(Color.YELLOW);
                        }
                        else if (Integer.parseInt(aqiobjectString)>=101&&Integer.parseInt(aqiobjectString)<=150)
                        {
                            tv.setTextColor(tv.getResources().getColor(R.color.orange));
                            qulity.setTextColor(qulity.getResources().getColor(R.color.orange));
                        }
                        else if (Integer.parseInt(aqiobjectString)>=151&&Integer.parseInt(aqiobjectString)<=200)
                        {
                            tv.setTextColor(Color.RED);
                            qulity.setTextColor(Color.GREEN);
                        }
                        else if (Integer.parseInt(aqiobjectString)>=201&&Integer.parseInt(aqiobjectString)<=300)
                        {
                            tv.setTextColor(tv.getResources().getColor(R.color.purple));
                            qulity.setTextColor(qulity.getResources().getColor(R.color.purple));
                        }
                        else if (Integer.parseInt(aqiobjectString)>=301&&Integer.parseInt(aqiobjectString)<=500)
                        {
                            tv.setTextColor(tv.getResources().getColor(R.color.maroon));
                            qulity.setTextColor(qulity.getResources().getColor(R.color.maroon));
                        }
                        tv.setText(aqiobjectString.toString());
                        qulity.setText(quality.toString());
                        Log.v("aa","进入第一个");
                        tv.setClickable(true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
    }
}
