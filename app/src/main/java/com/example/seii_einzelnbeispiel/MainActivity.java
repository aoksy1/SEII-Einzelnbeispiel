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
    EditText txtMatriculationNumber;
    TextView txtResponseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String matriculationNumber;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendRequest = (Button) findViewById(R.id.btnSend);
        txtMatriculationNumber = (EditText) findViewById(R.id.editTextNumberSigned);
        matriculationNumber = txtMatriculationNumber.getText().toString();
        txtResponseText = (TextView) findViewById(R.id.textView2);


        btnSendRequest.setOnClickListener(v -> {
            if(!matriculationNumber.isEmpty() && matriculationNumber.matches("[0-9]")){
                TCPConnection tcpConnection = new TCPConnection(hostname, port, txtResponseText, matriculationNumber);
                tcpConnection.start();
            }
            else if(matriculationNumber.isEmpty()) Toast.makeText(getApplicationContext(), "Please enter matricualation number!", Toast.LENGTH_SHORT).show();
            else Toast.makeText(getApplicationContext(), "Matriculation number must contain only numbers!", Toast.LENGTH_SHORT).show();
        });
    }
}