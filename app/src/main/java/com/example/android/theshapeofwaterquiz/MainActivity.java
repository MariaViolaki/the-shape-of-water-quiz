package com.example.android.theshapeofwaterquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remove focus from EditText when activity is created
        EditText nameSubmitted = findViewById(R.id.name_submitted);
        nameSubmitted.clearFocus();
    }

    public int calculatePoints() {

        //Find Views on XML
        EditText nameSubmitted = findViewById(R.id.name_submitted);
        RadioButton hellboy = findViewById(R.id.hellboy);
        RadioButton theOrphanage = findViewById(R.id.the_orphanage);
        RadioButton cronos = findViewById(R.id.cronos);
        RadioButton pansLabyrinth = findViewById(R.id.pans_labyrinth);
        RadioButton mute = findViewById(R.id.mute);
        RadioButton dyslexic = findViewById(R.id.dyslexic);
        RadioButton deaf = findViewById(R.id.deaf);
        RadioButton autistic = findViewById(R.id.autistic);
        CheckBox biography = findViewById(R.id.biography);
        CheckBox fantasy = findViewById(R.id.fantasy);
        CheckBox scienceFiction = findViewById(R.id.science_fiction);
        CheckBox drama = findViewById(R.id.drama);
        RadioButton audiencesTrue = findViewById(R.id.audiences_true);
        RadioButton audiencesFalse = findViewById(R.id.audiences_false);
        CheckBox harmless = findViewById(R.id.harmless);
        CheckBox amphibious = findViewById(R.id.amphibious);
        CheckBox healing = findViewById(R.id.healing);
        CheckBox intelligent = findViewById(R.id.intelligent);
        RadioButton forties = findViewById(R.id.forties);
        RadioButton sixties = findViewById(R.id.sixties);
        RadioButton eighties = findViewById(R.id.eighties);
        RadioButton twoThousands = findViewById(R.id.two_thousands);
        RadioButton australia = findViewById(R.id.australia);
        RadioButton africa = findViewById(R.id.africa);
        RadioButton europe = findViewById(R.id.europe);
        RadioButton southAmerica = findViewById(R.id.south_america);
        RadioButton friendsTrue = findViewById(R.id.friends_true);
        RadioButton friendsFalse = findViewById(R.id.friends_false);
        CheckBox flood = findViewById(R.id.flood);
        CheckBox cinema = findViewById(R.id.cinema);
        CheckBox dance = findViewById(R.id.dance);
        CheckBox book = findViewById(R.id.book);

        //EditText possible answers
        String nameSubmittedConverted = nameSubmitted.getText().toString();
        nameSubmittedConverted = nameSubmittedConverted.trim();
        String fullName = getString(R.string.full_name);

        //Check answers and calculate points
        int successPoints = 0;

        if (nameSubmittedConverted.equals(fullName)) {
            successPoints += 10;
        }
        if (hellboy.isChecked()) successPoints -= 5;
        if (theOrphanage.isChecked()) successPoints += 10;
        if (cronos.isChecked()) successPoints -= 5;
        if (pansLabyrinth.isChecked()) successPoints -= 5;
        if (mute.isChecked()) successPoints += 10;
        if (dyslexic.isChecked()) successPoints -= 5;
        if (deaf.isChecked()) successPoints -= 5;
        if (autistic.isChecked()) successPoints -= 5;
        if (biography.isChecked()) successPoints -= 5;
        if (fantasy.isChecked()) successPoints += 10;
        if (scienceFiction.isChecked()) successPoints -= 5;
        if (drama.isChecked()) successPoints += 10;
        if (audiencesTrue.isChecked()) successPoints -= 5;
        if (audiencesFalse.isChecked()) successPoints += 10;
        if (harmless.isChecked()) successPoints -= 5;
        if (amphibious.isChecked()) successPoints += 10;
        if (healing.isChecked()) successPoints += 10;
        if (intelligent.isChecked()) successPoints += 10;
        if (forties.isChecked()) successPoints -= 5;
        if (sixties.isChecked()) successPoints += 10;
        if (eighties.isChecked()) successPoints -= 5;
        if (twoThousands.isChecked()) successPoints -= 5;
        if (australia.isChecked()) successPoints -= 5;
        if (africa.isChecked()) successPoints -= 5;
        if (europe.isChecked()) successPoints -= 5;
        if (southAmerica.isChecked()) successPoints += 10;
        if (friendsTrue.isChecked()) successPoints += 10;
        if (friendsFalse.isChecked()) successPoints -= 5;
        if (flood.isChecked()) successPoints += 10;
        if (cinema.isChecked()) successPoints += 10;
        if (dance.isChecked()) successPoints += 10;
        if (book.isChecked()) successPoints -= 5;

        //Eliminate negative score
        if (successPoints < 0) successPoints = 0;

        return successPoints;
    }

    private int findPercentage() {
        int percentage = calculatePoints() * 100 / 150;
        return percentage;
    }

    public void displayResults() {

        /// Find Results Views on XML
        LinearLayout resultsLayout = findViewById(R.id.results_layout);
        TextView score = findViewById(R.id.score);
        TextView congratulations = findViewById(R.id.congratulations);
        TextView poem = findViewById(R.id.poem);
        TextView retry = findViewById(R.id.retry);

        //Display appropriate score
        score.setText(String.format(getResources().getString(R.string.score), findPercentage()));

        //Display appropriate tips
        resultsLayout.setVisibility(View.VISIBLE);
        resultsLayout.requestFocus();

        if (findPercentage() == 100) {
            congratulations.setVisibility(View.VISIBLE);
            poem.setVisibility(View.VISIBLE);
            retry.setVisibility(View.GONE);
        } else {
            congratulations.setVisibility(View.GONE);
            poem.setVisibility(View.GONE);
            retry.setVisibility(View.VISIBLE);
        }
    }

    public boolean checkUnanswered() {

        //Find Views on XML
        EditText fullName = findViewById(R.id.name_submitted);
        RadioButton hellboy = findViewById(R.id.hellboy);
        RadioButton theOrphanage = findViewById(R.id.the_orphanage);
        RadioButton cronos = findViewById(R.id.cronos);
        RadioButton pansLabyrinth = findViewById(R.id.pans_labyrinth);
        RadioButton mute = findViewById(R.id.mute);
        RadioButton dyslexic = findViewById(R.id.dyslexic);
        RadioButton deaf = findViewById(R.id.deaf);
        RadioButton autistic = findViewById(R.id.autistic);
        CheckBox biography = findViewById(R.id.biography);
        CheckBox fantasy = findViewById(R.id.fantasy);
        CheckBox scienceFiction = findViewById(R.id.science_fiction);
        CheckBox drama = findViewById(R.id.drama);
        RadioButton audiencesTrue = findViewById(R.id.audiences_true);
        RadioButton audiencesFalse = findViewById(R.id.audiences_false);
        CheckBox harmless = findViewById(R.id.harmless);
        CheckBox amphibious = findViewById(R.id.amphibious);
        CheckBox healing = findViewById(R.id.healing);
        CheckBox intelligent = findViewById(R.id.intelligent);
        RadioButton forties = findViewById(R.id.forties);
        RadioButton sixties = findViewById(R.id.sixties);
        RadioButton eighties = findViewById(R.id.eighties);
        RadioButton twoThousands = findViewById(R.id.two_thousands);
        RadioButton australia = findViewById(R.id.australia);
        RadioButton africa = findViewById(R.id.africa);
        RadioButton europe = findViewById(R.id.europe);
        RadioButton southAmerica = findViewById(R.id.south_america);
        RadioButton friendsTrue = findViewById(R.id.friends_true);
        RadioButton friendsFalse = findViewById(R.id.friends_false);
        CheckBox flood = findViewById(R.id.flood);
        CheckBox cinema = findViewById(R.id.cinema);
        CheckBox dance = findViewById(R.id.dance);
        CheckBox book = findViewById(R.id.book);

        //Convert Editable to String
        String nameSubmitted = fullName.getText().toString();

        //Check if each question has at least one answer
        boolean question1;
        boolean question2;
        boolean question3;
        boolean question4;
        boolean question5;
        boolean question6;
        boolean question7;
        boolean question8;
        boolean question9;
        boolean question10;

        if (nameSubmitted.isEmpty()) {
            question1 = false;
        } else {
            question1 = true;
        }
        if (hellboy.isChecked() || theOrphanage.isChecked()
                || cronos.isChecked() || pansLabyrinth.isChecked()) {
            question2 = true;
        } else {
            question2 = false;
        }
        if (mute.isChecked() || dyslexic.isChecked()
                || deaf.isChecked() || autistic.isChecked()) {
            question3 = true;
        } else {
            question3 = false;
        }
        if (biography.isChecked() || fantasy.isChecked()
                || scienceFiction.isChecked() || drama.isChecked()) {
            question4 = true;
        } else {
            question4 = false;
        }
        if (audiencesTrue.isChecked() || audiencesFalse.isChecked()) {
            question5 = true;
        } else {
            question5 = false;
        }
        if (harmless.isChecked() || amphibious.isChecked()
                || healing.isChecked() || intelligent.isChecked()) {
            question6 = true;
        } else {
            question6 = false;
        }
        if (forties.isChecked() || sixties.isChecked()
                || eighties.isChecked() || twoThousands.isChecked()) {
            question7 = true;
        } else {
            question7 = false;
        }
        if (australia.isChecked() || africa.isChecked()
                || europe.isChecked() || southAmerica.isChecked()) {
            question8 = true;
        } else {
            question8 = false;
        }
        if (friendsTrue.isChecked() || friendsFalse.isChecked()) {
            question9 = true;
        } else {
            question9 = false;
        }
        if (flood.isChecked() || cinema.isChecked()
                || dance.isChecked() || book.isChecked()) {
            question10 = true;
        } else {
            question10 = false;
        }

        //Create a boolean to check all questions at once
        boolean hasUnanswered;

        if (question1 && question2 && question3 && question4 && question5
                && question6 && question7 && question8 && question9 && question10) {
            hasUnanswered = false;
        } else {
            hasUnanswered = true;
        }

        return hasUnanswered;
    }

    public void submitAnswers(View view) {
        if (checkUnanswered()) {
            Toast.makeText(this, getString(R.string.unanswered_questions), Toast.LENGTH_SHORT).show();
        } else {
            calculatePoints();
            displayResults();
            Toast.makeText(this, String.format(getResources().getString(R.string.score), findPercentage()), Toast.LENGTH_SHORT).show();
        }
    }

    public void startOver(View view) {
        recreate();

        //Find Views on XML
        EditText nameSubmitted = findViewById(R.id.name_submitted);
        RadioButton hellboy = findViewById(R.id.hellboy);
        RadioButton theOrphanage = findViewById(R.id.the_orphanage);
        RadioButton cronos = findViewById(R.id.cronos);
        RadioButton pansLabyrinth = findViewById(R.id.pans_labyrinth);
        RadioButton mute = findViewById(R.id.mute);
        RadioButton dyslexic = findViewById(R.id.dyslexic);
        RadioButton deaf = findViewById(R.id.deaf);
        RadioButton autistic = findViewById(R.id.autistic);
        CheckBox biography = findViewById(R.id.biography);
        CheckBox fantasy = findViewById(R.id.fantasy);
        CheckBox scienceFiction = findViewById(R.id.science_fiction);
        CheckBox drama = findViewById(R.id.drama);
        RadioButton audiencesTrue = findViewById(R.id.audiences_true);
        RadioButton audiencesFalse = findViewById(R.id.audiences_false);
        CheckBox harmless = findViewById(R.id.harmless);
        CheckBox amphibious = findViewById(R.id.amphibious);
        CheckBox healing = findViewById(R.id.healing);
        CheckBox intelligent = findViewById(R.id.intelligent);
        RadioButton forties = findViewById(R.id.forties);
        RadioButton sixties = findViewById(R.id.sixties);
        RadioButton eighties = findViewById(R.id.eighties);
        RadioButton twoThousands = findViewById(R.id.two_thousands);
        RadioButton australia = findViewById(R.id.australia);
        RadioButton africa = findViewById(R.id.africa);
        RadioButton europe = findViewById(R.id.europe);
        RadioButton southAmerica = findViewById(R.id.south_america);
        RadioButton friendsTrue = findViewById(R.id.friends_true);
        RadioButton friendsFalse = findViewById(R.id.friends_false);
        CheckBox flood = findViewById(R.id.flood);
        CheckBox cinema = findViewById(R.id.cinema);
        CheckBox dance = findViewById(R.id.dance);
        CheckBox book = findViewById(R.id.book);

        //Refresh every View
        nameSubmitted.getText().clear();
        hellboy.setChecked(false);
        theOrphanage.setChecked(false);
        cronos.setChecked(false);
        pansLabyrinth.setChecked(false);
        mute.setChecked(false);
        dyslexic.setChecked(false);
        deaf.setChecked(false);
        autistic.setChecked(false);
        biography.setChecked(false);
        fantasy.setChecked(false);
        scienceFiction.setChecked(false);
        drama.setChecked(false);
        audiencesTrue.setChecked(false);
        audiencesFalse.setChecked(false);
        harmless.setChecked(false);
        amphibious.setChecked(false);
        healing.setChecked(false);
        intelligent.setChecked(false);
        forties.setChecked(false);
        sixties.setChecked(false);
        eighties.setChecked(false);
        twoThousands.setChecked(false);
        australia.setChecked(false);
        africa.setChecked(false);
        europe.setChecked(false);
        southAmerica.setChecked(false);
        friendsTrue.setChecked(false);
        friendsFalse.setChecked(false);
        flood.setChecked(false);
        cinema.setChecked(false);
        dance.setChecked(false);
        book.setChecked(false);
    }
}