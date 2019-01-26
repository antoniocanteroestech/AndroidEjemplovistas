package softepec.es.vistas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3;
    private ImageButton imageButton;
    private ToggleButton toggleButton;
    private Switch mSwitch;
    private CheckBox checkBox1, checkBox2;
    private EditText editText;
    private TextView textView;
    private String textFromEditText;
    private RadioGroup radioGroup;
    private RadioButton radio1, radio2;
    private ProgressBar progressBar1, progressBar2, progressBar3;
    private int progressStatus;
    private Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(this);

        button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(this);

        imageButton = findViewById(R.id.imbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "ImageButton clicked!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        mSwitch = findViewById(R.id.sw);
        mSwitch.setOnClickListener(this);

        toggleButton = findViewById(R.id.tgBtn);
        toggleButton.setOnClickListener(this);

        checkBox1 = findViewById(R.id.chbx1);
        checkBox1.setOnClickListener(this);

        checkBox2 = findViewById(R.id.chbx2);
        checkBox2.setOnClickListener(this);

        editText = findViewById(R.id.et);
        textView = findViewById(R.id.txt);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                textFromEditText = editText.getText().toString();
                textView.setText(textFromEditText);
            }
        });


        radioGroup = findViewById(R.id.radiogroup);

        progressBar1 = findViewById(R.id.progressbar1);
        progressBar2 = findViewById(R.id.progressbar2);
        progressBar3 = findViewById(R.id.progressbar3);


    }




    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(this, "Botón 1 clicked!!",
                        Toast.LENGTH_SHORT).show();

                comprobarRadioButton();

                break;
            case R.id.btn2:
                Toast.makeText(this, "Botón 2 clicked!!",
                        Toast.LENGTH_SHORT).show();

                iniciarPogressBar3();
                break;
            case R.id.btn3:
                Toast.makeText(this, "Botón 3 clicked!!",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.tgBtn:
                textView.setText("ToggleButton: " + String.valueOf(toggleButton.isChecked()));

                if (toggleButton.isChecked()){
                    progressBar1.setVisibility(View.VISIBLE);
                } else {
                    progressBar1.setVisibility(View.INVISIBLE);
                }

                break;
            case R.id.sw:
                textView.setText("Switch: " + String.valueOf(mSwitch.isChecked()));

                if (mSwitch.isChecked()){
                    progressBar2.setVisibility(View.VISIBLE);
                } else {
                    progressBar2.setVisibility(View.INVISIBLE);
                }


                break;
            case R.id.chbx1:
                textView.setText("Checkbox 1: " + String.valueOf(checkBox1.isChecked()));
                break;
            case R.id.chbx2:
                textView.setText("Checkbox 2: " + String.valueOf(checkBox2.isChecked()));
                break;
        }

    }

    private void iniciarPogressBar3() {

        progressStatus = 0;

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar3.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar3.getMax());
                        }
                    });

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void comprobarRadioButton(){
        if (radioGroup.getCheckedRadioButtonId() == R.id.radio1) {
            final String text = "Radio 1 checked";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        } else {
            final String text = "Radio 2 checked";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
