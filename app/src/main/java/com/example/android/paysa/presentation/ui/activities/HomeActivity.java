package com.example.android.paysa.presentation.ui.activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.android.paysa.R;
import com.example.android.paysa.domain.utilities.CardUtil;
import com.example.android.paysa.domain.utilities.LoginUtils;
import com.example.android.paysa.presentation.ui.adapters.HomeViewPagerAdapter;
import com.example.android.paysa.presentation.ui.fragments.JobCardsFragment;

public class HomeActivity extends AppCompatActivity{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    private void init(){

        getSupportActionBar().setElevation(0);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.SAVED), "Saved");
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.APPLIED), "Applied");
        adapter.addFragment(JobCardsFragment.newInstance(CardUtil.CardType.OFFERED), "Offered");
        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_create_job){
            Intent startCreateJobActivity = new Intent(this, CreateJobActivity.class);
            startActivity(startCreateJobActivity);
            return true;
        }
        if(id == R.id.action_create_user_profile){
            Intent startCreateUserProfileActivity = new Intent(this, CreateUserProfileActivity.class);
            startActivity(startCreateUserProfileActivity);
            return true;
        }
        if(id == R.id.action_card_swipe){
            Intent startSwipeStackActivity = new Intent(this, CardSwipeActivity.class);
            startActivity(startSwipeStackActivity);
            return true;
        }
        if(id == R.id.login){
            Intent startLoginActivity = new Intent(this, LoginActivity.class);
            startLoginActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startLoginActivity);
            return true;
        } if (id == R.id.logout){
            LoginUtils.logout(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
