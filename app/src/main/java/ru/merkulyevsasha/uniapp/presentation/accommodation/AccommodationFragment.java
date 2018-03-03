package ru.merkulyevsasha.uniapp.presentation.accommodation;

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
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.merkulyevsasha.uniapp.R;
import ru.merkulyevsasha.uniapp.presentation.commons.BaseFragment;
import ru.merkulyevsasha.uniapp.presentation.commons.BaseRecyclerViewAdapter;
import ru.merkulyevsasha.uniapp.presentation.commons.DiffUtillCallback;
import ru.merkulyevsasha.uniapp.presentation.commons.ItemClickListener;
import ru.merkulyevsasha.uniapp.presentation.commons.ItemIndexClickListener;
import ru.merkulyevsasha.uniapp.presentation.controls.ImageGallery;
import ru.merkulyevsasha.uniapp.presentation.dto.AccommodationItemUI;

/**
 * Created by sasha_merkulev on 11.02.2018.
 */

public class AccommodationFragment extends BaseFragment<AccommodationView, AccommodationPresenter> implements AccommodationView {

    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    private LinearLayoutManager lm;
    private AccommodationAdapter adapter;

    public static Fragment getInstance() {
        AccommodationFragment fragment = new AccommodationFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_accommodation, container, false);
        binder = ButterKnife.bind(this, root);
        if (combinator != null) combinator.connectToolbar(toolbar);
        toolbar.setTitle(R.string.nav_accomodation);
        pres.bindView(this);

        lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        adapter = new AccommodationAdapter(getContext(), new ArrayList<>(),
                new DiffUtillCallback<AccommodationItemUI>(),
                (item, index) -> pres.onItemClicked(item, index) );
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
    public void showItem(AccommodationItemUI item, int index) {
        AccommodationActivity.show(getContext(), item, index);
    }

    @Override
    public void showItems(List<AccommodationItemUI> items) {
        adapter.setItems(items);
    }

    @Override
    public void showNotFoundMessage() {

    }

    class AccommodationAdapter extends BaseRecyclerViewAdapter<AccommodationItemUI> {

        private final ItemIndexClickListener<AccommodationItemUI> itemIndexClickListener;

        AccommodationAdapter(Context context, List<AccommodationItemUI> items,
                             DiffUtillCallback<AccommodationItemUI> diffCallback,
                             ItemIndexClickListener<AccommodationItemUI> itemClickListener) {
            super(context, items, diffCallback, null);
            this.itemIndexClickListener = itemClickListener;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.row_accommdation, parent, false);
            return new AccommodationViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            AccommodationItemUI item = items.get(position);

            AccommodationViewHolder accomodation = (AccommodationViewHolder)holder;

            accomodation.name.setText(item.getName());

            List<String> images = item.getImages();
            accomodation.gallery.setImages(images, ImageGallery.START_INDEX);

            StringBuilder sb = new StringBuilder();
            for(String s : images){
                sb.append(s);
            }
            accomodation.description.setText(String.format(Locale.getDefault(), "%s %s",item.getDescription(), sb.toString()));

            holder.itemView.setOnClickListener(view -> itemIndexClickListener.onItemClick(item, accomodation.gallery.selected()));
        }

    }

    class AccommodationViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.textview_name) TextView name;
        @BindView(R.id.gallery) ImageGallery gallery;
        @BindView(R.id.textview_description) TextView description;

        AccommodationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
