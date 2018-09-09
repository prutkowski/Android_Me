package com.example.android.android_me.ui.tools.view;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ViewAnimator;

import com.example.android.android_me.R;

public class ViewAnimatorAnimations {

    public static void setupFadeFromLeftToRightAnimation(Context context, ViewAnimator v) {
        Animation in  = AnimationUtils.loadAnimation(context, R.anim.left_to_right_in);
        Animation out = AnimationUtils.loadAnimation(context, R.anim.left_to_right_out);
        v.setInAnimation(in);
        v.setOutAnimation(out);
    }
}
