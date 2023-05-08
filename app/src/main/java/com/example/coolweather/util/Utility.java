package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handLeProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityobject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityobject.getString("name"));
                    city.setCityCode(cityobject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
/**
 * 解析和处理服务器返回的县級数据
 * <p>
 */
public static boolean handleCountyResponse(String response, int cityId) {
 if (!TextUtils . isEmpty(response)) {
 try {
 JSONArray allCounties = new JSONArray( response);
     for (int i = 0; i < allCounties.length(); i++) {
         JSONObject county0bject = allCounties . getJS0N0bject(i);
         County county = new County();
         county . setCountyName( countyobject . getString "name"));
         county . setWeatherId (countyobject . getSt ring( "weather_ _id"));
         county。setCityId(cityId);
         county . save();
         return true;
     } catch (JSONException e) {
         e. printStackTrace();
     }
     return false;
 }
 }

