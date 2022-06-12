package dynamicInput;

import java.io.Console;
import java.util.Arrays;

/*
    The third method for having a dynamic input is by using Console.

    Drawbacks with BufferedReader and Scanner:
        1. No security for the dynamic input like password data, PIN Numbers, etc..
        2. For every single dynamic input we have to use at least 2 statements.
            One to display the request message and Another to read the data.

    To overcome these problems we have to use java.io.console class.

    The drawback of using console class is that it can only input data in the
        form of String, and any other data has to be cast in another classes using Wrapper
        classes.
 */
public class Lec3 {
    public static void main(String[] args) {
        /*
            To display a req message and to read dynamic input in the form of String:
                public String readLine(String req_message)

            To display req message and to read Password data as dynamic input in the
                form of char[]:
                public char[] readPassword(String req_Message)
         */
        Console con = System.console();
        String uName = con.readLine("Enter the username : ");
        char[] pass = con.readPassword("Enter the Password : ");

        System.out.println("Your Username is : " + uName);
        System.out.println("Your Password is : " + Arrays.toString(pass));
        /*
            Unfortunately the IntelliJ IDEA does not support working on console, therefore to
            test this function you need to execute this class from the file explorer using the
            Command Prompt.
         */
    }
}
