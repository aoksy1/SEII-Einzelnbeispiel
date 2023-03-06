package com.example.seii_einzelnbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String hostname = "se2-isys.aau.at";
    final int port = 53212;
    Button btnSendRequest;
    Button btnCalculate;
    EditText txtMatriculationNumber;
    TextView txtResponseText;
    String matriculationNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendRequest = (Button) findViewById(R.id.btnSend);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        txtMatriculationNumber = (EditText) findViewById(R.id.editTextNumberSigned);
        txtResponseText = (TextView) findViewById(R.id.textView2);

        btnSendRequest.setOnClickListener(v -> {
            matriculationNumber = txtMatriculationNumber.getText().toString();
            if(!matriculationNumber.isEmpty() && matriculationNumber.matches("[0-9]+")){
                TCPConnection tcpConnection = new TCPConnection(hostname, port, txtResponseText, matriculationNumber);
                tcpConnection.start();
            }
            else if(matriculationNumber.isEmpty()) Toast.makeText(getApplicationContext(), "Please enter matricualation number!", Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(), "Matriculation number must contain only numbers!", Toast.LENGTH_SHORT).show();
        });

        btnCalculate.setOnClickListener(v -> {
            matriculationNumber = txtMatriculationNumber.getText().toString();
            if(!matriculationNumber.isEmpty() && matriculationNumber.matches("[0-9]+")){
                Rechner rechner = new Rechner();
                int matriculationNumberSum = rechner.querSumme(matriculationNumber);
                txtResponseText.setText(rechner.intToBinary(matriculationNumberSum));
            }
            else if(matriculationNumber.isEmpty()) Toast.makeText(getApplicationContext(), "Please enter matricualation number!", Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(), "Matriculation number must contain only numbers!", Toast.LENGTH_SHORT).show();
        });
    }
}