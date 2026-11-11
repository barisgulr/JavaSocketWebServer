import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebServer {
    private final int port;
    private final HtmlPage page;

    public WebServer(int port, HtmlPage page) {
        this.port = port;
        this.page = page;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Sunucu çalışıyor: http://localhost:" + port);
            while (true) {
                try (Socket client = server.accept()) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(client.getInputStream(), StandardCharsets.UTF_8));
                    String request = reader.readLine();
                    if (request == null) continue;
                    System.out.println("İstek: " + request);

                    String html = page.getHtml();
                    byte[] body = html.getBytes(StandardCharsets.UTF_8);
                    String headers = "HTTP/1.1 200 OK\r\n" +
                            "Content-Type: text/html; charset=UTF-8\r\n" +
                            "Content-Length: " + body.length + "\r\n" +
                            "Connection: close\r\n\r\n";
                    OutputStream output = client.getOutputStream();
                    output.write(headers.getBytes(StandardCharsets.US_ASCII));
                    output.write(body);
                    output.flush();
                } catch (Exception e) {
                    System.out.println("İstemci hatası: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Sunucu hatası: " + e.getMessage());
        }
    }
}
