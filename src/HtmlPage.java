public class HtmlPage {
    public String getHtml() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"tr\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Barış Güler - Web Sunucusu</title>\n" +
                "<style>\n" +
                "body { background: #f1f5f9; font-family: Arial, sans-serif; }\n" +
                ".kart { background: white; max-width: 550px; margin: 80px auto; padding: 30px; border-radius: 12px; }\n" +
                "h1 { color: #1d4ed8; text-align: center; }\n" +
                "h2 { color: #334155; text-align: center; }\n" +
                "p { color: #475569; line-height: 1.6; }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body><div class=\"kart\">\n" +
                "<h1>Barış Güler</h1>\n" +
                "<h2>1250505801</h2>\n" +
                "<h3>Hakkımda</h3>\n" +
                "<p>Yazılım Mühendisliği 2. sınıf öğrencisiyim. " +
                "Java programlama dili ve yazılım geliştirme alanlarıyla ilgileniyorum.</p>\n" +
                "</div></body></html>";
    }
}
