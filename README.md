# Java Socket Web Server

Bu proje, yalnızca Java standart kütüphaneleriyle geliştirilmiş basit bir HTTP web sunucusudur. Sunucu 1989 portunda çalışır ve tarayıcıda öğrenci bilgileri ile kısa bir biyografi gösterir.

## Proje bilgileri

- **Ad Soyad:** Barış Güler
- **Öğrenci No:** 1250505801
- **Ders konusu:** Java Socket Programlama

## Gereksinimler

- JDK 8 veya üzeri
- Üçüncü parti kütüphane gerekmez.

## Çalıştırma

Proje klasöründe terminal açın:

```bash
javac -encoding UTF-8 -d out src/Main.java src/WebServer.java src/HtmlPage.java
java -cp out Main
```

Windows'ta `out` klasörü yoksa önce `mkdir out` komutunu çalıştırın. Ardından tarayıcıda **http://localhost:1989** adresini açın. Sunucuyu durdurmak için terminalde **Ctrl+C** kullanın.

## Dosyalar

- `Main.java`: Sunucuyu başlatır.
- `WebServer.java`: TCP bağlantısını kabul eder, HTTP isteğini okur ve yanıtı gönderir.
- `HtmlPage.java`: HTML sayfasını üretir.

## Çalışma prensibi

`ServerSocket` 1989 portunu dinler. Tarayıcı bağlandığında `accept()` bir `Socket` döndürür. Program HTTP istek satırını okur, ardından `200 OK` başlığı ve UTF-8 HTML içeriği gönderir. `Content-Length` içerik bayt sayısına göre hesaplanır. Bu örnek eğitim amaçlıdır; gelişmiş bir HTTP sunucusu değildir.

## SOLID ile ilişki

- **S:** Sunucu iletişimi ve HTML oluşturma farklı sınıflardadır.
- **O:** HTML içeriği `HtmlPage` üzerinden değiştirilebilir; daha kapsamlı genişletme için arayüz eklenebilir.
- **L:** Projede kalıtım bulunmadığından doğrudan gösterilmez.
- **I:** Arayüz bulunmadığından doğrudan gösterilmez.
- **D:** `HtmlPage` nesnesi `WebServer` kurucusuna dışarıdan verilir; ancak soyutlama kullanılmadığı için ilke tam uygulanmış değildir.

## Sınırlamalar

Sunucu tek iş parçacığında çalışır, gelen her isteğe aynı HTML sayfasını döndürür ve temel GET kullanımını göstermek için hazırlanmıştır. İnternete açık üretim sunucusu olarak kullanılmamalıdır.
