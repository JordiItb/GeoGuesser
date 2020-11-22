package cat.itb.geoguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startButton;
    Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        quitButton = findViewById(R.id.quitButton);

        startButton.setOnClickListener(this);
        quitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.startButton:

                Intent i = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(i);
                break;

            case R.id.quitButton:

                finish();
                break;

        }

    }
}