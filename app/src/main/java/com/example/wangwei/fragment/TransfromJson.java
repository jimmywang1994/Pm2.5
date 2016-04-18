package com.example.wangwei.fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Wangwei on 2015/3/12.
 */
public class TransfromJson {
    public static Map<String,Object> Pt(String jsonString)//普陀
    {
        Map<String,Object> ptmap=new HashMap<String, Object>();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            JSONObject ptjson=jsonArray.getJSONObject(0);
            Iterator i=ptjson.keys();
            while (i.hasNext())
            {
                String key=(String)i.next();
                String value=ptjson.getString(key);
                ptmap.put(key.trim(),value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  ptmap;
    }
    //swc 十五场
    public static  Map<String,Object> Swc(String jsonstring) throws JSONException {
        Map<String,Object> swcmap=new HashMap<String, Object>();
        JSONArray array=new JSONArray(jsonstring);
        JSONObject swcobject=array.getJSONObject(1);
        Iterator i=swcobject.keys();
        while (i.hasNext())
        {
            String key= (String) i.next();
            String value=swcobject.getString(key);
            swcmap.put(key.trim(),value);
        }
        return swcmap;
    }
    //hk 虹口
    public static Map<String,Object> Hk(String jsonstring) throws JSONException {
        Map<String,Object> hkmap=new HashMap<String, Object>();
        JSONArray array=new JSONArray(jsonstring);
        JSONObject hkobject=array.getJSONObject(2);
        Iterator i=hkobject.keys();
        while (i.hasNext())
        {
            String key= (String) i.next();
            String value=hkobject.getString(key);
            hkmap.put(key.trim(),value);
        }
        return hkmap;
    }
    //ssd 上师大
    public static Map<String,Object> Ssd(String jsonstring) throws JSONException {
        Map<String,Object> ssdmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject ssdobject=array.getJSONObject(3);
        Iterator i=ssdobject.keys();
        while (i.hasNext())
        {
            String key=(String) i.next();
            String value=ssdobject.getString(key);
            ssdmap.put(key.trim(),value);
        }
        return ssdmap;
    }
    //ypsp 杨浦四平
    public static Map<String,Object> Ypsp(String jsonstring) throws JSONException{
        Map<String,Object> ypspmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject ypsobject = array.getJSONObject(4);
        Iterator i=ypsobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=ypsobject.getString(key);
            ypspmap.put(key.trim(),value);
        }
        return  ypspmap;
    }
    //qpdsh 青浦淀山湖
    public static Map<String,Object> Qpdsh(String jsonstring) throws JSONException{
        Map<String,Object> qpmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject qpobject = array.getJSONObject(5);
        Iterator i=qpobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=qpobject.getString(key);
            qpmap.put(key.trim(),value);
        }
        return  qpmap;
    }
    //jinan 静安
    public static Map<String,Object> Jinan(String jsonstring) throws JSONException{
        Map<String,Object> jinanmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject jinanobject = array.getJSONObject(6);
        Iterator i=jinanobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=jinanobject.getString(key);
            jinanmap.put(key.trim(),value);
        }
        return  jinanmap;
    }
    //chuansha 川沙
    public static Map<String,Object> Chuansha(String jsonstring) throws JSONException{
        Map<String,Object> chuanshamap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject chuanshaobject = array.getJSONObject(7);
        Iterator i=chuanshaobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=chuanshaobject.getString(key);
            chuanshamap.put(key.trim(),value);
        }
        return  chuanshamap;
    }
    //pd 浦东
    public static Map<String,Object> Pd(String jsonstring) throws JSONException{
        Map<String,Object> pdmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject pdobject = array.getJSONObject(8);
        Iterator i=pdobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=pdobject.getString(key);
            pdmap.put(key.trim(),value);
        }
        return  pdmap;
    }
    //zhangjiang 张江
    public static Map<String,Object> Zhangjiang(String jsonstring) throws JSONException{
        Map<String,Object> zhangjiangmap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject zhangjiangobject = array.getJSONObject(9);
        Iterator i=zhangjiangobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=zhangjiangobject.getString(key);
            zhangjiangmap.put(key.trim(),value);
        }
        return  zhangjiangmap;
    }
    //shanghai 上海
    public static Map<String,Object> Shanghai(String jsonstring) throws JSONException{
        Map<String,Object> shanghaimap=new HashMap<String, Object>();
        JSONArray array = new JSONArray(jsonstring);
        JSONObject shanghaiobject = array.getJSONObject(10);
        Iterator i=shanghaiobject.keys();
        while (i.hasNext())
        {
            String key=(String)i.next();
            String value=shanghaiobject.getString(key);
            shanghaimap.put(key.trim(),value);
        }
        return  shanghaimap;
    }
}
