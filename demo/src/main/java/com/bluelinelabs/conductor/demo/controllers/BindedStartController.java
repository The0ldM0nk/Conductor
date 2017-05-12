package com.bluelinelabs.conductor.demo.controllers;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.bluelinelabs.conductor.changehandler.TransitionChangeHandlerCompat;
import com.bluelinelabs.conductor.demo.BR;
import com.bluelinelabs.conductor.demo.R;
import com.bluelinelabs.conductor.demo.changehandler.SharedElementDelayingChangeHandler;
import com.bluelinelabs.conductor.demo.controllers.base.BindedBaseController;

import java.util.ArrayList;
import java.util.List;

public class BindedStartController extends BindedBaseController implements IBindedController {

    private BindedSharedModel mBindedSharedModel;

    @Override
    protected View inflateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        return inflater.inflate(R.layout.binded_start_controller, container, false);
    }

    @Override
    protected void onViewBound(@NonNull View view) {
        super.onViewBound(view);

        mBindedSharedModel = new BindedSharedModel(this);
        getViewBinding().setVariable(BR.viewModel, mBindedSharedModel);
    }

    @Override
    public void goToController(BindedBaseController bindedBaseController) {
        List<String> names = new ArrayList<>();
        names.add(getActivity().getString(R.string.transition_tag_title));

        getRouter().pushController(RouterTransaction.with(bindedBaseController)
                .pushChangeHandler(new TransitionChangeHandlerCompat(new SharedElementDelayingChangeHandler(names), new FadeChangeHandler()))
                .popChangeHandler(new TransitionChangeHandlerCompat(new SharedElementDelayingChangeHandler(names), new FadeChangeHandler())));
    }
}
