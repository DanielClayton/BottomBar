package com.example.bottombar.sample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class FragmentActivity extends BaseActivity implements ShopFragment.OnFragmentInteractionListener, GiftFragment.OnFragmentInteractionListener {

    @Override
    protected void doCreate(Bundle savedInstanceState) {
        super.doCreate(savedInstanceState);

        final View v = LayoutInflater.from(this).inflate(R.layout.activity_fragment, vMainContent, false);
        vMainContent.addView(v);
    }

    @Override
    protected void configureBottomBar() {
        AppUtils.configureBottomBar(this, AppUtils.BOTTOM_BAR_GIFTING);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i(AppUtils.TAG, "onFragmentInteraction");
    }
}
