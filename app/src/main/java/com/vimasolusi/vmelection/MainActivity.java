package com.vimasolusi.vmelection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_Nama;
    String resultName;
    TextView tv_Jabatan;
    String resultJabatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            resultName = extras.getString("result_name");
            tv_Nama.setText(resultName);
        }
    }

    private void initComponents() {
        tv_Nama=(TextView)findViewById(R.id.et_nrp);
    }
}
