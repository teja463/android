package com.example.bponnuru.wicketfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;
    int teamAFellWickets = 0;
    int teamBFellWickets = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTeamAScore(teamAScore);
        displayTeamBScore(teamBScore);
    }

    public void addSixForTeamA(View view) {
        teamAScore += 6;
        displayTeamAScore(teamAScore);
    }

    public void addFourForTeamA(View view) {
        teamAScore += 4;
        displayTeamAScore(teamAScore);
    }

    public void addThreeForTeamA(View view) {
        teamAScore += 3;
        displayTeamAScore(teamAScore);
    }

    public void addTwoForTeamA(View view) {
        teamAScore += 2;
        displayTeamAScore(teamAScore);
    }

    public void addOneForTeamA(View view) {
        teamAScore += 1;
        displayTeamAScore(teamAScore);
    }

    public void addSixForTeamB(View view) {
        teamBScore += 6;
        displayTeamBScore(teamBScore);
    }

    public void addFourForTeamB(View view) {
        teamBScore += 4;
        displayTeamBScore(teamBScore);
    }

    public void addThreeForTeamB(View view) {
        teamBScore += 3;
        displayTeamBScore(teamBScore);
    }

    public void addTwoForTeamB(View view) {
        teamBScore += 2;
        displayTeamBScore(teamBScore);
    }

    public void addOneForTeamB(View view) {
        teamBScore += 1;
        displayTeamBScore(teamBScore);
    }

    public void takeWicketForTeamA(View view) {
        teamAFellWickets++;
        displayWicketsFellForTeamA(teamAFellWickets);
    }

    public void takeWicketForTeamB(View view) {
        teamBFellWickets++;
        displayWicketsFellForTeamB(teamBFellWickets);
    }

    public void clearContentForTeamA(View view){
        teamAScore = 0;
        teamAFellWickets = 0;
        TextView view2 = (TextView) findViewById(R.id.team_a_wicketfall);
        view2.setText("");
        displayTeamAScore(teamAScore);
    }

    public void clearContentForTeamB(View view){
        teamBScore = 0;
        teamBFellWickets = 0;
        TextView view2 = (TextView) findViewById(R.id.team_b_wicketfall);
        view2.setText("");
        displayTeamBScore(teamBScore);
    }
    private void displayWicketsFellForTeamB(int teamBFellWickets) {
        if (teamBFellWickets <= 10) {
            TextView view = (TextView) findViewById(R.id.team_b_wicketfall);
            CharSequence text = view.getText();
            view.setText(text + "\n" + teamBScore + "/" + teamBFellWickets);
        }
    }

    private void displayWicketsFellForTeamA(int teamAFellWickets) {
        if (teamAFellWickets <= 10) {
            TextView view = (TextView) findViewById(R.id.team_a_wicketfall);
            CharSequence text = view.getText();
            view.setText(text + "\n" + teamAScore + "/" + teamAFellWickets);
        }
    }

    private void displayTeamAScore(int i) {
        if(teamAFellWickets<=10){

        TextView view = (TextView) findViewById(R.id.team_a_score);
        view.setText(String.valueOf(i));
        }
    }

    private void displayTeamBScore(int teamBScore) {
        if(teamBFellWickets<=10){

        TextView view = (TextView) findViewById(R.id.team_b_score);
        view.setText(String.valueOf(teamBScore));
        }
    }


}
