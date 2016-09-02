package com.mavpokit.mockwebserverapp;

import android.app.Application;
import android.widget.Toast;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    MockWebServer server = new MockWebServer();
    @Test

    public void test() throws Exception {


        // Schedule some responses.
        server.enqueue(new MockResponse().setBody("hello, world!"));

        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        HttpUrl url = server.url("/");

        final Dispatcher dispatcher = new Dispatcher() {

            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                System.out.println("***************************************");
                return new MockResponse().setResponseCode(404);
            }
        };

        server.setDispatcher(dispatcher);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SOVapi api = retrofit.create(SOVapi.class);

        Call<ListAnswer> call = api.search("java");

        //assertTrue(call.execute() != null);
        call.enqueue(new Callback<ListAnswer>() {
            @Override
            public void onResponse(Call<ListAnswer> call, Response<ListAnswer> response) {
                System.out.println("onResponse");
            }

            @Override
            public void onFailure(Call<ListAnswer> call, Throwable t) {
                System.out.println("onFailure");
            }
        });

        Thread.sleep(100);

    }
    @After
    public void tearDown() throws Exception {

        server.shutdown();
    }
}