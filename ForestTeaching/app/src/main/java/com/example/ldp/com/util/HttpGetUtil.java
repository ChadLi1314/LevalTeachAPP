package com.example.ldp.com.util;


import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Description :HttpGetUtil为 网络工具类
 * Author:ldp
 * Data:2017/3/20
 */

public class HttpGetUtil {

    private static OkHttpClient okHttpClient;

    public static String SendPostHttp(String address, Map<String,String> map){
        okHttpClient = new OkHttpClient();
        final BlockingDeque<String> str = new LinkedBlockingDeque<>(1);
        /*请求头*/
      /*  RequestBody requestBody = new FormBody.Builder()
                .add("username","123454")
                .add("password","ldp")
                .build();*/

        FormBody.Builder body = new FormBody.Builder();
        Request request = new Request.Builder()
                .url(AccessAddressUtil.BASE_URL+address)
                .post(parmsDel(map,body))
                .build();
        Call call = okHttpClient.newCall(request);

        //onFailure()和onResponse()是在异步线程里执行的
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("LDP","请求失败");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("LDP","请求成功!");
                str.add(response.body().string());
              /*  Log.i("LDP","--Return 值---:"+response.body().string());*/
                Log.i("LDP","我是异步线程,线程Id为: "+Thread.currentThread().getId());
                //更新UI的操作可以用runOnUiThread()方法(只能在Activity中)
            }
        });
        try {
            return str.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";
    }


    /*
 *Description:GET HTTP Method
 * */
    public static String SendGetHttp(String address){
        okHttpClient = new OkHttpClient();
        final BlockingDeque<String> str1 = new LinkedBlockingDeque<>(1);
        /*请求头*/
        Request request = new Request.Builder()
                .url(AccessAddressUtil.BASE_URL+address)
                .build();
        Call call = okHttpClient.newCall(request);

        //onFailure()和onResponse()是在异步线程里执行的
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("LDP","请求成功!");
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                    Log.i("LDP", "--Cache---" + str);
                } else {
                    str1.add(response.body().string());
                    String str = response.networkResponse().toString();
                    Log.i("LDP", "--Network---" + str);
                }
                //更新UI的操作可以用runOnUiThread()方法(只能在Activity中)

            }
        });

        try {
            return str1.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "";

    }

    /**
     * post请求参数Method
     */
    public static RequestBody parmsDel(Map<String,String> map,FormBody.Builder body){

        for(String s:map.keySet()){
            body.add(s,map.get(s));
        }
        return body.build();
    }

}
