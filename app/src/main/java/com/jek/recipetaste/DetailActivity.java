package com.jek.recipetaste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_share;
    TextView name1, dura1, detail1;
    public static String images;
    ImageView imgs;
    Intent shareIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final String Nama, Durasi, Detail,Images;


        Nama = getIntent().getStringExtra("nama");
        Durasi = getIntent().getStringExtra("durasi");
        Detail = getIntent().getStringExtra("informasi");
        Images = getIntent().getStringExtra("gambar");
        name1 = (TextView) findViewById(R.id.name);
        detail1 = (TextView) findViewById(R.id.detail);
        dura1 = (TextView) findViewById(R.id.durasi);
        imgs = (ImageView) findViewById(R.id.imgq);
        name1.setText(Nama);
        dura1.setText(Durasi);
        detail1.setText(Detail);
        Glide.with(getApplicationContext())
                .load(Images)
                .apply(new RequestOptions())
                .into(imgs);

        btn_share = (Button) findViewById(R.id.btn_share);
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sharebody = getIntent().getStringExtra(Nama);
                shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "RecipeTaste");
                shareIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
