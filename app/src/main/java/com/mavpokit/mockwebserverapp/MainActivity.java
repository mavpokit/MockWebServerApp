package com.mavpokit.mockwebserverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import okhttp3.HttpUrl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.textView);

        SOVapi api = ApiProvider.provide(HttpUrl.parse("https://api.stackexchange.com/"));
        api.search("java").enqueue(new Callback<ListAnswer>() {
            @Override
            public void onResponse(Call<ListAnswer> call, Response<ListAnswer> response) {
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<ListAnswer> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}
