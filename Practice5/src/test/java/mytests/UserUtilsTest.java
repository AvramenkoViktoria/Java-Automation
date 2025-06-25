package mytests;

import org.java.UserUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

@Tag("user")
public class UserUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 25, 120})
    void testAgeIsValid(int age) {
        assumeTrue(age >= 0);
        assertTrue(UserUtils.ageIsValid(age));
    }

    @Test
    void testCanLaunchGamesWindows() {
        assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));
        assertTrue(UserUtils.canLaunchGames("Windows"));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 21, Pisces",
            "7, 23, Cancer",
            "12, 31, Sagittarius"
    })
    void testGetZodiacSign(int month, int day, String expected) {
        assumeTrue(month >= 1 && month <= 12);
        assertEquals(expected, UserUtils.getZodiacSign(month));
    }
}
