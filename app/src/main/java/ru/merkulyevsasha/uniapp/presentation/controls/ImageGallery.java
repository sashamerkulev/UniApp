package ru.merkulyevsasha.uniapp.presentation.controls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.merkulyevsasha.uniapp.R;

/**
 * Created by sasha_merkulev on 04.03.2018.
 */

public class ImageGallery extends RelativeLayout {

    public static final int START_INDEX = 1;

    @BindView(R.id.layout_images) View layout_images;
    @BindView(R.id.viewpager_images) ViewPager pager;
    @BindView(R.id.layout_indicator) LinearLayout layout_indicator;

    private final List<CircleView> circles;

    private int imageCount;
    private float firstX=0;
    private float firstY=0;

    public ImageGallery(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.control_image_galery, this, true);
        ButterKnife.bind(this);

        circles = new ArrayList<>();

        imageCount = 0;

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (layout_indicator.getVisibility() == View.VISIBLE) {
                    if (positionOffset == 0) {
//                        if (position < imageCount) {
//                            circles.get(position).select();
//                        }
                        if (position == 0) {
                            pager.setCurrentItem(imageCount, false);
                            return;
                        }
                        if (position == imageCount + 1) {
                            pager.setCurrentItem(1, false);
                            return;
                        }
                        for (int i = 0; i < imageCount; i++) {
                            if (i == position - 1) {
                                circles.get(position - 1).select();
                            } else {
                                circles.get(i).unselect();
                            }
                        }
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                firstX = event.getX();
                firstY = event.getY();
                break;

            case MotionEvent.ACTION_MOVE:
                if (horizontalDirection(firstX, firstY, event)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }

            case MotionEvent.ACTION_UP:
                if (horizontalDirection(firstX, firstY, event)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
        }

        return true;//onTouchEvent(event);
    }

    public void setImages(List<String> images, int index){

        circles.clear();
        imageCount = images.size();
        layout_indicator.removeAllViews();

        if (imageCount > 0) {

            if (imageCount > 1){

                List<View> pages = new ArrayList<>();
                pages.add(getImagePage(getContext(), images.get(imageCount-1)));

                for (int i = 0; i < imageCount; i++) {
                    pages.add(getImagePage(getContext(), images.get(i)));
                    CircleView circle = new CircleView(getContext());
                    circles.add(circle);
                    layout_indicator.addView(circle);
                }
                pages.add(getImagePage(getContext(), images.get(0)));

                pager.setAdapter(new ViewPagerAdapter(pages));

                circles.get(0).select();
                pager.setCurrentItem(index> imageCount? START_INDEX : index, false);


                layout_indicator.setVisibility(View.VISIBLE);
            } else {
                layout_indicator.setVisibility(View.GONE);
            }

            layout_images.setVisibility(View.VISIBLE);
        } else {
            layout_images.setVisibility(View.GONE);
        }
    }

    public int selected(){
        return pager.getCurrentItem();
    }

    private View getImagePage(Context context, String imagePath){
        ImageView image = new ImageView(context);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        image.setLayoutParams(params);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int productImageId = context.getResources().getIdentifier(imagePath, "drawable", context.getPackageName());
        //System.out.println(String.format(Locale.getDefault(), "%s <-> %d", imagePath, productImageId));
        //Picasso.with(context).load(productImageId).into(image);
        Glide.with(context).load(productImageId).into(image);
        return image;
    }

    private boolean horizontalDirection(float firstX, float firstY, MotionEvent event){
        float x = event.getX();
        float y = event.getY();
        float xDelta = Math.abs(x - firstX)+25; // small priority for x swipe
        float yDelta = Math.abs(y - firstY);

        return xDelta > yDelta;
    }

    public class ViewPagerAdapter extends PagerAdapter {

        private final List<View> pages;

        ViewPagerAdapter(List<View> pages){
            this.pages = pages;
        }

        @Override
        public int getCount() {
            return pages.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = pages.get(position);
            container.addView(v, 0);
            return v;
        }

        @SuppressWarnings("deprecation")
        @Override
        public void destroyItem(View collection, int position, Object view){
            ((ViewPager) collection).removeView((View) view);
        }

    }

    public class CircleView extends View{

        private final Paint paintSelect;
        private final Paint paintUnselect;

        private final int px12dp;
        private final int px2dp;

        private boolean selected;

        public CircleView(Context context) {
            super(context);

            px12dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, context.getResources().getDisplayMetrics());
            px2dp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, context.getResources().getDisplayMetrics());

            paintSelect = new Paint();
            paintSelect.setStyle(Paint.Style.FILL_AND_STROKE);
            paintSelect.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
            paintSelect.setStrokeWidth(1);

            paintUnselect = new Paint();
            paintUnselect.setStyle(Paint.Style.FILL_AND_STROKE);
            paintUnselect.setColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
            paintUnselect.setStrokeWidth(1);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(px12dp, px12dp);
            params.setMargins(px2dp, 0, px2dp, 0);
            setLayoutParams(params);

            selected = false;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawCircle(px12dp/2, px12dp/2, px12dp/2, selected ? paintSelect : paintUnselect);
        }

        public void select(){
            selected = true;
            invalidate();
        }

        public void unselect(){
            selected = false;
            invalidate();
        }
    }
}
