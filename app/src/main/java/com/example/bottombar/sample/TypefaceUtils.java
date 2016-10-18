package com.example.bottombar.sample;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.StringDef;
import android.widget.TextView;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tom.mcfarlin on 10/18/16.
 */

public class TypefaceUtils {
    public static final String PROXIMA_NOVA_REGULAR = "fonts/ProximaNova-Reg-webfont.ttf";

    @StringDef({PROXIMA_NOVA_REGULAR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TypefaceName {
    }

    private TypefaceUtils() {
    }

    public static void applyTypeface(Context context, TextView textView, @TypefaceName String typefaceName) {
        textView.setTypeface(Typeface.createFromAsset(context.getAssets(), typefaceName));
    }
}
