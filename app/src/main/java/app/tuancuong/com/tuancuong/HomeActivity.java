package app.tuancuong.com.tuancuong;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    GridLayout mainGrid;
    LinearLayout card1, card2, card3, card4, card5, card6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //FindViewById & Events
        getWidGetFunction();
    }

    private void getWidGetFunction() {
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        mainGrid = findViewById(R.id.gridLayout);
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    public void openCard(String url, String title) {
        Intent intent = new Intent(getBaseContext(), WebActivity.class);
        intent.putExtra("EXTRA_URL", url);
        intent.putExtra("EXTRA_TITLE", title);
        startActivity(intent);
        finish();
    }

    public void openBrowser(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card1:
                openCard("http://m.facebook.com", "Facebook");
                break;
            case R.id.card2:
                openCard("https://nguyenkim.com", "Nguyen Kim");
                break;
            case R.id.card3:
                openCard("https://fptshop.com.vn", "FPT");
                break;
            case R.id.card4:
                openBrowser("https://lazada.com");
                break;
            case R.id.card5:
                openBrowser("https://dribble.com");
                break;
            case R.id.card6:
                openBrowser("https://google.com");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        openCard("https://nguyenkim.com", "Nguyen Kim");
    }
}
