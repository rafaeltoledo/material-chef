package net.rafaeltoledo.materialchef;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import static android.support.v4.app.ActivityOptionsCompat.makeSceneTransitionAnimation;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        if (navigationView != null) {
            navigationView.setOnNavigationItemSelectedListener(this);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        if (viewPager != null && tabLayout != null) {
            viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Navigation goes here :)
        return true;
    }

    @Override
    public void onClick(View v) {
        ActivityOptionsCompat options = makeSceneTransitionAnimation(this,
                new Pair<>(v.findViewById(R.id.image), DetailActivity.EXTRA_IMAGE));

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_IMAGE, (Integer) v.getTag(R.id.image));
        intent.putExtra(DetailActivity.EXTRA_TEXT, (String) v.getTag(R.id.title));
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
