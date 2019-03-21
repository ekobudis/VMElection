package com.vimasolusi.vmelection;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.TransitionManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private EditText mNrp;
    private EditText mPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindWidget();
        resizeIcon();
        
        setupWidgetEventListener();
    }

    private void setupWidgetEventListener() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!mNrp.getText().toString().equals("")) &&
                (!mPassword.getText().toString().equals(""))){
                    Log.i("NRP", mNrp.getText().toString());
                    Log.i("Password", mPassword.getText().toString());

                    Context context = getApplicationContext();
                    String string = "NRP : " + mNrp.getText().toString()
                            + "\nPassword : " + mPassword.getText().toString();

                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, string, duration);

                    TextView xview = (TextView) toast.getView().findViewById(android.R.id.message);
                    if (xview != null){
                        xview.setGravity(Gravity.LEFT);
                        xview.setBackgroundColor(Color.parseColor("#082399"));
                        xview.setTextColor(Color.parseColor("#EF343D"));
                        xview.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f);
                        xview.setPadding(0, 0,0,0);
                    }

                    toast.show();
                } else {
                    String nrp = mNrp.getText().toString();
                    String pass = mPassword.getText().toString();

                    if(TextUtils.isEmpty(nrp)){
                        mNrp.setError("NRP Tidak ditemukan!");
                        Log.i("NRP", "is Emptu");
                    }else{
                        Log.i("NRP", mNrp.getText().toString());
                    }

                    if(TextUtils.isEmpty(pass)){
                        mPassword.setError("Password Tidak sesuai!");
                        Log.i("Password", "is Emptu");
                    }else{
                        Log.i("Password", mPassword.getText().toString());
                    }

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Something wrong!\nPlease input nrp and password",
                            Toast.LENGTH_LONG);

                    toast.setGravity(Gravity.CENTER, 0  , 150);

                    TextView sview = (TextView) toast.getView().findViewById(android.R.id.message);
                    if (sview != null){
                        sview.setGravity(Gravity.CENTER);
                        sview.setBackgroundColor(Color.parseColor("#082399"));
                        sview.setTextColor(Color.parseColor("#EF343D"));
                        sview.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f);
                        sview.setPadding(0, 0,0,0);
                    }

                    toast.show();

                    return;
                }
            }
        });
    }

    private void resizeIcon() {
        final float density = getResources().getDisplayMetrics().density;
        final Drawable nrpIcon = getResources().getDrawable(R.drawable.ic_user_icon);
        final Drawable pswdIcon = getResources().getDrawable(R.drawable.ic_user_lock);

        final int widthU = Math.round(25 * density);
        final int heightU = Math.round(25 * density);

        final int widthP = Math.round(29 * density);
        final int heightP = Math.round(29 * density);

        nrpIcon.setBounds(0,0,widthU, heightU);
        mNrp.setCompoundDrawables(nrpIcon, null, null, null);

        pswdIcon.setBounds(0, 0, widthP, heightP);
        mPassword.setCompoundDrawables(pswdIcon,null, null,null);
    }

    private void bindWidget() {
        mNrp = (EditText) findViewById(R.id.et_nrp);
        mPassword = (EditText) findViewById(R.id.et_password);
        mBtnLogin = (Button) findViewById(R.id.btn_login);

    }

    private void showLoading(){
        TransitionManager.beginDelayedTransition(container);
        formContainer.setVisibility(View.GONE);
        loader.setVisibility(View.VISIBLE);
    }

    private void showForm(){
        TransitionManager.beginDelayedTransition(container);
        formContainer.setVisibility(View.VISIBLE);
        loader.setVisibility(View.GONE);
    }

}
