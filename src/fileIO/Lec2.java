package fileIO;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/*
    The main intention of FileInputStream is to carry data from a particular source file to java application.
        FileInputStream fis = new FileInputStream("fileName.extension");

    Here the JVM will check the fileName and its location and will try to locate the file,
        whether the file exists or not. If file is not found then the JVM will raise FileNotFound Exception.
        If the file exists then the JVM will establish a file input stream to collect the data from the file.

    The data comes in the form of bytes from the File and the bytes are accepted into a byte array, after that
      byte array is converted into strings of data.

    To get the data size of the file we use the function,
       int size = fis.available();
       byte[] b = new byte[size];
       fis.read(b);

    To convert the byte array data into the strings we use just the String Constructor.
        String data = new String(b);
        System.out.println(data);
        fis.close();


 */
public class Lec2 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("E:\\Java Projects\\AdvJava\\src\\fileIO\\newFile.txt");
        int size = fis.available();
        byte[] bArray = new byte[size];
        String data = new String(bArray, StandardCharsets.UTF_16);
        System.out.println(data);
        fis.close();
    }
}
