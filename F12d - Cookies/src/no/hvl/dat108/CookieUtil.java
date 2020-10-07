package no.hvl.dat108;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private final static Charset CHARSET = StandardCharsets.UTF_8;
    private final static int MAX_AGE_IN_SECONDS = 30;

    public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
        Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, CHARSET));
        cookie.setMaxAge(MAX_AGE_IN_SECONDS);
        response.addCookie(cookie);
    }

    public static String getCookieFromRequest(HttpServletRequest request, String navn) {
        if (request.getCookies() == null) {
            return null;
        }
        return Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals(navn))
                .findAny()
                .map(c -> URLDecoder.decode(c.getValue(), CHARSET))
                .orElse(null);
    }
}
