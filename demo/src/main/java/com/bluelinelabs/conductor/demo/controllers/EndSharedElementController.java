package com.bluelinelabs.conductor.demo.controllers;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.demo.R;
import com.bluelinelabs.conductor.demo.controllers.base.BaseController;

import butterknife.BindView;

public class EndSharedElementController extends BaseController {

    @BindView(R.id.tv_destination)
    TextView tvDestination;

    public EndSharedElementController(Bundle args) {
        super(args);
    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_end_shared_element, container, false);
    }

    @Override
    protected void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tvDestination.setTransitionName(getActivity().getString(R.string.transition_tag_title));
        }
    }

    @Override
    protected String getTitle() {
        return "End Shared Element Demo";
    }
}
