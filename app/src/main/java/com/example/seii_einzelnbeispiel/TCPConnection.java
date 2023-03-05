package com.example.seii_einzelnbeispiel;

import android.widget.TextView;
import java.io.IOException;
import java.net.Socket;

public class TCPConnection extends Thread {
    private Socket socket;
    private String hostname;
    private int port;
    private TextView responseText;

    public TCPConnection(String hostname, int port, TextView responseText) {
        this.hostname = hostname;
        this.port = port;
        this.responseText = responseText;
    }

    public void run(){
        try {
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}