package ExceptionHandling;

/*
    Q: What is the difference between Error and Exception?
    Ans:
        Errors :
            Error is a problem in Java application, it will not allow application to execute any further.

            There are two types of errors:
            1. Compilation Error : If any error is identified at compilation time then that error is called as
                compilation error.
                There are three types of errors.
                a. Lexical Error : Mistakes in token or in keywords...
                    int i = 10;
                    nit j = 20;
                    ~~~ -> Invalid, Lexical error

                b. Syntax Error : Mistakes in Syntax...
                    int i = 10;
                    i = 10 int;
                    ~~~~~~~~~~~ -> invalid syntax

                c. Semantic Error : Performing operations with incompatible types...
                    int c = 9;
                    char d = 'q';
                    String q = d + c;
                    ~~~~~~~~~~~~~~~~~ -> Operation on Invalid types.

                Apart from these there are some errors which are unique to Java...
                    * Possible loss of precision
                    * Unreachable Statement
                    * variable i might not have been initialized

            2. Runtime Error : If any error is identified at runtime then those errors are known as Runtime errors.

                Ex: JVMInternalError
                Ex: Unavailability of IO Components
                Ex: Insufficient Main Memory : StackOverFlowError

        Exception:
            It is a problem occurred at runtime, for which, we are able to provide solutions programmatically.

            Ex: ArithmeticException
            Ex: FileNotFoundException
            Ex: NullPointerException
            Ex: ClassCastException

    There are two types of terminations in Java Applications.
        1. Smooth Termination
        2. Abnormal Termination

    ---- Exception Handling Mechanism ----

    Types of Exceptions:
    1. Predefined Exceptions
        These exceptions are defined by Java Programming language and provided along Java Software.

        There are two types of Predefined Exceptions :
        a. Checked Exceptions
            These are exceptions recognized by compiler at compilation time, but not occurred at compilation time. When
            we compile our program the compiler will predict some exceptions by monitoring our code that exceptions are
            called as Checked Exceptions.

            Checked Exceptions are of two types:
            i)  Pure Checked Exception
                A Checked Exception which has all of its subclasses as Checked Exception then that Parent Class is
                called a Pure Checked Exception.
                Ex: IOException

            ii) Partially Checked Exception
                If any Checked Exception has at least one subclass as unchecked exception then that parent checked
                exception is called as partially checked exception.
                Ex: Exception, Throwable

        b. Unchecked Exceptions
            These are the exceptions which are recognized by JVM at runtime, not at compilation time and not by compiler

    2. User-Defined Exceptions

--- proceeded in Lec2 ---
 */
public class Lec1 {
    public static void main(String[] args) {

    }
}
