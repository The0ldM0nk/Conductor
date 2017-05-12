package com.bluelinelabs.conductor.demo.controllers;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.demo.BR;
import com.bluelinelabs.conductor.demo.R;
import com.bluelinelabs.conductor.demo.controllers.base.BindedBaseController;

public class BindedEndController extends BindedBaseController {

    private BindedSharedModel mBindedSharedModel;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.binded_end_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull View view) {
        super.onViewBound(view);

        mBindedSharedModel = new BindedSharedModel();
        getViewBinding().setVariable(BR.viewModel, mBindedSharedModel);
    }
}
