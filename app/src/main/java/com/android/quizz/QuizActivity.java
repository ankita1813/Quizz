package com.android.quizz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends Activity

{

    List<Category> quesList;
    List<History> quesListHistory = new ArrayList<History>();
    List<Sport> quesListSport = new ArrayList<Sport>();
    List<Geography> quesListGeography = new ArrayList<Geography>();
    List<Science> quesListScience = new ArrayList<Science>();
    List<Art> quesListArt = new ArrayList<Art>();
    ArrayList<Integer> randomListHistory = new ArrayList<Integer>();
    ArrayList<Integer> randomListGeography = new ArrayList<Integer>();
    ArrayList<Integer> randomListSport = new ArrayList<Integer>();
    ArrayList<Integer> randomListScience = new ArrayList<Integer>();
    ArrayList<Integer> randomListArt = new ArrayList<Integer>();

    int score = 0;
    int counterquestions = 1;
    int number = 1;

    History currentQHistory;
    Sport currentQSport;
    Geography currentQGeography;
    Science currentQScience;
    Art currentQArt;

    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        DataHandler dataHandler = new DataHandler();
        dataHandler.addQuestions();
        quesList = dataHandler.getAllQuestions();
        //SORT ALL QUESTIONS PER CATEGORY
        for (Category c : quesList) {
            if (c.getCATEGORY().equals("history")) {
                currentQHistory = historyList(c);
                quesListHistory.add(currentQHistory);
            } else if (c.getCATEGORY().equals("geography")) {
                currentQGeography = geographyList(c);
                quesListGeography.add(currentQGeography);
            } else if (c.getCATEGORY().equals("sport")) {
                currentQSport = sportList (c);
                quesListSport.add(currentQSport);
            } else if (c.getCATEGORY().equals("art")) {
                currentQArt = artList (c);
                quesListArt.add(currentQArt);
            } else if (c.getCATEGORY().equals("science")) {
                currentQScience = scienceList(c);
                quesListScience.add(currentQScience);
            }
        }

        for (int i = 0; i < quesListHistory.size(); i++) {
            randomListHistory.add(i);
        }
        for (int i = 0; i < quesListGeography.size(); i++) {
            randomListGeography.add(i);
        }
        for (int i = 0; i < quesListSport.size(); i++) {
            randomListSport.add(i);
        }
        for (int i = 0; i < quesListScience.size(); i++) {
            randomListScience.add(i);
        }
        for (int i = 0; i < quesListArt.size(); i++) {
            randomListArt.add(i);
        }

        Collections.shuffle(randomListHistory);//[3,2,4,5,1,6]
        Collections.shuffle(randomListGeography);
        Collections.shuffle(randomListSport);
        Collections.shuffle(randomListScience);
        Collections.shuffle(randomListArt);

        txtQuestion = (TextView) findViewById(R.id.tv);
        rda = (RadioButton) findViewById(R.id.radioButton);
        rdb = (RadioButton) findViewById(R.id.radioButton2);
        rdc = (RadioButton) findViewById(R.id.radioButton3);
        rdd = (RadioButton) findViewById(R.id.radioButton4);

        butNext = (Button) findViewById(R.id.btnnext);
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("Position");
        final Integer position = Integer.valueOf(value);
        //Log.d("Position", position + "");
        setQuestionView(0,0);


        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());

                try {
                    if (position == 0) {
                        if (currentQHistory.getANSWER().equals(answer.getText())) {
                            score++;
                            showToastCorrect();

                        } else {
                            showToastIncorrect();
                        }

                        if (counterquestions < 5) {
                            grp.clearCheck();
                            setQuestionView(position, number);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                        number += 1;
                        counterquestions++;
                    } else if (position == 1) {
                        if (currentQSport.getANSWER().equals(answer.getText())) {
                            score++;
                            showToastCorrect();
                        } else {
                            showToastIncorrect();
                        }
                        if (counterquestions < 5) {
                            currentQSport = quesListSport.get(randomListSport.get(number));
                            grp.clearCheck();
                            setQuestionView(position, number);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                        number += 1;
                        counterquestions++;

                    } else if (position == 2) {
                        if (currentQGeography.getANSWER().equals(answer.getText())) {
                            score++;
                            showToastCorrect();
                        } else {
                            showToastIncorrect();
                        }
                        if (counterquestions < 5) {
                            currentQGeography = quesListGeography.get(randomListGeography.get(number));
                            grp.clearCheck();
                            setQuestionView(position, number);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                        number += 1;
                        counterquestions++;
                    } else if (position == 3) {
                        if (currentQScience.getANSWER().equals(answer.getText())) {
                            score++;
                            showToastCorrect();
                        } else {
                            showToastIncorrect();
                        }
                        if (counterquestions < 5) {
                            currentQScience = quesListScience.get(randomListScience.get(number));
                            grp.clearCheck();
                            setQuestionView(position, number);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                        number += 1;
                        counterquestions++;
                    } else if (position == 4) {
                        if (currentQArt.getANSWER().equals(answer.getText())) {
                            score++;
                            showToastCorrect();
                        } else {
                            showToastIncorrect();
                        }
                        if (counterquestions < 5) {
                            currentQArt = quesListArt.get(randomListArt.get(number));
                            grp.clearCheck();
                            setQuestionView(position, number);
                        } else {
                            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                            Bundle b = new Bundle();
                            b.putInt("score", score); //Your score
                            intent.putExtras(b); //Put your score to your next Intent
                            startActivity(intent);
                            finish();
                        }
                        number += 1;
                        counterquestions++;
                    }
                } catch (NullPointerException e) {
                    //Toast.makeText(getApplicationContext(), "Reply not marked!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private History historyList(Category c){
        History history = new History();
        history.setANSWER(c.getANSWER());
        history.setOPTA(c.getOPTA());
        history.setOPTB(c.getOPTB());
        history.setOPTC(c.getOPTC());
        history.setOPTD(c.getOPTD());
        history.setQUESTION(c.getQUESTION());
        return history;
    }
    private Sport sportList(Category c){
        Sport sport = new Sport();
        sport.setANSWER(c.getANSWER());
        sport.setOPTA(c.getOPTA());
        sport.setOPTB(c.getOPTB());
        sport.setOPTC(c.getOPTC());
        sport.setOPTD(c.getOPTD());
        sport.setQUESTION(c.getQUESTION());
        return sport;
    }
    private Geography geographyList(Category c){
        Geography geography = new Geography();
        geography.setANSWER(c.getANSWER());
        geography.setOPTA(c.getOPTA());
        geography.setOPTB(c.getOPTB());
        geography.setOPTC(c.getOPTC());
        geography.setOPTD(c.getOPTD());
        geography.setQUESTION(c.getQUESTION());
        return geography;
    }
    private Science scienceList(Category c){
        Science science = new Science();
        science.setANSWER(c.getANSWER());
        science.setOPTA(c.getOPTA());
        science.setOPTB(c.getOPTB());
        science.setOPTC(c.getOPTC());
        science.setOPTD(c.getOPTD());
        science.setQUESTION(c.getQUESTION());
        return science;
    }
    private Art artList(Category c){
        Art art = new Art();
        art.setANSWER(c.getANSWER());
        art.setOPTA(c.getOPTA());
        art.setOPTB(c.getOPTB());
        art.setOPTC(c.getOPTC());
        art.setOPTD(c.getOPTD());
        art.setQUESTION(c.getQUESTION());
        return art;
    }
    private void showToastCorrect(){
        Toast.makeText(getApplicationContext(), "Correct answer!", Toast.LENGTH_SHORT).show();
    }
    private void showToastIncorrect(){
        Toast.makeText(getApplicationContext(), "Incorrect response!", Toast.LENGTH_SHORT).show();

    }
    private void setQuestionView(int position, int number) {
        if(position ==0){
            currentQHistory = quesListHistory.get(randomListHistory.get(number));
            txtQuestion.setText(currentQHistory.getQUESTION());
            rda.setText(currentQHistory.getOPTA());
            rdb.setText(currentQHistory.getOPTB());
            rdc.setText(currentQHistory.getOPTC());
            rdd.setText(currentQHistory.getOPTD());
        }
        if(position ==1){
            currentQSport = quesListSport.get(randomListSport.get(number));
            txtQuestion.setText(currentQSport.getQUESTION());
            rda.setText(currentQSport.getOPTA());
            rdb.setText(currentQSport.getOPTB());
            rdc.setText(currentQSport.getOPTC());
            rdd.setText(currentQSport.getOPTD());
        }
        if(position ==2){
            currentQGeography = quesListGeography.get(randomListGeography.get(number));
            txtQuestion.setText(currentQGeography.getQUESTION());
            rda.setText(currentQGeography.getOPTA());
            rdb.setText(currentQGeography.getOPTB());
            rdc.setText(currentQGeography.getOPTC());
            rdd.setText(currentQGeography.getOPTD());
        }
        if(position ==3){
            currentQScience = quesListScience.get(randomListScience.get(number));
            txtQuestion.setText(currentQScience.getQUESTION());
            rda.setText(currentQScience.getOPTA());
            rdb.setText(currentQScience.getOPTB());
            rdc.setText(currentQScience.getOPTC());
            rdd.setText(currentQScience.getOPTD());
        }
        if(position ==4){
            currentQArt = quesListArt.get(randomListArt.get(number));
            txtQuestion.setText(currentQArt.getQUESTION());
            rda.setText(currentQArt.getOPTA());
            rdb.setText(currentQArt.getOPTB());
            rdc.setText(currentQArt.getOPTC());
            rdd.setText(currentQArt.getOPTD());
        }
    }
}
