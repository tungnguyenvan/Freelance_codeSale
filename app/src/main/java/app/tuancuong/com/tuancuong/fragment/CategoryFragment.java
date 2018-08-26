package app.tuancuong.com.tuancuong.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import app.tuancuong.com.tuancuong.R;
import app.tuancuong.com.tuancuong.ShoppingActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout card_sopping, card_news, card_sport,card_film, card_music, card_technology;


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

    private void openDetailActivity(Class classActivity){
        Intent intent = new Intent(getActivity(), classActivity);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_sopping:
                openDetailActivity(ShoppingActivity.class);
                break;
            case R.id.card_news:
                break;
            case R.id.card_sport:
                break;
            case R.id.card_film:
                break;
            case R.id.card_music:
                break;
            case R.id.card_technology:
                break;
        }
    }
}
