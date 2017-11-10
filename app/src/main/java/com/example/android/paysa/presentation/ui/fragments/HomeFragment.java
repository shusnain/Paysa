package com.example.android.paysa.presentation.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.utilities.CardUtil;
import com.example.android.paysa.domain.utilities.LoginUtils;
import com.example.android.paysa.presentation.ui.activities.CardSwipeFragment;
import com.example.android.paysa.presentation.ui.activities.CreateJobActivity;
import com.example.android.paysa.presentation.ui.activities.CreateUserProfileActivity;
import com.example.android.paysa.presentation.ui.activities.LoginActivity;
import com.example.android.paysa.presentation.ui.activities.NavigationActivity;
import com.example.android.paysa.presentation.ui.activities.UserProfileActivity;
import com.example.android.paysa.presentation.ui.adapters.HomeViewPagerAdapter;

public class HomeFragment extends android.support.v4.app.Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private View mView;

    public HomeFragment(){

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home);
//
//        init();
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        return mView;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getActivity().getMenuInflater();
//        inflater.inflate(R.menu.home, menu);
//        return true;
//    }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.home, menu);
//    }


    private void init(){

        mViewPager = mView.findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        mTabLayout = mView.findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.SAVED), "Saved");
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.APPLIED), "Applied");
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.OFFERED), "Offered");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Context context = getContext();
        if(id == R.id.action_create_job){
            Intent startCreateJobActivity = new Intent(context, CreateJobActivity.class);
            startActivity(startCreateJobActivity);
            return true;
        }
        if(id == R.id.action_create_user_profile){
            Intent startCreateUserProfileActivity = new Intent(context, CreateUserProfileActivity.class);
            startActivity(startCreateUserProfileActivity);
            return true;
        }
        if(id == R.id.action_card_swipe){
            Intent startSwipeStackActivity = new Intent(context, CardSwipeFragment.class);
            startActivity(startSwipeStackActivity);
            return true;
        }
        if(id == R.id.login){
            Intent startLoginActivity = new Intent(context, LoginActivity.class);
            startLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startLoginActivity);
            return true;
        } if (id == R.id.logout){
            LoginUtils.logout(context);
            return true;
        } if(id == R.id.profile){
            Intent startUserProfileActivity = new Intent(context, UserProfileActivity.class);
            startActivity(startUserProfileActivity);
            return true;
        } if(id == R.id.navigation){
            Intent start = new Intent(context, NavigationActivity.class);
            startActivity(start);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
