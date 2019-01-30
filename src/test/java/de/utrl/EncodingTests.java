package de.utrl;

import com.google.common.net.*;
import org.junit.jupiter.api.*;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncodingTests {

    @Test
    @DisplayName("MIME type of data encoded this way is application/x-www-form-urlencoded")
    void formDataEncodingTest() throws UnsupportedEncodingException {
        String encoded = java.net.URLEncoder.encode("hello world", "UTF-8");
        // + means a space only in application/x-www-form-urlencoded content, such as the query part of a URL
        // see https://stackoverflow.com/questions/2678551/when-to-encode-space-to-plus-or-20
        assertEquals("hello+world", encoded);
    }

    @Test
    void guavaTestEncoding() {
        String encodedString = UrlEscapers.urlFragmentEscaper().escape("hello world");
        assertEquals("hello%20world", encodedString);
    }


    @Test
    void useUriUtils() throws UnsupportedEncodingException {
        String encodedString = UriUtils.encodeFragment("HELLO WORLD", "UTF-8");
        assertEquals("HELLO%20WORLD", encodedString);
        String doubleEncoded = UriUtils.encodeFragment(encodedString, "UTF-8");
        assertEquals("HELLO%2520WORLD", doubleEncoded);
    }
}