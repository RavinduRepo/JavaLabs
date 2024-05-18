import static org.junit.Assert.*;

import org.junit.Test; 

// This class contains test cases for the StringUtils class
public class StringUtilsTest {

    // Test case for reverse method with Strinh inputs
    @Test
    public void reverseStrings (){
        assertEquals("HelloWorld", StringUtils.reverse("dlroWolleH"));
        assertEquals("abcdefgh ijklmno", StringUtils.reverse("onmlkji hgfedcba"));
    }

    // Test case for reverse method with null input
    @Test
    public void reverseNull (){
        assertThrows(IllegalArgumentException.class, () -> StringUtils.reverse(null));
    }

    // Test case for reverse method with empty string input
    @Test
    public void reverseEmpty (){
        assertThrows(IllegalArgumentException.class, () -> StringUtils.reverse(""));
    }

    // Test case for isPalindrome method with palindrome
    @Test
    public void isPalindromeTrue (){
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("level"));
    }

    // Test case for isPalindrome method with non-palindrome
    @Test
    public void isPalindromeFalse (){
        assertFalse(StringUtils.isPalindrome("not palindrome"));
        assertFalse(StringUtils.isPalindrome("testing"));

    }

    // Test case for isPalindrome method with null input
    @Test
    public void isPalindromeNull (){
        assertThrows(IllegalArgumentException.class, () -> StringUtils.isPalindrome(null));
    }

    // Test case for isPalindrome method with empty string input
    @Test
    public void isPalindromeEmpty (){
        assertThrows(IllegalArgumentException.class, () -> StringUtils.isPalindrome(""));
    }

}
