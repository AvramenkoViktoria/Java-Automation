package mytests;

import org.java.StringUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@Tag("string")
public class StringUtilsTest {

    @Test
    void testReverseBasic() {
        assumeTrue(System.getenv("ENV") == null);
        assertEquals("cba", StringUtils.reverse("abc"));
    }

    @ParameterizedTest
    @CsvSource({"madam,true", "racecar,true", "hello,false"})
    void testIsPalindrome(String input, boolean expected) {
        assumeTrue(input.length() <= 10);
        assertEquals(expected, StringUtils.isPalindrome(input));
    }

    @Test
    void testConcatenate() {
        assumingThat(System.getProperty("user.name") != null,
                () -> assertEquals("hello world", StringUtils.concatenate("hello ", "world")));
    }
}
