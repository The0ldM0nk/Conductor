package com.bluelinelabs.conductor.demo.controllers;

import android.databinding.BaseObservable;

public class BindedSharedModel extends BaseObservable {

    private IBindedController mIBindedController;

    public BindedSharedModel() {
    }

    public BindedSharedModel(IBindedController iBindedController) {
        this.mIBindedController = iBindedController;
    }

    public void goToEndController() {
        mIBindedController.goToController(new BindedEndController());
    }
}
