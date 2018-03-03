package ru.merkulyevsasha.uniapp.presentation.program;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.merkulyevsasha.uniapp.R;
import ru.merkulyevsasha.uniapp.presentation.commons.BaseFragment;
import ru.merkulyevsasha.uniapp.presentation.commons.BaseRecyclerViewAdapter;
import ru.merkulyevsasha.uniapp.presentation.commons.DiffUtillCallback;
import ru.merkulyevsasha.uniapp.presentation.commons.ItemClickListener;
import ru.merkulyevsasha.uniapp.presentation.controls.SpinnerLabel;
import ru.merkulyevsasha.uniapp.presentation.dto.ProgramItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public class ProgramFragment extends BaseFragment<ProgramView, ProgramPresenter> implements ProgramView {


    @BindView(R.id.levelstudyspinner) SpinnerLabel level;
    @BindView(R.id.coursenamespinner) SpinnerLabel course;
    @BindView(R.id.yearstudyspinner) SpinnerLabel year;
    @BindView(R.id.textview_search) View search;

    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    private LinearLayoutManager lm;
    private ProgramSearchAdapter adapter;

    public static Fragment getInstance() {
        ProgramFragment fragment = new ProgramFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_program, container, false);
        binder = ButterKnife.bind(this, root);
        if (combinator != null) combinator.connectToolbar(toolbar);
        toolbar.setTitle(R.string.nav_program);
        pres.bindView(this);

        lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        adapter = new ProgramSearchAdapter(getContext(), new ArrayList<>(),
                new DiffUtillCallback<ProgramItemUI>(),
                item -> pres.onSearchItemSelected(item) );
        recyclerView.setAdapter(adapter);

        search.setOnClickListener(v -> pres.onSearch(level.getSelection(), course.getSelection(), year.getSelection()));

        return root;
    }

    @Override
    public void showItems(List<ProgramItemUI> items) {
        adapter.setItems(items);
    }

    @Override
    public void showNotFoundMessage() {

    }

    class ProgramSearchAdapter extends BaseRecyclerViewAdapter<ProgramItemUI>{

        ProgramSearchAdapter(Context context, List<ProgramItemUI> items,
                                    DiffUtillCallback<ProgramItemUI> diffCallback,
                                    ItemClickListener<ProgramItemUI> itemClickListener) {
            super(context, items, diffCallback, itemClickListener);
        }

        @Override
        public int getItemViewType(int position) {
            return items.get(position).getViewHolderType();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == ProgramItemUI.HEADER_VIEW_TYPE) {
                View view = inflater.inflate(R.layout.row_program_header, parent, false);
                return new ProgramHeaderViewHolder(view);
            }
            if (viewType == ProgramItemUI.ITEM_VIEW_TYPE) {
                View view = inflater.inflate(R.layout.row_program, parent, false);
                return new RowItemViewHolder(view);
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ProgramHeaderViewHolder) bindProgramHeaderViewHolder((ProgramHeaderViewHolder)holder, position);
            if (holder instanceof RowItemViewHolder) bindRowItemViewHolder((RowItemViewHolder)holder, position);
        }

        private void bindRowItemViewHolder(RowItemViewHolder holder, int position) {
            ProgramItemUI item = items.get(position);
            holder.course.setText(item.getCourse());
            holder.degree.setText(item.getDegree());
            holder.year.setText(item.getYear());
            holder.name.setText(item.getName());
            holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(item));
        }

        private void bindProgramHeaderViewHolder(ProgramHeaderViewHolder holder, int position) {

        }

    }

    class ProgramHeaderViewHolder extends RecyclerView.ViewHolder{

        ProgramHeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class RowItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textview_course) TextView course;
        @BindView(R.id.textview_degree) TextView degree;
        @BindView(R.id.textview_year) TextView year;
        @BindView(R.id.textview_name) TextView name;

        RowItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
