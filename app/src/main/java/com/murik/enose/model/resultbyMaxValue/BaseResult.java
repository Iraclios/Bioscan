package com.murik.enose.model.resultbyMaxValue;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import com.murik.enose.R;
import com.murik.enose.model.ResultBySens;

public abstract class BaseResult implements ResultBySens {
    private double A;
    private int color;
    private String possibleReasons = null;
    private Context context;
    private String legend;
    private boolean isPractice;

    public BaseResult(double A,boolean isPractice, Context context){
      this.A = A;
      this.context = context;
      this.isPractice = isPractice;
      setColorGREEN();

      if(Double.isNaN(A) || Double.isInfinite(A)) {
        color = Color.WHITE;
        return;
      }
      setResult();
    }

  public void setPractice(boolean practice) {
    isPractice = practice;
  }

  public boolean isPractice() {
    return isPractice;
  }

  @Override
    public abstract void setResult();

    @Override
    public int getViewColor() {
      return color;
    }

    @Override
    public String getResultComment() {
      return possibleReasons;
    }

    public double getA(){
     return A;
    }

    public void setA(double A){
     this.A = A;
    }

  public void setColorBURGUNDY(){
    color = ContextCompat.getColor(context, R.color.colorResultBurgundy);
  }
  public void setColorRED(){
     color = ContextCompat.getColor(context, R.color.colorResultRed);
  }
  public void setColorCRIMSON(){
    color = ContextCompat.getColor(context, R.color.colorResultCrimson);
  }
  public void setColorYELLOW(){
    color = ContextCompat.getColor(context, R.color.colorResultYellow);
  }
  public void setColorGREEN(){
    color = ContextCompat.getColor(context, R.color.colorResultGreen);
  }
  public void setColorBLUE(){
    color = ContextCompat.getColor(context, R.color.colorResultBlue);

  }
  public void setPossibleReasons(String possibleReasons) {
        this.possibleReasons = possibleReasons;
  }

  public String getResources(int idRes){
      return context.getResources().getString(idRes);
  }

  @Override
  public Context getContext() {
    return context;
  }

  public void setLegend(String legend) {
    this.legend = legend;
  }

  @Override
  public String getLegend() {
    return legend;
  }

}
