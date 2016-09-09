package com.ted.slidemenu;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tbHeadbar)
    Toolbar mTbHeadBar;

    /**/
    @BindView(R.id.llMenu)
    LinearLayout mLlMenu;

    @BindView(R.id.lvMenu)
    ListView mLvMenu;

    @BindView(R.id.ivContent)
    ImageView mIvContent;

    @BindView(R.id.dlMenu)
    DrawerLayout mMyDrawable;

    ActionBarDrawerToggle mToggle;

    private List<String> lvMenuList = new ArrayList<String>(){{
        add("angry");
        add("happy");
        add("sad");
        add("embarrassed");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //initTooBarAndDrawableLayout();

        mLvMenu.setAdapter(new ArrayAdapter(this,
                    android.R.layout.simple_expandable_list_item_1,lvMenuList));
        mLvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMyDrawable.closeDrawers();
                Toast.makeText(MainActivity.this, lvMenuList.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initTooBarAndDrawableLayout() {
        setSupportActionBar(mTbHeadBar);
        //设置返回键可用
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置标题文字不可显示
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mToggle = new ActionBarDrawerToggle(this,mMyDrawable,mTbHeadBar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mMyDrawable.addDrawerListener(mToggle);
        mToggle.syncState();
    }
}
