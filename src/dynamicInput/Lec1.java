package dynamicInput;

import java.io.*;

/*
    If we provide any data at the time of executing program then that data is called as Dynamic Input.

    In Java.io package

    Stream: A channel or medium which allows data in continuous flow, from Input device to JavaProgram or
    from Java Program to Output Device. [both hardware/ network].
    Two Types:
        1. Byte Oriented Stream: Able to allow the data to transport in the form of bytes.
            2 types:
                InputStream: Byte Stream -> Input devices to Java Program
                OutputStream: Byte Stream -> Java Program to Output devices.
        2. Character Oriented Stream: Allows the data flow in form of character in continuous flow, in both direction.
            2 types:
                ReaderStream: Character Stream -> Input Devices to Java Program.
                WriterStream: Character Stream -> Java Program to Output Devices.

    Classes which end with stream are ByteOriented and Classes which end with reader/writer are CharacterOriented.

    "System" is class name & "in" is a variable.
        "in" is a static variable, and "in" is referring a predefined InputStreamObject which is connected with
         Command Prompt.

    We use System.in, "in" is a static variable in "System" Class referring to InputStream type object, so when we
    enter the data in the command prompt the data is transferred continuously in the form of binary stream.

    To convert that binary stream data in characters we use InputStreamReader class object, it converts each byte of
    data into characters.

    Now these characters are placed in the buffered reader buffer where they are converted into Strings, from buffered
    reader we can read the data using read() or readLine() method.

    we use read() and readLine() function to read the strings stored in the buffered reader.

    read() -> reads a single character and returns the ASCII value.
    readLine() -> reads the complete line from the Buffer in which end is indicated by CRLF or LF or CR.

 */

public class Lec1 {

    /*
        We add the "throws Exception" after the method signature so that even if any function inside
        the main method throws an exception, the JVM should handle it itself.
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(addition(br));

        /*
            System.out.println("Enter text data : ");
            String data = br.readLine();
            System.out.println("Enter the same text data again : ");
            int val = br.read();
            System.out.println("readLine() : " + data);
            System.out.println("read() : " + val + ", casted in char : " + (char) val);
         */
    }

    public static int addition(BufferedReader br) throws Exception {

        System.out.print("Enter first number : ");
        String val1 = br.readLine();

        System.out.print("Enter second number : ");
        String val2 = br.readLine();

        return Integer.parseInt(val1) + Integer.parseInt(val2);
    }
}
