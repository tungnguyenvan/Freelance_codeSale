package app.tuancuong.com.tuancuong.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import app.tuancuong.com.tuancuong.R;
import app.tuancuong.com.tuancuong.WebActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView imgTinHot;
    private LinearLayout card1, card2, card3, card4, card5, card6, card_weather, rate, gold_price;

    public HotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hot, container, false);
        getWidGetFunction();
        return view;
    }

    private void getWidGetFunction() {
        card1     = view.findViewById(R.id.card1);
        card2     = view.findViewById(R.id.card2);
        card3     = view.findViewById(R.id.card3);
        card4     = view.findViewById(R.id.card4);
        card5     = view.findViewById(R.id.card5);
        card6     = view.findViewById(R.id.card6);
        imgTinHot = view.findViewById(R.id.imgTinHot);
        card_weather= view.findViewById(R.id.card_weather);
        rate      = view.findViewById(R.id.rate);
        gold_price= view.findViewById(R.id.gold_price);


        //addEvents
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card6.setOnClickListener(this);
        imgTinHot.setOnClickListener(this);
        card_weather.setOnClickListener(this);
        rate.setOnClickListener(this);
        gold_price.setOnClickListener(this);
    }

    private void openCard(String url, String title){
        Intent intent = new Intent(getContext(), WebActivity.class);
        intent.putExtra("EXTRA_URL", url);
        intent.putExtra("EXTRA_TITLE", title);
        startActivity(intent);
    }

    private void openBrowser(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card1 :
                openBrowser("https://fptshop.com.vn");
                break;
            case R.id.card2:
                openBrowser("https://lazada.com");
                break;
            case R.id.card3:
                openCard("https://24h.com.vn", "24h");
                break;
            case R.id.card4:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.card5:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.card6:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.imgTinHot:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.card_weather:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.rate:
                openCard("https://shopee.vn", "Shopee");
                break;
            case R.id.gold_price:
                openCard("https://shopee.vn", "Shopee");
                break;
        }
    }
}
