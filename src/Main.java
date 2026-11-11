public class Main {
    public static void main(String[] args) {
        WebServer server = new WebServer(1989, new HtmlPage());
        server.start();
    }
}
