package net.rafaeltoledo.materialchef;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "net.rafaeltoledo.materialchef.TEXT";
    public static final String EXTRA_IMAGE = "net.rafaeltoledo.materialchef.IMAGE";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final String text = getIntent().getStringExtra(EXTRA_TEXT);
        final int image = getIntent().getIntExtra(EXTRA_IMAGE, 0);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(text);

        ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        imageView.setImageResource(image);
        ViewCompat.setTransitionName(imageView, EXTRA_IMAGE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // FIXME NavUtils FTW!
        }

        return super.onOptionsItemSelected(item);
    }
}