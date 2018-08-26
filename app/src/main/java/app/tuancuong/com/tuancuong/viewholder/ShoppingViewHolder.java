package app.tuancuong.com.tuancuong.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.tuancuong.com.tuancuong.model.WebModel;
import app.tuancuong.com.tuancuong.R;
import app.tuancuong.com.tuancuong.WebActivity;

public class ShoppingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private View view;
    public ImageView image;
    public TextView txt_title;
    private LinearLayout layout;
    private WebModel webModel;

    public ShoppingViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;

        getWidGetFunction();
        itemView.setOnClickListener(this);
    }

    public void initWebModel(WebModel webModel){
        this.webModel = webModel;
    }

    private void getWidGetFunction() {
        //addControll
        image     = view.findViewById(R.id.image);
        txt_title = view.findViewById(R.id.txt_title);
        layout    = view.findViewById(R.id.layout);

        //addEvents
        layout.setOnClickListener(this);
    }

    public void openCard(View view, String url, String title) {
        Intent intent = new Intent(view.getContext(), WebActivity.class);
        intent.putExtra("EXTRA_URL", url);
        intent.putExtra("EXTRA_TITLE", title);
        view.getContext().startActivity(intent);
    }

    public void openBrowser(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) url = "http://" + url;
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        view.getContext().startActivity(browserIntent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layout:
                openCard(view, webModel.getUrl(), webModel.getTitle());
                break;
        }
    }
}
