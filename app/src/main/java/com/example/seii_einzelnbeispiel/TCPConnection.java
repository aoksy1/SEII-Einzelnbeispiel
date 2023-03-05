package com.example.seii_einzelnbeispiel;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPConnection extends Thread {
    private Socket clientSocket;
    private String hostname;
    private int port;
    private TextView responseText;
    private String matriculationNumber;

    public TCPConnection(String hostname, int port, TextView responseText, String matriculationNumber) {
        this.hostname = hostname;
        this.port = port;
        this.responseText = responseText;
        this.matriculationNumber = matriculationNumber;
    }

    public void run(){
        try {
            clientSocket = new Socket(hostname, port);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(matriculationNumber + '\n');
            Log.e("Tag", "amar "+inFromServer.readLine() + matriculationNumber);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}