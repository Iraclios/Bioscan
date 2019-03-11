package com.murik.enose.presentation.presenter.resultRadarChart;


import android.graphics.Color;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.mikephil.charting.data.RadarEntry;
import com.murik.enose.Const;
import com.murik.enose.model.dto.SensorDataFullParcelable;
import com.murik.enose.presentation.view.resultRadarChart.ResultRadarChartView;
import com.murik.enose.service.Impl.MeasureServiceImpl;
import com.murik.enose.service.MeasureService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@InjectViewState
public class ResultRadarChartPresenter extends MvpPresenter<ResultRadarChartView>{


  public final static String TAG = "resultRadarPresenter";
  private SensorDataFullParcelable sensorDataFullParcelable;
  private MeasureService measureService;
  private List<Integer> x = new ArrayList<>();



  @Override
  public void attachView(ResultRadarChartView view) {
    super.attachView(view);
  }

  public void setData(SensorDataFullParcelable sensorDataFullParcelable){
    this.sensorDataFullParcelable = sensorDataFullParcelable;
    measureService = new MeasureServiceImpl(sensorDataFullParcelable);

  }

  public SensorDataFullParcelable getSensorDataFullParcelable() {
    return sensorDataFullParcelable;
  }


  public void createRadarChart(int mPage) {
    switch (mPage){
      case Const.PAGE_TOTAL:
        initRadarChart(Const.TOTAL, Color.RED, Color.BLUE);
        createDataForArea(Const.TOTAL);
        break;
      case Const.PAGE_HEALTH:
        initRadarChart(Const.HEALTH, Color.RED, Color.BLUE);
        createDataForArea(Const.HEALTH);
        break;
      case Const.PAGE_ENERGY:
        initRadarChart(Const.ENERGY, Color.RED, Color.BLUE);
        createDataForArea(Const.ENERGY);
        break;
      case Const.PAGE_BAD:
        initRadarChart(Const.BAD, Color.RED, Color.BLUE);
        createDataForArea(Const.BAD);
        break;
      case Const.PAGE_ENDOKRIN:
        initRadarChart(Const.ENDOKRIN, Color.RED, Color.BLUE);
        createDataForArea(Const.ENDOKRIN);
        break;
    }
  }
  public void initRadarChart(int[] mask, int colorLeft, int colorRight){


    ArrayList<Integer> leftHandData = new ArrayList<>();
    ArrayList<Integer> rightHandData = new ArrayList<>();

    List<LinkedHashMap<Integer, Integer>> sensors = new ArrayList<>();


    if(mask.equals(Const.ENERGY)) {
      for (int key : mask) {

        if (!sensorDataFullParcelable.getDataSensorMapLeftHand().isEmpty()) {
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_1) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_1).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7).get((key)));
          }
        }
        if (!sensorDataFullParcelable.getDataSensorMapRightHand().isEmpty()) {
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_1) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_1).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7).get((key)));
          }
        }
      }
    } else if(mask.equals(Const.ENDOKRIN)) {
      for(int key: mask) {

        if (!sensorDataFullParcelable.getDataSensorMapLeftHand().isEmpty()) {

          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_4) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_4).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_5) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_5).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7).get((key)));
          }
        }
        if (!sensorDataFullParcelable.getDataSensorMapRightHand().isEmpty()) {
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_4) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_4).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_5) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_5).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7).get((key)));
          }
        }
      }
    } else {
      for(int key: mask) {

        if (!sensorDataFullParcelable.getDataSensorMapLeftHand().isEmpty()) {
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_1) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_1).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_2) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_2).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_4) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_4).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_5) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_5).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_6) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_6).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_7).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_8) != null){
            leftHandData.add(sensorDataFullParcelable.getDataSensorMapLeftHand().get(Const.SENSOR_8).get((key)));
          }
        }
        if (!sensorDataFullParcelable.getDataSensorMapRightHand().isEmpty()) {
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_1) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_1).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_2) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_2).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_3).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_4) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_4).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_5) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_5).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_6) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_6).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_7).get((key)));
          }
          if(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_8) != null){
            rightHandData.add(sensorDataFullParcelable.getDataSensorMapRightHand().get(Const.SENSOR_8).get((key)));
          }
      }
    }
    }


    for(int i = 0; i < leftHandData.size(); i++){
      if(leftHandData.get(i) < 0){
        leftHandData.set(i, 0);
      }
    }
    for(int i = 0; i < rightHandData.size(); i++){
      if(rightHandData.get(i) < 0){
        rightHandData.set(i, 0);
      }
    }

    ArrayList<RadarEntry> entryLeftHand = new ArrayList<>();
    ArrayList<RadarEntry> entryRightHand = new ArrayList<>();

    for(int i = 0; i < leftHandData.size(); i++){
      entryLeftHand.add(new RadarEntry(leftHandData.get(i), i));
      //lable.add(String.valueOf(i));
    }
    for(int i = 0; i < rightHandData.size(); i++){
      entryRightHand.add(new RadarEntry(rightHandData.get(i), i));
    }
    /*getViewState().setTvRadarAreaLeft(Float.toString(createDataForArea(leftHandData)));
    getViewState().setTvRadarAreaRight(Float.toString(createDataForArea(rightHandData)));*/

    getViewState().initRadarChart(entryLeftHand
        ,entryRightHand
        ,getSensorDataFullParcelable().getDescriptions()
        ,colorLeft
        ,colorRight);
  }

  public void createDataForArea(int[] mask){

    List<Float> area;

    if(mask.equals(Const.ENERGY)) {
      area = measureService.calculateArea(mask, Const.energySens);
    } else if(mask.equals(Const.ENDOKRIN)){
      area = measureService.calculateArea(mask, Const.endocrinSens);
    } else {
      area = measureService.calculateArea(mask, Const.allSens);
    }

    getViewState().setTvRadarAreaLeft(Float.toString(area.get(0)));
    getViewState().setTvRadarAreaRight(Float.toString(area.get(1)));


    List<Float> delta = measureService.calculateDelta(area, mask.equals(Const.BAD));

    getViewState().setTvDeltaLeft(Float.toString(new BigDecimal(delta.get(0)).setScale(1, RoundingMode.DOWN).floatValue()) + " %");
    getViewState().setTvDeltaRight(Float.toString(new BigDecimal(delta.get(1)).setScale(1, RoundingMode.DOWN).floatValue())+ " %");
  }

}