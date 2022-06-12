package fileIO;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/*
    FileOutputStream:
        It can be used to transfer data from java application to a particular file.

        FileOutputStream fos = new FileOutputStream("abc.txt");

    "abc.txt" -> the file name
    First JVM will check whether the file exits or not, if it exits the fos will be created and
        connected to the file, Otherwise if the file doesn't exist, the JVM will create the file
        with the same name and the stream will be set to that file.

    In the FileOutputStream the data is transferred in the form of bytes.
    The file will be created in the default package, src, or at the specified address.

    By default, if we re-run the program the data is overwritten in the file, to append the data in
        the file we need to start the fos as
        FileStreamOutput fos = new FileStreamOutput("fileName.extension", true);
        here -> the "true" sets the append flag to true.

 */
public class Lec1 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos =
                new FileOutputStream("E:\\Java Projects\\AdvJava\\src\\fileIO\\newFile.txt", true);
        String data = "Hello World, This is Aryan Upadhyay! \n";
        byte[] b = data.getBytes(StandardCharsets.UTF_16);
        fos.write(b);
        fos.close();
    }
}
