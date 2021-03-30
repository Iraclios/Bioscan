package com.murik.enose.model.common_A;

import android.content.Context;
import android.graphics.Color;

import com.murik.enose.R;
import com.murik.enose.dto.DataByMaxParcelable;
import com.murik.enose.model.resultbyMaxValue.BaseResultWithCoefficient;

public class A_20_30_for_30 extends BaseResultWithCoefficient {


    public A_20_30_for_30(double A, DataByMaxParcelable inputData, Context context, float coefficient) {
        super(A, inputData, context, coefficient);
        setLegend("V");
    }

    public A_20_30_for_30(double A, DataByMaxParcelable inputData, Context context, String legend) {
        super(A, inputData, context, 0);
        setLegend(legend);
    }

    public void setResult() {
         if (getA() > 0.57 && getA() <= 0.63) {
            setColorGREEN();
        } else if (getA() >= 0.64 && getA() <= 0.75) {
            setColorYELLOW();
            setPossibleReasons(getResources(R.string.A_20_30_YELLOW_1));
        } else if(getA() >= 0.50 && getA() <= 0.57) {
            setColorYELLOW();
            setPossibleReasons(getResources(R.string.A_20_30_YELLOW_3));
        } else if(getA() >= 0.27 && getA() <= 0.49) {
            setColorRED();
            setPossibleReasons(getResources(R.string.A_20_30_RED_1));
        } else if(getA() >= 0.76 && getA() <= 0.95) {
            setColorRED();
            setPossibleReasons(getResources(R.string.A_20_30_RED_2));
        } else if(getA() >= 0.95) {
            setColorBURGUNDY();
            setPossibleReasons(getResources(R.string.A_20_30_BURGUNDY));
        } else {
            setColor(Color.WHITE);
            setPossibleReasons(getResources(R.string.A_20_30_IF_NOT_IN_RANGE));
        }
    }
}
