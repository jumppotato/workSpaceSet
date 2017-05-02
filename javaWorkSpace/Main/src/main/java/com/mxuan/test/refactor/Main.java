package com.mxuan.test.refactor;

/**
 * Created by wangwenxuan on 2017/4/12.
 */
public class Main{
    public int gama(int inputVal, int quantity, int yearToDate){
        int importantValue = (inputVal + quantity) + delta();
        int importantValue0 = (inputVal + yearToDate) + 100;
        if((yearToDate - importantValue)  > 100){
            importantValue -= 20;
        }
        int importantValue1 = importantValue0 * 7;
        return importantValue1 - 2 * importantValue0;
    }

    private int delta(){
        return 0;
    }
}
