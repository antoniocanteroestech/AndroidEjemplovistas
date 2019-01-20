package softepec.es.vistas;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2, button3;
    ImageButton imageButton;
    ToggleButton toggleButton;
    Switch mSwitch;
    CheckBox checkBox1, checkBox2;
    EditText editText;
    TextView textView;
    String textFromEditText;

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


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn1:
                Toast.makeText(this, "Botón 1 clicked!!",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                Toast.makeText(this, "Botón 2 clicked!!",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn3:
                Toast.makeText(this, "Botón 3 clicked!!",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.tgBtn:
                textView.setText("ToggleButton: " + String.valueOf(toggleButton.isChecked()));
                break;
            case R.id.sw:
                textView.setText("Switch: " + String.valueOf(mSwitch.isChecked()));
                break;
            case R.id.chbx1:
                textView.setText("Checkbox 1: " + String.valueOf(checkBox1.isChecked()));
                break;
            case R.id.chbx2:
                textView.setText("Checkbox 2: " + String.valueOf(checkBox2.isChecked()));
                break;
        }

    }
}
