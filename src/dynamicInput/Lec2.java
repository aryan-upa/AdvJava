package dynamicInput;

import java.util.Scanner;

/*
    Scanner Class is in java.util package.
        java.util.Scanner

    It is able to read primitive data directly through Scanner as dynamic input. This is a drawback of Buffered Reader
        etc. system.

    Difference b/w next() and nextLine()?
    Ans:
        next() -> reads only the next word!
        nextLine() -> reads the next complete line till the CRLF or LF.

    There are several other functions which take input data in the primitive form such as nextChar(),
        nextInt(), nextLong(), etc.

 */
public class Lec2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Data 1 : ");
        String data1 = sc.next();
        System.out.println(data1);
    }
}
