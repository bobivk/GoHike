package com.example.mark.gohike;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Path pathReceived = (Path) getIntent().getSerializableExtra("Path sent");

        ImageSwitcher imageSwitcher = findViewById(R.id.imageswitcher);
        imageSwitcher.setImageResource(pathReceived.image);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                return imageView;
            }
        });

        TextView pathNameTV = findViewById(R.id.pathName);
        pathNameTV.setText(pathReceived.name);

        TextView pathDescTv = findViewById(R.id.pathDesc);
        pathDescTv.setText(pathReceived.description);

        TextView pathDifficultyTV = findViewById(R.id.pathDiff);
        pathDifficultyTV.setText(pathReceived.difficulty);

        TextView pathRatingTV = findViewById(R.id.pathRating);
        pathRatingTV.setText(pathReceived.rating);

        TextView pathLengthTV = findViewById(R.id.pathLength);
        pathLengthTV.setText(pathReceived.length);

    }
}
