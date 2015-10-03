package com.fz.friendzone;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by hugo on 9/22/15.
 */
public class RetrofitBuilder {

    private final BackendApi backendApi;
    private final String url = Constants.LOCAL_IP;

    public RetrofitBuilder() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        backendApi = retrofit.create(BackendApi.class);
    }

    public BackendApi getBackendApi() {
        return backendApi;
    }
}
