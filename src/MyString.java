//
// This file is an example for the CMSC 131
// unit testing assignment (Project 2).
// It contains some intentional bugs and possibly some
// unintentional ones.
//
// MyString is a string class modeled on the old-style
// standard C string library. Note, not all the methods have
// the same signatures as the C ones.
// As in standard C, MyString represents a string
// as an array of characters terminated with a 0
// (not the character '0'; the actual numeric value 0).
// To store a string of length N characters in this system
// requires an array of length N+1.
//
// Two public static methods have been implemented to convert
// between String and MyString in each direction.
// These should be treated as untested code in need of testing,
// the same as all the other class methods.

public class MyString {
    public MyString( char[] str ) {
        m_string = str;
    }
    public MyString( int sz ) {
        m_string = allocateBuffer( sz );
    }
    public char[] get_string() { return m_string; }
    private char[] m_string;

    // Appends string "other" to this one
    public void strcat( MyString other  ) {
        char[] newString = allocateBuffer( strlen() + other.strlen() + 1 );
        copyToBuffer( m_string, newString, 0 );
        copyToBuffer( other.m_string, newString, strlen() );
        m_string = newString;
    }

    // Copies the contents of "other" to this string
    public void strcpy( MyString other ) {
        if (m_string.length < other.strlen()) {
            m_string = allocateBuffer( other.strlen()+1 );
        }
        copyToBuffer( other.m_string, m_string, 0 );
    }

    // Returns true if this string is the same as other,
    // false otherwise
    public boolean strcmp( MyString other ) {
        for (int i = 0; m_string[i] != 0; i++) {
            if (m_string[i] != other.m_string[i]) {
                return false;
            }
        }
        return true;
    }

    // Returns the number of characters in this string
    public int strlen() {
        int len = 0;
        while (m_string[len] != 0) len++;
        return len;
    }

    public void setChar( char ch, int idx ) {
        m_string[idx] = ch;
    }

    public char getChar( int idx ) {
        return m_string[idx];
    }

    private char[] allocateBuffer( int sz ) {
        char[] buffer = new char[sz];
        for (int i = 0; i < buffer.length; i++) { buffer[i] = 0; }
        return buffer;
    }

    // copy the full length of src to dst,
    // starting at index startAt in dst.
    private void copyToBuffer( char[] src, char[] dst, int startAt )
    {
        int srcIdx = 0, dstIdx = startAt;
        while (src[srcIdx] != 0) {
            dst[dstIdx++] = src[srcIdx++];
        }
    }

    public static MyString convertToMyString( String src ) {
        char[] buf = new char[ src.length() + 1];
        for (int i = 0; i < src.length(); i++) {
            buf[i] = src.charAt(i);
        }
        buf[src.length()] = (char)0;
        return new MyString( buf );
    }

    public static String convertToString( MyString mystr ) {
        char[] buf = new char[mystr.strlen()];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = mystr.getChar( i );
        }
        return new String( buf );
    }
}
