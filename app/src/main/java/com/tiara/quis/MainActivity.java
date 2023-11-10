package com.tiara.quis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText nilai_tugas, nilai_quis, nilai_uts, nilai_uas;
    Button proses, bersihkan;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        nilai_quis = (EditText) findViewById(R.id.nilai_quis);
        nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        nilai_uas = (EditText) findViewById(R.id.nilai_uas);
        proses = (Button)findViewById(R.id.proses);
        bersihkan = (Button) findViewById(R.id.bersihkan);
        hasil = (TextView) findViewById(R.id.hasil);


        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nilai_tugas.getText().length() > 0 && nilai_quis.getText().length() > 0 && nilai_uts.getText().length() > 0 &&nilai_uts.getText().length() > 0)
                {
                    double tugas = Double.parseDouble(nilai_tugas.getText().toString());
                    double quis =Double.parseDouble(nilai_quis.getText().toString());
                    double uts =Double.parseDouble(nilai_uts.getText().toString());
                    double uas =Double.parseDouble(nilai_uas.getText().toString());
                    double result = (tugas*20/100) + (quis*20/100) + (uts*30/100) + (uas*30/100);
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan nilai_tugas, nilai_quis,nilai_uts & nilai_uas ", Toast.LENGTH_LONG);
                            toast.show();
                }
            }
        });
        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai_tugas.setText("");
                nilai_quis.setText("");
                nilai_uts.setText("");
                nilai_uas.setText("");
                hasil.setText("0");
                nilai_tugas.requestFocus();
            }
        });
    }
}