package com.android.quizz;

import android.content.Context;

/**
 * Created by ankita on 17/8/17.
 */
public class Categories {

    private int ID;
    private String ime;

    public Categories(int ID, String ime){
        this.ID = ID;
        this.ime = ime;

    }

    public String getIme()
    {
        return ime;
    }

    public int getTmbImageId(Context context) {
        return context.getResources().getIdentifier("img"+ID, "drawable", "com.android.quizz");
    }


}
