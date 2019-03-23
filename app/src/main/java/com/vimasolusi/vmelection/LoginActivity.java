package com.vimasolusi.vmelection;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
//import android.transition.TransitionManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vimasolusi.vmelection.apihelper.ApiService;
import com.vimasolusi.vmelection.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText mNrp;
    private EditText mPassword;
    private Button mBtnLogin;
    ProgressBar loading;
    Context mContext;
    ApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponents();

    }

    private void initComponents() {
        mNrp = (EditText)findViewById(R.id.et_nrp);
        mPassword = (EditText)findViewById(R.id.et_password);
        mBtnLogin = (Button)findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLogin();
            }
        });
    }

    private void requestLogin() {
        mApiService.loginRequest(mNrp.getText().toString(), mPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            //loading
                            try{
                                JSONObject jsonResult = new JSONObject(response.body().string());
                                if(jsonResult.getString("error").equals( "false" )){
                                    Toast.makeText(mContext, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                    String nrp = jsonResult.getJSONObject("nrp").getString("nrp");
                                    Intent intent = new Intent(mContext, MainActivity.class);
                                    intent.putExtra("result_name", nrp);
                                    startActivity(intent);
                                }else{
                                    String error_message = jsonResult.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            }catch (JSONException e){
                                e.printStackTrace();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }else{
                            //gagal
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                    }
                });
    }


    /*private void showLoading(){
        TransitionManager.beginDelayedTransition(container);
        formContainer.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);
    }

    private void showForm(){
        TransitionManager.beginDelayedTransition(container);
        formContainer.setVisibility(View.VISIBLE);
        loader.setVisibility(View.GONE);
    }*/

}
