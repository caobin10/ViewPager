package com.datab.cn.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datab.cn.R;

/**
 * Created by Administrator on 2021/6/8.
 */

public class ProfileFragment extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_main_profile, container, false);
        return view;
    }
}
