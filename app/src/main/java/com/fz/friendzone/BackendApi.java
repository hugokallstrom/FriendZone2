package com.fz.friendzone;


import com.fz.friendzone.api_pojos.Token;
import com.fz.friendzone.api_pojos.User;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.POST;

public interface BackendApi {

    @POST("login/facebook")
    Call<User> login(@Body Token token);
}
