package com.jek.recipetaste;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        call=findViewById(R.id.btn_call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mynumber = "082286486960";
                Intent phonedial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+mynumber));
                startActivity(phonedial);
            }
        });
    };
}
