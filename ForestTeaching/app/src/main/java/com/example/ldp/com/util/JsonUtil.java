package com.example.ldp.com.util;

import com.example.ldp.com.bean.BeanUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */

public class JsonUtil {
    private static Gson mGson = new Gson();

    public static <T> String serializeJson(T object) {
        return mGson.toJson(object);
    }
    public static <T> T deserializeJson(String json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }
    public static <T> T deserializeJson(JsonObject json, Class<T> clz) throws JsonSyntaxException {
        return mGson.fromJson(json, clz);
    }
    public static <T> T deserializeJson(String json, Type type) throws JsonSyntaxException {

        return mGson.fromJson(json, type);
    }


}
