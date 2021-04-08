package com.example.week13;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    static ApiService service = null;

    static String url = "https://jsonplaceholder.typicode.com/";


    static ApiService getService() {

        if(service == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            service = retrofit.create(ApiService.class);



        }



        return service;
    }

}
