package com.example.smart3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * FragmentPagerAdapter 를 상속받는 아답터를 정의한다.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] VIEW_MAPNTOP_TITLES = {"HOME","TIME1","TIME2"};
    private ArrayList<Fragment> fList;

    // 아답터 생성자
    public CustomFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fList) {
        super(fm);
        this.fList = fList;
    }

    // tab title를 반환 함수.
    @Override
    public CharSequence getPageTitle(int position) {

        return VIEW_MAPNTOP_TITLES[position];
    }

    // 해당 프라그먼트 호출 함수.
    @Override
    public Fragment getItem(int position) {
        return this.fList.get(position);
    }

    @Override
    public int getCount() {
        return fList.size();
    }
}