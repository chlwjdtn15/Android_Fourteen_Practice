package com.example.week13;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.List;

import  retrofit2.Call;
import retrofit2.http.GET;


public interface ApiService {


    @GET("todos")
    Call<List<TodoItem>> getList();

    @GET("todos")
    Call<JSONArray> getListAsJason();


}
