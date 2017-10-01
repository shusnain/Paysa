package com.example.android.paysa.presentation.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.paysa.domain.executors.impl.ThreadExecutor;
import com.example.android.paysa.presentation.presenters.MainPresenter;
import com.example.android.paysa.presentation.presenters.MainPresenter.View;
import com.example.android.paysa.presentation.presenters.impl.MainPresenterImpl;
import com.example.android.paysa.presentation.ui.adapters.CardAdapter;
import com.example.android.paysa.R;
import com.example.android.paysa.threading.MainThreadImpl;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View{

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;

    private CardAdapter mCardAdapter;

    private MainPresenter mMainPresenter;


    Map<String, String> dummyData = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init(){
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_card);

        int recylerViewOrientation = LinearLayoutManager.VERTICAL;

        boolean shouldReverseLayout = false;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, recylerViewOrientation, shouldReverseLayout);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mCardAdapter = new CardAdapter();

        dummyData.put("Title 1", "Lorem ipsum dolor sit amet, mauris vivamus dictumst faucibus vel felis arcu, morbi amet litora non sed, suscipit nulla nascetur metus in, a tincidunt montes nunc. Tempor lacus facilisis blandit suscipit phasellus magna, id velit nunc feugiat ipsum hymenaeos mattis, nec in pellentesque sollicitudin. Nec ut pharetra quis sit, in vitae, sit vestibulum condimentum, integer interdum consequat leo, ac fusce nec adipiscing placerat venenatis. Elit quam diam lectus arcu quam eu, arcu condimentum eget fringilla sed, urna et eget, interdum nec nullam. Eget illo, integer et sociis accumsan lectus. Mi ante at ligula pretium, eu porta molestie quibusdam consequat sed turpis, lorem est. Felis vivamus sapien porttitor, wisi lacinia praesent mi voluptatem quisque, quis litora arcu totam, commodo quam, eros penatibus. Ac dolor dignissim, quis wisi, sed et, dolor aenean in accumsan facilisi amet, sollicitudin erat fermentum id eu. Tortor nibh ornare mauris vestibulum integer nunc, commodo pellentesque, vehicula faucibus mi et lorem vel scelerisque, ante rutrum at vestibulum nascetur ipsum. Quis molestie ullamcorper dolor augue, dui ultricies morbi, auctor aenean in nec sed accumsan. Sem tempor aliquam morbi ante nunc cumque, pharetra arcu nulla ligula nulla, at facilisis. Metus sit dictum.");
        dummyData.put("Title 2", "Test 2");

        mCardAdapter.setCardData(dummyData);

        mRecyclerView.setAdapter(mCardAdapter);

        mMainPresenter = new MainPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this
        );
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainPresenter.resume();
    }
}
