package de.utrl;

import com.google.common.net.UrlEscapers;
import org.junit.jupiter.api.*;
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
}