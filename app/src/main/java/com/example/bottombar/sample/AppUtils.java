package com.example.bottombar.sample;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by tom.mcfarlin on 10/17/16.
 */

public class AppUtils {

    public static final String TAG = "BOTTOM BAR";

    public static final int BOTTOM_BAR_SHOP = 1;
    public static final int BOTTOM_BAR_GIFTING = 2;
    public static final int BOTTOM_BAR_REWARDS = 3;
    public static final int BOTTOM_BAR_STORES = 4;
    public static final int BOTTOM_BAR_COOKING = 5;

    @IntDef({BOTTOM_BAR_SHOP,
            BOTTOM_BAR_GIFTING,
            BOTTOM_BAR_REWARDS,
            BOTTOM_BAR_STORES,
            BOTTOM_BAR_COOKING})
    public @interface BottomBarState {
    }

    public static int dpToPx(float dp, Activity activity) {
        float density = activity.getApplicationContext().getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static void configureBottomBar(final AppCompatActivity a, @BottomBarState int bottomBarState) {

        // Inflate the viewstub referencing the bottom bar
        ViewStub vBottomBarStub = ((ViewStub) a.findViewById(R.id.bottom_bar_stub));
        vBottomBarStub.setVisibility(View.VISIBLE);

        // Dynamically set active tab icon & color
        final BottomBar bb = (BottomBar) a.findViewById(R.id.bottom_bar);

        // TODO return from child activity
//        bb.setDefaultTab(R.id.tab_shop);

        if (a.findViewById(R.id.fragment_container) != null) {
            ShopFragment shopFragment = ShopFragment.newInstance("1", "2");
            a.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, shopFragment).commit();
        }

        bb.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int selectedTabId) {
                if (selectedTabId == R.id.tab_shop) {
                    Log.i(TAG, "Selected: Shop");
                    ShopFragment newFragment = ShopFragment.newInstance("1", "2");
                    a.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, newFragment)
                            .commit();
                } else if (selectedTabId == R.id.tab_gift) {
                    Log.i(TAG, "Selected: Gift");
                    GiftFragment newFragment = GiftFragment.newInstance("1", "2");
                    a.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, newFragment)
                            .commit();
                }
            }
        });

        // TODO If selected tab is currently selected, then refresh activity
        bb.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_shop) {
                    Log.i(TAG, "Reselected: Shop");
                } else if (tabId == R.id.tab_gift) {
                    Log.i(TAG, "Reselected: Gift");
                }
            }
        });
    }
}
