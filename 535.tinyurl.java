/**
 *     Note: This is a companion problem to the System Design problem: Design TinyURL.

TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
*/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Codec {
    final Map<String, String> rev = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        try {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(longUrl.getBytes(StandardCharsets.UTF_8));
        final String shortUrl = "http://tinyurl.com/" + Base64.getEncoder().encodeToString(hash);
        rev.put(shortUrl, longUrl);
        return shortUrl;
        } catch (NoSuchAlgorithmException e) {
            //
        }
        return null;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return rev.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
