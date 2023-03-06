package com.example.seii_einzelnbeispiel;

import org.junit.*;
import org.mockito.Mock;

import static org.junit.Assert.*;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TCPConnectionTest {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    TCPConnection tcpConnection;

    @Mock
    private TextView responseTextView;

    @Before
    public void setup() throws IOException {
        int port = 1234;
        serverSocket = new ServerSocket(port);

        String hostname = "localhost";

        tcpConnection = new TCPConnection(hostname, port, responseTextView, "12345678");

        tcpConnection.start();

        clientSocket = serverSocket.accept();
    }

    @Test
    public void testTCPConnectionSuccessful() {
        assertTrue(clientSocket.isConnected());
    }

    @Test
    public void testTCPConnectionClosed() throws IOException {
        clientSocket.close();
        serverSocket.close();

        assertTrue(clientSocket.isClosed());
        assertTrue(serverSocket.isClosed());
    }

    @Test
    public void testTCPConnectionServerGotWrightMatriculationNumber() throws IOException {
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String matriculationNumber = inFromClient.readLine();

        assertEquals("12345678", matriculationNumber);
    }

    @Test
    public void testTCPConnectionServerSendsRespondToClient() {

    }
}