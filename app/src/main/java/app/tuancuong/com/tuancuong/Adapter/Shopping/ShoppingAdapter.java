package app.tuancuong.com.tuancuong.Adapter.Shopping;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.tuancuong.com.tuancuong.Model.WebModel;
import app.tuancuong.com.tuancuong.R;
import app.tuancuong.com.tuancuong.ViewHolder.ShoppingViewHolder;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingViewHolder>{
    private List<WebModel> listWeb;
    private Context context;

    public ShoppingAdapter(Context context, List<WebModel> listWeb){
        this.listWeb = listWeb;
    }


    @Override
    public ShoppingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_web, parent,false);

        return new ShoppingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShoppingViewHolder holder, int position) {
        holder.initWebModel(listWeb.get(position));

        //add image in item recyclerview
        //......

        //set title in item recyclerview
        holder.txt_title.setText(listWeb.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listWeb.size();
    }
}
