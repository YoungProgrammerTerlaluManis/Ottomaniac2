package com.blogspot.yourfavoritekaisar.ottomaniac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imgDetailSultan)
    ImageView imgDetailSultan;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.txt_Bio)
    TextView txtBio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        txtDetail.setText(getIntent().getStringExtra("ns"));
        txtBio.setText(getIntent().getStringExtra("ds"));
        Glide.with(this).load(getIntent().getIntExtra("gs",0)).into(imgDetailSultan);


    }
}
