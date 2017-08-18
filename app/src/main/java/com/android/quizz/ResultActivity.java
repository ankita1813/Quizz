package com.android.quizz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ankita on 10/8/17.
 */
public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        //get text view
        TextView t=(TextView)findViewById(R.id.tvresult);
        Button returnButton = (Button)findViewById(R.id.returnButton);
        //get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        Log.d("result", "" + score);
        //display score
        t.setText("Correctly answered "+score+ " Of 5 questions ");

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
