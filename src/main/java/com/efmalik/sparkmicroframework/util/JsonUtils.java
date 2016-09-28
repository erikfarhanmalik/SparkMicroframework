package com.efmalik.sparkmicroframework.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author erik
 */
public class JsonUtils {

    private static final JsonUtils instance = new JsonUtils();
    private final Gson gson;
    private final String dateFromat = "yyyy-MM-dd HH:mm:ss.S";

    private JsonUtils() {
        gson = new GsonBuilder().setDateFormat(dateFromat).create();
    }

    public static JsonUtils getInstance() {
        return instance;
    }

    public Date parseDate(String dateString) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
            return sdf.parse(dateString);
        } catch (ParseException ex) {
            return null;
        }
    }

    public JsonObject toJsonObject(String json) {
        JsonParser jp = new JsonParser();
        JsonObject jo = (JsonObject) jp.parse(json);
        return jo;
    }

    public JsonObject toJsonObject(Object object) {
        return toJsonObject(toJson(object));
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        return getInstance().gson.fromJson(json, clazz);
    }

    public <T> T fromJson(String json, Type type) {
        return getInstance().gson.fromJson(json, type);
    }

    public String toJson(Object object) {
        return getInstance().gson.toJson(object);
    }

    public String toPrettyJson(Object object) {
        String json = toJson(object);
        return prettyJSON(json);
    }

    public void printPrettyJson(Object object) {
        System.out.println(toPrettyJson(object));
    }

    public static String prettyJSON(String uglyJSONString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJSONString);
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;
    }

    public String getDateFromat() {
        return dateFromat;
    }
}
