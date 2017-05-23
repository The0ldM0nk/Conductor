package com.bluelinelabs.conductor.demo.controllers;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.bluelinelabs.conductor.changehandler.TransitionChangeHandlerCompat;
import com.bluelinelabs.conductor.demo.R;
import com.bluelinelabs.conductor.demo.changehandler.SharedElementDelayingChangeHandler;
import com.bluelinelabs.conductor.demo.controllers.base.BaseController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class StartSharedElementController extends BaseController {

    @BindView(R.id.tv_source)
    TextView tvSource;

    public StartSharedElementController(Bundle args) {
        super(args);
    }

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.controller_start_shared_element, container, false);
    }

    @Override
    protected String getTitle() {
        return "Start Shared Element Demo";
    }

    @Override
    protected void onViewBound(@NonNull View view) {
        super.onViewBound(view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tvSource.setTransitionName(getResources().getString(R.string.transition_tag_title));
        }

        tvSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> names = new ArrayList<>();
                names.add(getActivity().getString(R.string.transition_tag_title));

                getRouter().pushController(RouterTransaction.with(new EndSharedElementController(new Bundle()))
                        .pushChangeHandler(new TransitionChangeHandlerCompat(new SharedElementDelayingChangeHandler(names), new FadeChangeHandler()))
                        .popChangeHandler(new TransitionChangeHandlerCompat(new SharedElementDelayingChangeHandler(names), new FadeChangeHandler())));

            }
        });
    }
}
