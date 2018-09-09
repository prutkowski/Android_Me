/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    // TODO (3) Create final Strings to store state information about the list of images and list index

    // Tag for logging
    private static final String TAG = "BodyPartFragment";

    ImageSwitcher imageView = null;

    private List<Integer> mImageIds = new ArrayList<>();
    private int mListIndex;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {
    }

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        imageView = (ImageSwitcher) rootView.findViewById(R.id.body_part_image_view);
        imageView.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });
        Animation in  = AnimationUtils.loadAnimation(getActivity(), R.anim.left_to_right_in);
        Animation out = AnimationUtils.loadAnimation(getActivity(), R.anim.left_to_right_out);
        imageView.setInAnimation(in);
        imageView.setOutAnimation(out);

        showImage();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseImageIndex();
                showImage();
            }
        });

        return rootView;
    }

    private void increaseImageIndex() {
        if (mListIndex < mImageIds.size() - 1) {
            mListIndex++;
        } else
            mListIndex = 0;
    }

    private void showImage() {
        if (mListIndex > -1 && mImageIds.size() > mListIndex) {
            imageView.setImageResource(mImageIds.get(mListIndex));
        }
    }

    public void setImageIds(List<Integer> imageIds) {
        if (imageIds != null)
            mImageIds = imageIds;
    }

    public void setListIndex(int index) {
        mListIndex = index;
    }
}
