package com.android.quizz;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankita on 10/8/17.
 */
public class DataHandler {

    List<String> list = new ArrayList<String>();
    List<Category> quesList = new ArrayList<Category>();

    //Create new objects that are stored in the tables
    public void addQuestions() {
        List<String> questionlist = new ArrayList<String>();
        questionlist = ParseFile("res/raw/questions.txt");
        String[] separated;

        for (int i=0; i<questionlist.size(); i++) {
            separated = questionlist.get(i).split(";");
            try {
                Log.w("q raw", separated[0] + separated[1] + separated[2] + separated[3] + separated[4] + separated[5]+separated[6]);
                Category c = new Category(separated[0], separated[1], separated[2], separated[3], separated[4], separated[5], separated[6]);
                quesList.add(c);
            }catch(Exception e) {
                Log.d("Incorrect format " , questionlist.get(i));
            }
        }
    }


    public List<String> ParseFile(String filename){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String str; // String in which the question (line of text file)
        try {
            while ((str = reader.readLine()) != null) {
                Log.w("added string", str);
                list.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Category> getAllQuestions() {
        //String selectQuery = "SELECT  * FROM " + TABLE_IT;
        return  quesList;
    }

    public List<String> getAllQuestions1() {
        return list;

    }

}
