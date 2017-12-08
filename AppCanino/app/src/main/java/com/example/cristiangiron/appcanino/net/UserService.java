package com.example.cristiangiron.appcanino.net;

import com.example.cristiangiron.appcanino.User;
import com.example.cristiangiron.appcanino.models.SimpleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.POST;

/**
 * Created by CristianGiron on 12/06/2017.
 */

public interface UserService {
    @POST("users/login")
    Call<SimpleResponse> login(@Body User user);


    @POST("users/registro")
    Call<SimpleResponse> registro(@Body User user);



}
