package com.ryanharter.viewpager.sample;

import com.ryanharter.viewpager.PagerAdapter;
import com.ryanharter.viewpager.ViewPager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rharter on 11/11/13.
 */
public class VerticalPagingFragment extends Fragment {

    ViewPager mPager;
    HorizontalPagerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vertical, container, false);

        mPager = (ViewPager) v.findViewById(R.id.pager);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new HorizontalPagerAdapter(getActivity());
        mPager.setAdapter(mAdapter);
    }

    public static class HorizontalPagerAdapter extends PagerAdapter {

        static final List<PageInfo> PAGES = new ArrayList<PageInfo>();
        static {
            PAGES.add(new PageInfo(Color.BLUE, "This one swipes vertically"));
            PAGES.add(new PageInfo(Color.RED, "Simply set the orientation flag"));
            PAGES.add(new PageInfo(Color.GREEN, "Use the same PagerAdapter"));
            PAGES.add(new PageInfo(Color.MAGENTA, "Nothing Unusual"));
        }

        Context mContext;
        LayoutInflater mLayoutInflater;

        public HorizontalPagerAdapter(Context context) {
            super();
            mContext = context;
            mLayoutInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return PAGES.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = mLayoutInflater.inflate(R.layout.page, container, false);

            final PageInfo info = PAGES.get(position);

            View page = v.findViewById(R.id.container);
            page.setBackgroundColor(info.background);

            TextView content = (TextView) v.findViewById(R.id.text);
            content.setText(info.text);

            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        private static class PageInfo {
            int background;
            String text;

            PageInfo(int background, String text) {
                this.background = background;
                this.text = text;
            }
        }
    }

}
