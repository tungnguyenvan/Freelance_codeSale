package app.tuancuong.com.tuancuong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.tuancuong.com.tuancuong.Adapter.Shopping.ShoppingAdapter;
import app.tuancuong.com.tuancuong.Model.WebModel;

public class ShoppingActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerview;

    private ShoppingAdapter shoppingAdapter;
    private List<WebModel> listWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        getWidGetFunction();
    }

    private void getWidGetFunction() {
        //addControll
        toolbar      = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        recyclerview = findViewById(R.id.recyclerview);
        initRecyclerview();
    }

    private void initRecyclerview() {
        listWeb = new ArrayList<>();
        listWeb.add(new WebModel("lazada.vn", "Lazada"));
        listWeb.add(new WebModel("lazada.vn", "Vn"));
        listWeb.add(new WebModel("lazada.vn", "FPT Shop"));
        listWeb.add(new WebModel("lazada.vn", "Shoppee"));

        shoppingAdapter = new ShoppingAdapter(this, listWeb);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(shoppingAdapter);
    }
}
