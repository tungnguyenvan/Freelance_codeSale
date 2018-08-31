package app.tuancuong.com.tuancuong.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.tuancuong.com.tuancuong.R;
import app.tuancuong.com.tuancuong.ListWebActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout card_sopping, card_news, card_sport,card_film, card_music, card_technology;

    private static final String KEY_SHOPPING = "KEY_SHOPPING";
    private static final String KEY_NEWS = "KEY_NEWS";
    private static final String KEY_SPORT = "KEY_SPORT";
    private static final String KEY_FILM = "KEY_FILM";
    private static final String KEY_MUSIC = "KEY_MUSIC";
    private static final String KEY_TECHNOLOGY = "KEY_TECHNOLOGY";

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_category, container, false);
        getWidGetFunction();
        return view;
    }

    private void getWidGetFunction() {
        //addControll
        card_sopping = view.findViewById(R.id.card_sopping);
        card_news    = view.findViewById(R.id.card_news);
        card_sport   = view.findViewById(R.id.card_sport);
        card_film    = view.findViewById(R.id.card_film);
        card_music   = view.findViewById(R.id.card_music);
        card_technology= view.findViewById(R.id.card_technology);


        //addEvents
        card_sopping.setOnClickListener(this);
        card_news.setOnClickListener(this);
        card_sport.setOnClickListener(this);
        card_film.setOnClickListener(this);
        card_music.setOnClickListener(this);
        card_technology.setOnClickListener(this);
    }

    private void openDetailActivity(Class classActivity, String KEY){
        Intent intent = new Intent(getActivity(), classActivity);
        intent.putExtra("KEY", KEY);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_sopping:
                openDetailActivity(ListWebActivity.class, KEY_SHOPPING);
                break;
            case R.id.card_news:
                openDetailActivity(ListWebActivity.class, KEY_NEWS);
                break;
            case R.id.card_sport:
                openDetailActivity(ListWebActivity.class, KEY_SPORT);
                break;
            case R.id.card_film:
                openDetailActivity(ListWebActivity.class, KEY_FILM);
                break;
            case R.id.card_music:
                openDetailActivity(ListWebActivity.class, KEY_MUSIC);
                break;
            case R.id.card_technology:
                openDetailActivity(ListWebActivity.class, KEY_TECHNOLOGY);
                break;
        }
    }
}
