package com.example.seii_einzelnbeispiel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String hostname = "se2-isys.aau.at";
    final int port = 53212;
    Button btnSendRequest;
    EditText txtMatriculationNumber;
    TextView txtResponseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendRequest = (Button) findViewById(R.id.btnSend);
        txtMatriculationNumber = (EditText) findViewById(R.id.editTextNumberSigned);
        txtResponseText = (TextView) findViewById(R.id.textView2);


        btnSendRequest.setOnClickListener(v -> {
            TCPConnection tcpConnection = new TCPConnection(hostname, port, txtResponseText, txtMatriculationNumber.getText().toString());
            tcpConnection.start();
        });
    }
}