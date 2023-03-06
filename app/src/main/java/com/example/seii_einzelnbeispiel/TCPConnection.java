package com.example.seii_einzelnbeispiel;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPConnection extends Thread {
    private Socket clientSocket;
    private String response;
    private final String hostname;
    private final int port;
    private final String matriculationNumber;

    public TCPConnection(String hostname, int port, String matriculationNumber) {
        this.hostname = hostname;
        this.port = port;
        this.matriculationNumber = matriculationNumber;
    }

    public String getResponse(){
        return response;
    }

    public void run(){
        try {
            clientSocket = new Socket();
            clientSocket.connect(new InetSocketAddress(hostname, port), 5000);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(matriculationNumber + '\n');
            
            response = inFromServer.readLine();

        } catch (IOException e) {
            Log.e("TCPConnection", "Error", e);
        }
        finally {
            if(clientSocket != null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    Log.e("TCPConnection", "Error closing socket", e);
                }
            }
        }
    }
}