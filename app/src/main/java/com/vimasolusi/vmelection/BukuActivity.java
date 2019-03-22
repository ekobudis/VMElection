package com.vimasolusi.vmelection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import com.vimasolusi.vmelection.adapter.BukuAdapter;
import com.vimasolusi.vmelection.etities.Buku;
import com.vimasolusi.vmelection.etities.BukuResult;
import com.vimasolusi.vmelection.network.ApiClient;
import com.vimasolusi.vmelection.network.BukuService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BukuActivity extends AppCompatActivity {

    ListView listView;
    private static  String EXTRA = "extra";
    String judul = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        final EditText edtCari = (EditText)findViewById(R.id.et_cari);
        edtCari.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                judul = edtCari.getText().toString().trim();
                loadBuku(judul);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        loadBuku(judul="");
    }

    private void loadBuku(String judul) {
        BukuService service = ApiClient.getRetrofit().create(BukuService.class);
        Call<BukuResult> bukus = service.getBuku(judul);
        bukus.enqueue(new Callback<BukuResult>() {
            @Override
            public void onResponse(Call<BukuResult> call, Response<BukuResult> response) {
                tampilkan(response.body().getBuku());
            }

            @Override
            public void onFailure(Call<BukuResult> call, Throwable t) {

            }
        });
    }

    private void tampilkan(List<Buku> buku) {
        BukuAdapter bukuAdapter = new BukuAdapter(this, R.layout.item_buku, buku);
        listView = (ListView)findViewById(R.id.lv_buku);
        listView.setAdapter(bukuAdapter);
        bukuAdapter.notifyDataSetChanged();
    }
}
