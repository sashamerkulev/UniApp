package ru.merkulyevsasha.uniapp.presentation.notice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ru.merkulyevsasha.uniapp.R;
import ru.merkulyevsasha.uniapp.presentation.commons.BaseFragment;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public class NoticeFragment extends BaseFragment<NoticeView, NoticePresenter> implements NoticeView {

    public static Fragment getInstance() {
        NoticeFragment fragment = new NoticeFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_notice, container, false);
        binder = ButterKnife.bind(this, root);
        if (combinator != null) combinator.connectToolbar(toolbar);
        toolbar.setTitle(R.string.nav_notice);
        pres.bindView(this);
        return root;
    }
}
