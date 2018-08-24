package app.tuancuong.com.tuancuong.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.tuancuong.com.tuancuong.R;

public class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private View view;
    public ImageView image;
    public TextView txt_title;
    private LinearLayout layout;

    public ShoppingViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;

        getWidGetFunction();
    }

    private void getWidGetFunction() {
        //addControll
        image     = view.findViewById(R.id.image);
        txt_title = view.findViewById(R.id.txt_title);
        layout    = view.findViewById(R.id.layout);

        //addEvents
        layout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout:

                break;
        }
    }
}
