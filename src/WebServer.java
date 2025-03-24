import java.io.*;
import java.net.ServerSocket;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;
import java.net.Socket;
import java.net.http.HttpHeaders;
import java.util.Arrays;


public class WebServer {
    private ServerSocket server;
    public void acceptConnection(int port) throws IOException  {
        server = new ServerSocket(port);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        OutputStream outputStream =  socket.getOutputStream();
        outputStream.write("HelloWold".getBytes());



        System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
        socket.close();
        server.close();
    }



}
