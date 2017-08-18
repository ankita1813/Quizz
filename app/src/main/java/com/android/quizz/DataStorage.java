package com.android.quizz;

import java.util.HashMap;

/**
 * Created by ankita on 10/8/17.
 */
public class DataStorage {
    private static String[] imena  = {"History","Sport","Geography","Science","Art"};

    public static HashMap<Integer,Categories> listViewData = new HashMap<Integer, Categories>();

    public static void fillData() {
        for (int i=0;i<imena.length;i++){
            Categories catogory = new Categories(i, imena[i]);
            listViewData.put(i,catogory);
        }
    }
}
