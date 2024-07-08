import java.util.HashMap;

public class TinyURL {
    HashMap<String, String> shortToLong = new HashMap<>();
    HashMap<String, String> longToShort = new HashMap<>();
    Long counter = 123456789L;

    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String shortUrl = "http://tinyurl.com/";
        long num = counter;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(characters.charAt((int) (num % 62)));
            num /= 62;
        }
        shortUrl += sb.reverse().toString();
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);
        counter++;
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }

    public static void main(String[] args) {
        TinyURL tinyURL = new TinyURL();
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = tinyURL.encode(longUrl);
        System.out.println("Short URL: " + shortUrl);
        System.out.println("Long URL: " + tinyURL.decode(shortUrl));
    }
}