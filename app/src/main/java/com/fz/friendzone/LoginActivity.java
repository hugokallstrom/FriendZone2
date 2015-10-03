package com.fz.friendzone;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.fz.friendzone.api_pojos.Token;
import com.fz.friendzone.api_pojos.User;

import java.util.Arrays;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

/**
 * Created by hugo on 10/3/15.
 */
public class LoginActivity extends ActionBarActivity {

    private static final String TAG = "LoginActivity";
    private FacebookCallback<LoginResult> facebookCallback;
    private List<String> permissions = Arrays.asList("email");
    private CallbackManager callbackManager;
    private BackendApi backendApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initApi();
        initFacebookSettings();
        facebookCallback = createFacebookCallback();
        login();
        setContentView(R.layout.activity_login);
    }

    private void initApi() {
        RetrofitBuilder retrofitBuilder = new RetrofitBuilder();
        backendApi = retrofitBuilder.getBackendApi();
    }

    private void initFacebookSettings() {
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        FacebookSdk.addLoggingBehavior(LoggingBehavior.GRAPH_API_DEBUG_INFO);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.DEVELOPER_ERRORS);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_RAW_RESPONSES);
        FacebookSdk.setApplicationId(this.getString(R.string.fb_id));
    }

    private FacebookCallback<LoginResult> createFacebookCallback() {
        return new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                String accessToken = AccessToken.getCurrentAccessToken().getToken();
                Log.d(TAG, "Token: " + accessToken);
                startMain();
             /*   Call<User> call = backendApi.login(new Token(accessToken));
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Response<User> response) {
                        if (response.isSuccess()) {
                            saveUserInfo(response.body());
                            startMain();
                            Log.d(TAG, "User:" + response.body().getUser().getEmail());
                        } else {
                            // startRegister(); ?
                            Log.d(TAG, "Error connecting to backend");
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "Error: " + t.toString());
                    }
                });*/
            }

            @Override
            public void onCancel() {
                Log.e("LoginActivity", "facebook login canceled");
            }

            @Override
            public void onError(FacebookException e) {
                Log.e("LoginActivity", "facebook login failed: " + e.toString() );
            }
        };
    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        this.startActivity(intent);
    }

    private void saveUserInfo(User user) {
        SharedPreferences userInfo = getSharedPreferences("FriendZone", MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString("firstName", user.getUser().getName());
        editor.putString("lastName", user.getUser().getLastName());
        editor.putString("email", user.getUser().getEmail());
        editor.putString("profilePicture", user.getUser().getProfilePicture());
        editor.apply();
    }

    public void login() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager loginManager = LoginManager.getInstance();
        loginManager.registerCallback(callbackManager, facebookCallback);
        loginManager.logInWithReadPermissions(this, permissions);
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
