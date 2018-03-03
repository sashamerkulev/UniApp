package ru.merkulyevsasha.uniapp.presentation.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import ru.merkulyevsasha.uniapp.presentation.dto.LibraryItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public class LibraryFragment extends BaseFragment<LibraryView, LibraryPresenter> implements LibraryView{

    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    private LinearLayoutManager lm;
    private LibrarySearchAdapter adapter;


    public static Fragment getInstance() {
        LibraryFragment fragment = new LibraryFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_library, container, false);
        binder = ButterKnife.bind(this, root);
        if (combinator != null) combinator.connectToolbar(toolbar);
        toolbar.setTitle(R.string.nav_library);
        pres.bindView(this);

        lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        adapter = new LibrarySearchAdapter(getContext(), new ArrayList<>(),
                new DiffUtillCallback<LibraryItemUI>(),
                item -> pres.onSearchItemSelected(item) );
        recyclerView.setAdapter(adapter);

        pres.bindView(this);
        pres.onCreateView();
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_library, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
//                pres.onSearchEraseClicked();
                return false;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showItems(List<LibraryItemUI> items) {
        adapter.setItems(items);
    }

    @Override
    public void showNotFoundMessage() {

    }

    class LibrarySearchAdapter extends BaseRecyclerViewAdapter<LibraryItemUI> {

        LibrarySearchAdapter(Context context, List<LibraryItemUI> items,
                             DiffUtillCallback<LibraryItemUI> diffCallback,
                             ItemClickListener<LibraryItemUI> itemClickListener) {
            super(context, items, diffCallback, itemClickListener);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.row_library, parent, false);
            return new LibraryViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            LibraryItemUI item = items.get(position);

            LibraryViewHolder library = (LibraryViewHolder)holder;

            library.author.setText(item.getAuthor());
            library.title.setText(item.getTitle());
            library.subject.setText(item.getSubject());
            library.course.setText(item.getCourse());

            holder.itemView.setOnClickListener(view -> itemClickListener.onItemClick(item));
        }

    }

    class LibraryViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textview_author) TextView author;
        @BindView(R.id.textview_title) TextView title;
        @BindView(R.id.textview_subject) TextView subject;
        @BindView(R.id.textview_course) TextView course;

        LibraryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
