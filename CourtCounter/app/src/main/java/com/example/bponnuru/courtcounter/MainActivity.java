package com.example.bponnuru.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeForTeamA(View view){
        teamAScore = teamAScore +3;
        displayTeamAScope(teamAScore);
    }

    public void addTwoForTeamA(View view){
        teamAScore += 2;
        displayTeamAScope(teamAScore);
    }

    public void addOneForTeamA(View view){
        teamAScore += 1;
        displayTeamAScope(teamAScore);
    }

    private void displayTeamAScope(int i){
        TextView view = (TextView) findViewById(R.id.team_a_score);
        view.setText(String.valueOf(i));
    }

    public void addThreeForTeamB(View view){
        teamBScore += 3;
        displayTeamBScore(teamBScore);
    }

    public void addTwoForTeamB(View view){
        teamBScore += 2;
        displayTeamBScore(teamBScore);
    }

    public void addOneForTeamB(View view){
        teamBScore += 1;
        displayTeamBScore(teamBScore);
    }

    private void displayTeamBScore(int i){
        TextView view = (TextView) findViewById(R.id.team_b_score);
        view.setText(String.valueOf(i));
    }

    public void resetScores(View view){
        teamAScore = 0;
        teamBScore = 0;
        displayTeamAScope(teamAScore);
        displayTeamBScore(teamBScore);
    }

}
