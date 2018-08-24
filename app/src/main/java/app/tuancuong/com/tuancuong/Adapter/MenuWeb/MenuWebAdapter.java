package app.tuancuong.com.tuancuong.Adapter.MenuWeb;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import app.tuancuong.com.tuancuong.MenuWeb.Fragment.CategoryFragment;
import app.tuancuong.com.tuancuong.MenuWeb.Fragment.HotFragment;
import app.tuancuong.com.tuancuong.R;

public class MenuWebAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment;
    private List<String> listTitle;
    private Context context;

    public MenuWebAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        listFragment = new ArrayList<>();
        listFragment.add(new HotFragment());
        listFragment.add(new CategoryFragment());

        listTitle = new ArrayList<>();
        listTitle.add(context.getResources().getString(R.string.title_page_hot));
        listTitle.add(context.getResources().getString(R.string.title_page_category));
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
