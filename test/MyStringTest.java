import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringTest {

    @Test
    void strcat() {
        MyString s1 = MyString.convertToMyString("Hello");
        MyString s2 = MyString.convertToMyString("World");
        s1.strcat(s2);
        assertEquals("HelloWorld",MyString.convertToString(s1));
    }

    @Test
    void strcpy() {
        MyString s1 = MyString.convertToMyString("Hello");
        MyString s2 = new MyString(new char[]{});
        s2.strcpy(s1);
        assertEquals("Hello",MyString.convertToString(s2));
    }

    @Test
    void strcmp() {
        MyString s1 = MyString.convertToMyString("Hello");
        MyString s2 = MyString.convertToMyString("Hello");
        assertTrue(s1.strcmp(s2));
    }

    @Test
    void strlen() {
        MyString s1 = MyString.convertToMyString("Hello");
        assertEquals(5,s1.strlen());
    }

    @Test
    void setChar() {
        MyString s1 = MyString.convertToMyString("Hello");
        s1.setChar('a',1);
        assertEquals("Hallo",MyString.convertToString(s1));
    }

    @Test
    void getChar() {
        MyString s1 = MyString.convertToMyString("Hello");
        assertEquals('l',s1.getChar(2));
    }
}