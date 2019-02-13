package com.gm.settingsapp.utils;

import android.os.Handler;


//This class contains test APIs for touchscreen calibration functionality.
public class TouchCalibrationTestAPI {

    private static final String TAG = "TouchCalibrationTestAPI";
    private static TouchCalibrationListener mTouchCalibrationListener;
    private Handler handler;
    private TouchCalibrateTask task;

    public TouchCalibrationTestAPI() {
        handler = new Handler();
    }

    public void setTouchCalibrationPoint(final TouchCalibrationData.point touchScreenCalibrationPoint) {
        task = new TouchCalibrateTask(touchScreenCalibrationPoint);
        handler.postDelayed(task, 1000);

    }

    static class TouchCalibrateTask implements Runnable {
        private TouchCalibrationData.point touchScreenCalibrationPoint;

        public TouchCalibrateTask(TouchCalibrationData.point touchScreenCalibrationPoint) {
            this.touchScreenCalibrationPoint = touchScreenCalibrationPoint;

        }

        @Override
        public void run() {

            if (mTouchCalibrationListener != null && touchScreenCalibrationPoint != null) {
                mTouchCalibrationListener.OnTouchCalibrationResult(touchScreenCalibrationPoint
                        .getPosition());
            }
        }

    }

    // This is callback after utilizing point values in framework APIs.
    public interface TouchCalibrationListener {
        public void OnTouchCalibrationResult(int pointPosition);
    }

}
