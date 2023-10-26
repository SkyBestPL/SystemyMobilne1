package pl.edu.pb.wi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_EXTRA_ANSWER = "pl.edu.pb.wi.quiz.correctAnswer";
    private static final String KEY_CURRENT_INDEX = "currentIndex";
    private static final String KEY_COUNTER = "counter";
    private static final String KEY_CORRECT_COUNTER = "correctCounter";
    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE_PROMPT = 0;
    private TextView questionTextView;
    private Button trueButton, falseButton, nextButton, promptButton;
    private Question[] questions = new Question[] {
            new Question(R.string.q_activity, true),
            new Question(R.string.q_find_resources, false),
            new Question(R.string.q_listener, true),
            new Question(R.string.q_resources, true),
            new Question(R.string.q_version, false)
    };
    private int currentIndex = 0;
    private int correctCounter = 0;
    private int counter = 0;
    boolean answerWasShown;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState() method called");
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
        outState.putInt(KEY_COUNTER, counter);
        outState.putInt(KEY_CORRECT_COUNTER, correctCounter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != RESULT_OK) {return;}
        if(requestCode == REQUEST_CODE_PROMPT){
            if(data == null) {return;}
            answerWasShown = data.getBooleanExtra(PromptActivity.KEY_EXTRA_ANSWER_SHOWN, false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() method called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() method called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() method called");
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
            counter = savedInstanceState.getInt(KEY_COUNTER);
            correctCounter = savedInstanceState.getInt(KEY_CORRECT_COUNTER);
        }

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        promptButton = findViewById(R.id.prompt_button);
        questionTextView = findViewById(R.id.question_text_view);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(true);
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswerCorrectness(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questions.length;
                answerWasShown = false;
                setNextQuestion();
            }
        });

        promptButton.setOnClickListener((v) -> {
            Intent intent = new Intent( MainActivity.this, PromptActivity.class);
            boolean correctAnswer = questions [currentIndex].isTrueAnswer();
            intent.putExtra(KEY_EXTRA_ANSWER, correctAnswer);
            startActivityForResult(intent, REQUEST_CODE_PROMPT);
        });
    }

    private void checkAnswerCorrectness(boolean userAnswer) {
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId;
        if(answerWasShown)
        {
            resultMessageId = R.string.answer_was_shown;
        }
        else
        {
            if (userAnswer == correctAnswer)
            {
                resultMessageId = R.string.correct_answer;
                correctCounter++;
                counter++;
            }
            else
            {
                resultMessageId = R.string.incorrect_answer;
                counter++;
            }
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion() {
        if (counter == 5) {
            questionTextView.setText(questions[currentIndex].getId());
            Toast.makeText(this, "Liczba poprawnych odpowiedzi: " + correctCounter, Toast.LENGTH_SHORT).show();
        } else {
            questionTextView.setText(questions[currentIndex].getId());
        }
    }
}