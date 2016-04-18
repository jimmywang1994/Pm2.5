package com.example.wangwei.fragment;

import android.annotation.SuppressLint;
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
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;


public class fragment8 extends Fragment {

    public fragment8()
    {

    }
    private View mMainView;
    private String   text;
    private TextView tv = null;
    private TextView qulity=null;
    @SuppressLint("ValidFragment")
    public fragment8(String text){
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
                String areaobjectString=null;
                String quality=null;
                if(s!=null)
                {
                    try {
                        TransfromJson json=new TransfromJson();
                        Map<String,Object> chuanshamap=json.Chuansha(s);
                        JSONArray array=new JSONArray(s);
                        JSONObject Ptobject=array.getJSONObject(2);
                        aqiobjectString= (String) chuanshamap.get("aqi");
                        quality=(String)chuanshamap.get("quality");
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
                            qulity.setTextColor(Color.RED);
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
                        Log.v("aa","进入第八个");
                        tv.setClickable(true);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
    }
}
