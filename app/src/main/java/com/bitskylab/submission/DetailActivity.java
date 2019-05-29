package com.bitskylab.submission;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_JUDUL = "extra_judul";
    public static final String EXTRA_GAMBAR = "extra_gambar";
    public static final String EXTRA_DESKRIPSI = "extra_deskripsi";

    ImageView imgIronman;
    TextView txtDeskripsi, txtNama, txtJudul;
    private String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detail Avenger");
        }

        txtDeskripsi = findViewById(R.id.txtDeskripsi);
        imgIronman = findViewById(R.id.img_item_photo);
        txtNama = findViewById(R.id.txtNama);
        txtJudul = findViewById(R.id.txtJudul);

        Intent intentThatStartThisActivity = getIntent();
        if (intentThatStartThisActivity != null) {
            String nama = intentThatStartThisActivity.getStringExtra(EXTRA_NAMA);
            String judul = intentThatStartThisActivity.getStringExtra(EXTRA_JUDUL);
            String gambar = intentThatStartThisActivity.getStringExtra(EXTRA_GAMBAR);
            String deskripsi = intentThatStartThisActivity.getStringExtra(EXTRA_DESKRIPSI);

            txtNama.setText(nama);
            txtJudul.setText(judul);
            txtDeskripsi.setText(deskripsi);
            Glide.with(this)
                    .load(gambar)
                    .apply(new RequestOptions().override(100, 100))
                    .into(imgIronman);
        }
    }
}
