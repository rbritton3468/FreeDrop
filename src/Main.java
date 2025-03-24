public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");
        WebServer webServer = new  WebServer();
        webServer.acceptConnection(4444);

    }
}