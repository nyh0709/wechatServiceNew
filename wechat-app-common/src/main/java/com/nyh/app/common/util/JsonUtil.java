package com.nyh.app.common.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
	/**
     * getValue from json
     * 
     * @param jsonString,key
     * @return
     */
	public static String getValue(String jsonString,String key){
		JsonObject asJsonObject = new JsonParser().parse(jsonString).getAsJsonObject();
		JsonElement jsonElement = asJsonObject.get(key);
		String result = jsonElement.toString();
		return result;
	}
	
	/**
     * javabean to json
     * 
     * @param onject
     * @return
     */
    public static String javabeanToJson(Object object) {
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

    /**
     * list to json
     * 
     * @param list
     * @return
     */
    public static String listToJson(List<Object> list) {

        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    /**
     * map to json
     * 
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Object> map) {

        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }
    
    /**
     * json to javabean
     * @param <T>
     * 
     * @param json
     * @return 
     */
    public static <T> T jsonToJavaBean(String json,Class<T> beanClass) {
        Gson gson = new Gson();
        return gson.fromJson(json, beanClass);//对于javabean直接给出class实例
    }

//    /**
//     * json字符串转List集合
//     * @param <T>
//     * @return 
//     * @throws IllegalAccessException 
//     * @throws InstantiationException 
//     */
//
//    public static <T> List<T> jsonToList(String json,Class<T> beanClass) throws InstantiationException, IllegalAccessException {
//        Gson gson = new Gson();
//        List<T> objs = gson.fromJson(json, new TypeToken<List<T>>() {
//        }.getType());//对于不是类的情况，用这个参数给出
//        return objs;
//    }
//
//    public static void jsonToMap(String json) {
//        // TODO Auto-generated method stub
//        Gson gson = new Gson();
//        Map<String, Person> maps = gson.fromJson(json, new TypeToken<Map<String, Person>>() {
//        }.getType());
//        for (Map.Entry<String, Person> entry : maps.entrySet()) {
//            System.out.println("key: " + entry.getKey() + "  " + "value: " + entry.getValue());
//
//        }
//    }
	

}
