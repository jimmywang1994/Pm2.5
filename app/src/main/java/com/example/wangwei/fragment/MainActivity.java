package com.example.wangwei.fragment;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends FragmentActivity {

    private LinearLayout layout1;
    private ViewPager vp;
    private ListView lv;
    //页面列表
    private ArrayList<Fragment> fragmentArrayList=new ArrayList<Fragment>();
    //标题列表
    private ArrayList<String> titlelist=new ArrayList<String>();
    //通过pagerTabStrip可以设置标题的属性
    private PagerTabStrip pagerTabStrip;//标示线
    private PagerTitleStrip pagerTitleStrip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp= (ViewPager) findViewById(R.id.viewPager);
        layout1= (LinearLayout) findViewById(R.id.layout1);
        Calendar calendar=Calendar.getInstance();
        int hour;
        hour=calendar.get(Calendar.HOUR_OF_DAY);
       /* if(hour>=17)
        {
            layout1.setBackgroundResource(R.drawable.bg);
        }*/
        pagerTabStrip=(PagerTabStrip) findViewById(R.id.pagertab);
        //设置下划线的颜色
        pagerTabStrip.setTabIndicatorColor(getResources().getColor(android.R.color.holo_green_dark));
        //设置背景的颜色
        pagerTabStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
		pagerTitleStrip=(PagerTitleStrip) findViewById(R.id.pagertab);
	    //设置背景的颜色
		pagerTitleStrip.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        fragmentArrayList.add(new fragment1());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment2());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment3());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment4());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment5());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment6());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment7());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment8());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment9());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment10());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fragmentArrayList.add(new fragment11());

        titlelist.add("普陀");
        titlelist.add("十五厂");
        titlelist.add("虹口");
        titlelist.add("徐汇上师大");
        titlelist.add("青浦淀山湖");
        titlelist.add("杨浦四漂");
        titlelist.add("静安监测点");
        titlelist.add("浦东川沙");
        titlelist.add("浦东新区");
        titlelist.add("浦东张江");
        titlelist.add("上海");
        vp.setOffscreenPageLimit(1);
        vp.setAdapter(new pagerAdapter(getSupportFragmentManager(), fragmentArrayList, titlelist));
        if(!isConn(getApplicationContext())){
            setNetworkMethod(MainActivity.this);
        }
    }

    //检查是否联网
    public static boolean isConn(Context context){
        boolean bisConnFlag=false;
        ConnectivityManager conManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = conManager.getActiveNetworkInfo();
        if(network!=null){
            bisConnFlag=conManager.getActiveNetworkInfo().isAvailable();
        }
        return bisConnFlag;
    }

    //设置网络提示
    public static void setNetworkMethod(final Context context){
        //提示对话框
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("网络设置提示").setMessage("网络连接不可用,是否进行设置?").setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                Intent intent=null;
                //判断手机系统的版本  即API大于10 就是3.0或以上版本
                if(android.os.Build.VERSION.SDK_INT>10){
                    intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                }else{
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.settings","com.android.settings.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.intent.action.VIEW");
                }
                context.startActivity(intent);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        }).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
