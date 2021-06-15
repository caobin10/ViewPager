package com.datab.cn;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import com.datab.cn.adapter.LfFragmentPagerAdapter;
import com.datab.cn.fragment.Fragment1;
import com.datab.cn.fragment.Fragment2;
import com.datab.cn.fragment.Fragment3;
import com.datab.cn.fragment.Fragment4;
import com.datab.cn.fragment.Fragment5;
import com.datab.cn.fragment.Fragment6;
import com.datab.cn.view.SyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private FragmentPagerAdapter pagerAdapter;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;
    private Fragment6 fragment6;
    private RadioGroup navRg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadPager();
    }

    private void loadPager() {
        final SyncHorizontalScrollView navHSV = (SyncHorizontalScrollView) findViewById(R.id.hsv_nav);
        navHSV.setHorizontalScrollBarEnabled(false);
        navHSV.setSmoothScrollingEnabled(true);
        navRg = (RadioGroup) findViewById(R.id.rg_nav);
        navRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (requiredFields(checkedId)) return;

                for (int i = 0; i < group.getChildCount(); i++) {
                    View child = group.getChildAt(i);
                    if (child.getId() == checkedId) {
                        int scrollX = child.getLeft() - (navHSV.getWidth() - child.getWidth()) / 2;
                        navHSV.animOnScroll(scrollX);
                        if (viewPager.getCurrentItem() != i) {
                            viewPager.setCurrentItem(i);
                        }
                        break;
                    }
                }
            }
        });

        viewPager = (ViewPager) findViewById(R.id.vp_pager);

        List<Fragment> fragments = new ArrayList<>();

        fragment1 = new Fragment1();
        fragments.add(fragment1);

        fragment2 = new Fragment2();
        fragments.add(fragment2);

        fragment3 = new Fragment3();
        fragments.add(fragment3);

        fragment4 = new Fragment4();
        fragments.add(fragment4);

        fragment5 = new Fragment5();
        fragments.add(fragment5);

        fragment6 = new Fragment6();
        fragments.add(fragment6);

        pagerAdapter = new LfFragmentPagerAdapter(getFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if (requiredFields(position)) return;
                CompoundButton child = (CompoundButton) navRg.getChildAt(position);
                child.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
