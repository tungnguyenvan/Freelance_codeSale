package app.tuancuong.com.tuancuong;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.tuancuong.com.tuancuong.adapter.MenuWeb.MenuWebAdapter;

public class MenuActivity extends AppCompatActivity{
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_web);

        getWidGetFunction();
    }

    private void getWidGetFunction() {
        //addcontrols
        toolbar   = findViewById(R.id.toolbar);
        tablayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        initViewPager();
    }

    private void initViewPager() {
        tablayout.setupWithViewPager(viewpager);
        MenuWebAdapter menuWebAdapter = new MenuWebAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(menuWebAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
