package com.example.deepankar.qrcodefetcher;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchQRCode(View v)
    {
        RequestQueue mVolleyQueue = Volley.newRequestQueue(this);
        TextView tv = (TextView) findViewById(R.id.editText);


        String url = "http://chart.apis.google.com/chart?chs=200x200&cht=qr&chld=|1&chl="+Uri.encode(String.valueOf(tv.getText()));
        Log.d("LOG",String.valueOf(tv.getText()));

        //volley Library
        ImageRequest ir = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response)
            {
                ImageView iv;
                iv = (ImageView) findViewById(R.id.imageView);
                iv.setImageBitmap(response);
                Log.d("LOG","Success");
            }
        }, 0, 0, null, null);

        mVolleyQueue.add(ir);
        mVolleyQueue.start();

    }




}
