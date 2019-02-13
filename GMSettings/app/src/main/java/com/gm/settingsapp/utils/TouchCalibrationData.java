package com.gm.settingsapp.utils;


//This class will hold touchscreen calibration points with its position and touch point values.
public class TouchCalibrationData {
    private final String TAG = "TouchCalibrationData";
    boolean isCalibrationMode = false;
    int mWidth;
    int mHeight;
    point mLeftTopPoint;
    point mRightTopPoint;
    point mLeftBottomPoint;
    point mRightBottomPoint;
    point mCenterPoint;

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }

    public point getLeftTopPoint() {
        return mLeftTopPoint;
    }

    public void setLeftTopPoint(point leftTopPoint) {
        this.mLeftTopPoint = leftTopPoint;
    }

    public point getRightTopPoint() {
        return mRightTopPoint;
    }

    public void setRightTopPoint(point rightTopPoint) {
        this.mRightTopPoint = rightTopPoint;
    }

    public point getLeftBottomPoint() {
        return mLeftBottomPoint;
    }

    public void setLeftBottomPoint(point leftBottomPoint) {
        this.mLeftBottomPoint = leftBottomPoint;
    }

    public point getRightBottomPoint() {
        return mRightBottomPoint;
    }

    public void setRightBottomPoint(point rightBottomPoint) {
        this.mRightBottomPoint = rightBottomPoint;
    }

    public point getCenterPoint() {
        return mCenterPoint;
    }

    public void setCenterPoint(point centerPoint) {
        this.mCenterPoint = centerPoint;
    }

    public class point {
        int mPosition;

        public int getPosition() {
            return mPosition;
        }

        public void setPosition(int Position) {
            this.mPosition = Position;
        }

    }
}
