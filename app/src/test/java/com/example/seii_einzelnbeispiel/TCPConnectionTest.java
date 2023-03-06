package com.example.seii_einzelnbeispiel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

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

    @BeforeEach
    public void setup() throws IOException {
        int port = 1234;
        serverSocket = new ServerSocket(port);

        String hostname = "localhost";

        tcpConnection = new TCPConnection(hostname, port, "12345678");

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

    @AfterEach
    public void teardown() throws IOException {
        serverSocket.close();
    }
}