package com.bluelinelabs.conductor.demo.controllers.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;

public abstract class BindedBaseController extends Controller {

    private ViewDataBinding mViewDataBinding;

    protected BindedBaseController() {
    }

    protected BindedBaseController(Bundle args) {
        super(args);
    }

    protected abstract View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container);

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflateView(inflater, container);
        mViewDataBinding = DataBindingUtil.bind(view);
        onViewBound(view);
        return view;
    }

    protected void onViewBound(@NonNull View view) {
    }

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        mViewDataBinding.unbind();
        mViewDataBinding = null;
    }

    public ViewDataBinding getViewBinding() {
        return mViewDataBinding;
    }
}
