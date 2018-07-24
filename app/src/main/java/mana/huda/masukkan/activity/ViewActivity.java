package mana.huda.masukkan.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import mana.huda.masukkan.R;
import mana.huda.masukkan.adapter.PengaduanAdapter;
import mana.huda.masukkan.model.ResponsePengaduan;
import mana.huda.masukkan.model.SemuaPengaduan;
import mana.huda.masukkan.util.Constant;
//import mana.huda.masukkan.util.RecyclerItemClickListener;
import mana.huda.masukkan.util.api.BaseApiService;
import mana.huda.masukkan.util.api.UtilsApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import mana.huda.masukkan.R;
import mana.huda.masukkan.util.SharedPrefManager;

public class ViewActivity extends AppCompatActivity {
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.rvPengaduan)
    RecyclerView rvPengaduan;

    ProgressDialog loading;
    Context mContext;
    List<SemuaPengaduan> semuaMasukanItemList = new ArrayList<>();
    PengaduanAdapter matkulAdapter;
    BaseApiService mApiService;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();
        mContext = this;

        sharedPrefManager = new SharedPrefManager(this);
        tvEmail.setText(sharedPrefManager.getSPEmail());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabTambah);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewActivity.this, InsertActivity.class));
            }
        });

        matkulAdapter = new PengaduanAdapter(this, semuaMasukanItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPengaduan.setLayoutManager(mLayoutManager);
        rvPengaduan.setItemAnimator(new DefaultItemAnimator());

        getDataPengaduan();

    }

    private void getDataPengaduan(){
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
        mApiService.viewRequest(tvEmail.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("error").equals("false")){
                                    //jika sukses
//                                    Toast.makeText(mContext, "Berhasil Mengambil Data", Toast.LENGTH_SHORT).show();
                                    Toast.makeText(mContext, jsonRESULTS.getString("result"), Toast.LENGTH_SHORT).show();

                                } else {
                                    // Jika gagal
                                    String error_message = jsonRESULTS.getString("error_msg");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.newmessage) {
            startActivity(new Intent(ViewActivity.this, InsertActivity.class));
        } else if (item.getItemId() == R.id.logout) {
            sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
            startActivity(new Intent(ViewActivity.this, LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        return true;
    }


}
