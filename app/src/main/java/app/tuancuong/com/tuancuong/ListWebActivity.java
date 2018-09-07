package app.tuancuong.com.tuancuong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.tuancuong.com.tuancuong.adapter.Shopping.ShoppingAdapter;
import app.tuancuong.com.tuancuong.model.WebModel;

public class ListWebActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerview;
    private TextView title;

    private ShoppingAdapter shoppingAdapter;
    private List<WebModel> listWeb;

    private String key = "";
    private static final String KEY_SHOPPING = "KEY_SHOPPING";
    private static final String KEY_NEWS = "KEY_NEWS";
    private static final String KEY_SPORT = "KEY_SPORT";
    private static final String KEY_FILM = "KEY_FILM";
    private static final String KEY_MUSIC = "KEY_MUSIC";
    private static final String KEY_TECHNOLOGY = "KEY_TECHNOLOGY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_web);

        getWidGetFunction();
    }

    private void getWidGetFunction() {
        //addControll
        toolbar      = findViewById(R.id.toolbar);
        title        = findViewById(R.id.title);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerview = findViewById(R.id.recyclerview);

        //InitData RecyclerView
        initDataForList();

        initRecyclerview();
    }

    private void initDataForList() {
        Intent iData = getIntent();
        key = iData.getStringExtra("KEY");
        listWeb = new ArrayList<>();
        switch (key){
            case KEY_SHOPPING:
                title.setText("Shopping"); //Thay doi image // Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
            case KEY_NEWS:
                title.setText("Tin Tuc");   //Thay doi image // Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
            case KEY_SPORT:
                title.setText("The thao");  //Thay doi image //Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
            case KEY_FILM:
                title.setText("Xem film");  //Thay doi image // Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
            case KEY_MUSIC:
                title.setText("Nghe nhac"); //Thay doi image // Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
            case KEY_TECHNOLOGY:
                title.setText("Cong nghe"); //Thay doi image // Thay doi url //thay doi title
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Lazada"));
                listWeb.add(new WebModel(R.drawable.banner_1, "https://lazada.vn", "Vn"));
                break;
        }
    }

    private void initRecyclerview() {
        shoppingAdapter = new ShoppingAdapter(this, listWeb);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(shoppingAdapter);
    }
}
