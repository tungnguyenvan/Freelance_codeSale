package app.tuancuong.com.tuancuong;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

import app.tuancuong.com.tuancuong.utils.PrefManager;

public class IntroActivity extends TutorialActivity {
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            launchHomeScreen();
        }
        initTutorialView();
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch(false);
        Intent intent = new Intent(getBaseContext(), WebActivity.class);
        intent.putExtra("EXTRA_URL", "https://nguyenkim.com");
        intent.putExtra("EXTRA_TITLE", "Nguyen Kim");
        startActivity(intent);
        finish();
    }

    private void initTutorialView() {
        /*
        setPrevText(text); // Previous button text
        setNextText(text); // Next button text
        setFinishText(text); // Finish button text
        setCancelText(text); // Cancel button text
        setIndicatorSelected(int drawable); // Indicator drawable when selected
        setIndicator(int drawable); // Indicator drawable
        setGivePermissionText(String text); // Permission but
        */

        //Init Fragment

        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.ss_1) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#00D4BA")) // int background color
                .setDrawable(R.drawable.ss_2) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#1098FE")) // int background color
                .setDrawable(R.drawable.ss_3) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content")
                .setBackgroundColor(Color.parseColor("#CA70F3")) // int background color
                .setDrawable(R.drawable.ss_4) // int top drawable
                .setSummary("This is summary")
                .build());
    }


    @Override
    public void finishTutorial() {
        super.finishTutorial();
        launchHomeScreen();
    }
}
