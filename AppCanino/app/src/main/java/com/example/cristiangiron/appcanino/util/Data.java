package com.example.cristiangiron.appcanino.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CristianGiron on 12/06/2017.
 */

public class Data {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.130.6.227:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}

