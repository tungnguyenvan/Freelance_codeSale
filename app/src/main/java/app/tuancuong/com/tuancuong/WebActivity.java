package app.tuancuong.com.tuancuong;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import im.delight.android.webview.AdvancedWebView;


public class WebActivity extends AppCompatActivity implements AdvancedWebView.Listener {
    private ViewTreeObserver.OnScrollChangedListener mOnScrollChangedListener;
    SwipeRefreshLayout swipeRefreshLayout;
    private AdvancedWebView mWebView;
    String url;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        Intent intent = getIntent();
        // Get the extras (if there are any)
        Bundle extras = intent.getExtras();
        if (extras != null) {
            url = extras.getString("EXTRA_URL");
            title = extras.getString("EXTRA_TITLE");
        } else {
            url = "https://nguyenkim.com";
            title = "Nguyen Kim";
        }

        Toolbar toolbarTop =  findViewById(R.id.toolbar_top);
        toolbarTop.setTitle("");
        TextView mTitle = toolbarTop.findViewById(R.id.toolbar_title);
        mTitle.setText(title);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp);
        toolbarTop.setNavigationIcon(drawable);
        setSupportActionBar(toolbarTop);

        swipeRefreshLayout = findViewById(R.id.swipe);
        mWebView = findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // chromium, enable hardware acceleration
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String urlOver) {
                if (urlOver.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(urlOver));
                    startActivity(intent);
                    return true;
                } else {
                    url = urlOver;
                    swipeRefreshLayout.setRefreshing(true);
                }
                return false;
            }
        });
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setJavaScriptEnabled(true);

        toolbarTop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = "https://nguyenkim.com";
                title = "Nguyen Kim";
                Intent openMainActivity= new Intent(WebActivity.this, WebActivity.class);
                openMainActivity.putExtra("EXTRA_URL", url);
                openMainActivity.putExtra("EXTRA_TITLE", title);
                startActivity(openMainActivity);
                finish();
            }
        });
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                LoadWebViewUrl(url);
            }
        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                LoadWebViewUrl(url);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.web, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                startActivity(new Intent(WebActivity.this, HomeActivity.class));
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        swipeRefreshLayout.getViewTreeObserver().addOnScrollChangedListener(mOnScrollChangedListener =
                new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {
                        if (mWebView.getScrollY() == 0)
                            swipeRefreshLayout.setEnabled(true);
                        else
                            swipeRefreshLayout.setEnabled(false);

                    }
                });
    }

    @Override
    protected void onResume() {
        mWebView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mWebView.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        swipeRefreshLayout.getViewTreeObserver().removeOnScrollChangedListener(mOnScrollChangedListener);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mWebView.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        super.onBackPressed();
    }

    private void LoadWebViewUrl(String url) {
        if (isInternetConnected())
            mWebView.loadUrl(url);
        else {
            Toast.makeText(this, "Oops!! There is no internet connection. Please enable your internet connection.", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isInternetConnected() {
        // At activity startup we manually check the internet status and change
        // the text status
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
        return true;
        else
        return false;

    }


    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onPageFinished(String url) {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }
}
