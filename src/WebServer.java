import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.net.Socket;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.Arrays;




public class WebServer {
    private ServerSocket server;
    public void acceptConnection(int port) throws IOException  {
        ServerSocket server = new ServerSocket(port);
        Socket socket = server.accept();
        handleHTTPRequest(socket);
    }


    private static void handleHTTPRequest(Socket clientSocket) throws IOException {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String requestLine = in.readLine();
            if (requestLine != null) {

                String[] requestParts = requestLine.split(" ");
                String method = requestParts[0];
                String path = requestParts[1];

                System.out.println("Received request: " + method + " " + path);


            }

            while (!requestLine.isBlank()) {
                requestLine = in.readLine();
                if (requestLine.equals("Server: True")) {
                    System.out.println("server");
                    break;
                }

                if (requestLine.equals("Server: False")) {
                    System.out.println("client");
                    break;
                }
            }

            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/html\r\n"+
                    "\r\n" +
                    "FTP opening: " +
                    requestLine;


            out.println(response);

        } finally {
            clientSocket.close();
        }


    }
}
