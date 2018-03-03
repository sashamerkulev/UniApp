package ru.merkulyevsasha.uniapp.presentation.accommodation;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;
import ru.merkulyevsasha.uniapp.R;
import ru.merkulyevsasha.uniapp.presentation.controls.ImageGallery;
import ru.merkulyevsasha.uniapp.presentation.dto.AccommodationItemUI;

/**
 * Created by sasha_merkulev on 05.03.2018.
 */

public class AccommodationActivity extends AppCompatActivity {

    private static final String KEY_ACCOMMODATION_ITEM = AccommodationActivity.class.getSimpleName()+".accommodation_item";
    private static final String KEY_IMAGE_INDEX = AccommodationActivity.class.getSimpleName()+".image_index";

    protected @BindView(R.id.toolbar) Toolbar toolbar;
    protected @BindView(R.id.appbar_layout) AppBarLayout appBarLayout;

    @BindView(R.id.textview_name) TextView name;
    @BindView(R.id.gallery) ImageGallery gallery;
    @BindView(R.id.textview_description) TextView description;


    private Unbinder binder;

    public static void show(Context context, AccommodationItemUI item, int imageIndex){
        Intent intent = new Intent(context, AccommodationActivity.class);
        intent.putExtra(KEY_ACCOMMODATION_ITEM, item);
        intent.putExtra(KEY_IMAGE_INDEX, imageIndex);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodation_activity);
        binder = ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();
        AccommodationItemUI item = (AccommodationItemUI)intent.getSerializableExtra(KEY_ACCOMMODATION_ITEM);
        int index = intent.getIntExtra(KEY_IMAGE_INDEX, 0);

        gallery.setImages(item.getImages(), index);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        binder.unbind();
        super.onDestroy();
    }

}
