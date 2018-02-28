package ru.merkulyevsasha.uniapp.presentation.controls;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.merkulyevsasha.uniapp.R;

/**
 * Created by sasha_merkulev on 26.02.2018.
 */

public class SpinnerLabelControl extends RelativeLayout {

    private final static String xmlns="http://schemas.android.com/apk/res/android";

    @BindView(R.id.label) TextView label;
    @BindView(R.id.spinner) Spinner spinner;

    public SpinnerLabelControl(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.control_spinner_label, this, true);
        ButterKnife.bind(this);

        if (attrs != null) {
            @StringRes int textRes = attrs.getAttributeResourceValue(xmlns, "text", 0);
            if (textRes > 0) {
                label.setText(textRes);
            }
            @ArrayRes int entriesRes = attrs.getAttributeResourceValue(xmlns, "entries", 0);
            if (entriesRes > 0){
                ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(context, entriesRes, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
            }
        }
    }

    public String getSelection(){
        return (String)spinner.getSelectedItem();
    }

}
