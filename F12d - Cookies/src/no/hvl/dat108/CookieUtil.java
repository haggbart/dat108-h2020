package no.hvl.dat108;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private final static String CHARACTER_ENCODING = "UTF-8";
    private final static int MAX_AGE_IN_SECONDS = 30;

    public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
        try {
            Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, CHARACTER_ENCODING));
            cookie.setMaxAge(MAX_AGE_IN_SECONDS);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            // Should never happen
            e.printStackTrace();
        }
    }

    public static String getCookieFromRequest(HttpServletRequest request, String navn) {

        if (request.getCookies() == null) {
            return null;
        }
        Optional<String> verdi = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals(navn))
                .map(Cookie::getValue)
                .findFirst();
        try {
            return verdi.isPresent() ? URLDecoder.decode(verdi.get(), CHARACTER_ENCODING) : null;
        } catch (UnsupportedEncodingException e) {
            // Should never happen
            e.printStackTrace();
        }
        return null;
    }
}
