package Miscelleneous;

import java.util.Scanner;

public class Constructors {
    /*
        Constructors are special member functions of a clas which are used to initialize an object.
            Initialization -> giving a field a data for the first time, while creating an object.
            Modification -> giving a field a data after the creation of object.
        Putting the values into the data members of an object while creating it, this process is called Object
            initialization.

        If we want to perform any task only once in a lifetime of an object, we put these tasks into the constructor.
            such as: providing certain common resources to all the objects as they initialize like creating a DB
            connection or, creating a GUI component for them.

        In Java, constructors are by default static: because they are called by the Class name. For anything to be
            instanced in nature, it has to be associated with an object, but Constructors are created while creating an
            object, so they can not be instanced.

        3 rules which are related to the constructors:
            1. Naming: A Constructor has to be named as same as the Class name.
                Why:
                    While creating the Java, the developers had an issue. It was with the new function.
                    The 'new' keyword allocates the memory required for an object to create. The issue was to supply the
                    new function with the class name. To solve this they had to come up with something that could only
                    be used once while creating an object as we can not call new again on object.

                    |======================================== On how 'new' works =======================================|
                    |   Whenever we call the new function, the JVM goes and loads the class by the name, then it        |
                    |   calculates all the memory it needs by going through all the fields. It then creates a buffer in |
                    |   the memory of that much space and creates a reference ID for that. It now sends this reference  |
                    |   to the Constructor which then creates all the fields inside the allocated space and initiates   |
                    |   them, then it returns the same reference ID to the reference variable (if there is one).        |
                    |===================================================================================================|

                    As a solution to this they fixed that the name of the constructor should be same as of the Class.
            2. No Return-type: A Constructor can not have a return type, not even void.
                Why:
                    The implicit working of the constructor does not allow it to have a return type as being of fixed
                    nature the constructor returns the reference ID of the object. It is then of the type as of Class
                    so without writing it goes as
                        class Temp {
                            // Constructor
                            Temp Temp() { // But the part is omitted as:
                                return this;
                            }
                        }
                    Java does not want to programmer to mess up with the return type of the constructor. and it also
                    does not allow us to return anything except an empty return.
                        because then Java completes it to "return this;" for us.
                        this here refers to the current calling object.
            3. No Explicit-Calling: You can not call a constructor explicitly.
                Why:
                    Explicitly calling the constructor would lead the program to be in a wrong state as on what object
                    it would be called, without new operator it does not have a reference to work with, or if we give
                    it a reference then all the fields have been already initialized. If any field is re-initialized to
                    null then it will break the program at several points.

        No Class can exist without a constructor because without it, any object created would be just a memory heap with
         no fields in it what-so-ever.

        Constructors can be overloaded.

        Some points on 'this':
            1. this always points to a current object.
            2. this is a reference variable which holds the reference id of current object.
            3. Whenever class level variable and a local variable both are having same name then this concept is known
                as data shadowing.
            4. Priority always goes to the local variable.
            5. You can not access instance data members of a class without using 'referenceID + .' .
            6. this keyword can not be used in any static function.
            7. If you are passing this as an argument in any instance function of a class then it must be the first
                argument.


        If you want to initialize data member of each object with same values then always use constructor.

        If you initialize the instance data member at class level, and you have not put any constructor in your class
            then initialization code will be inserted in the default constructor of your class by the compiler.

        If you initialize the instance data member at class level you have many constructors in your class then in
            initialization code will be inserted into all of them.

        In Java, you can also call the method at class level to initialize the data members of that class but at the
            time of compilation the compiler will insert that code into the constructor.

        In Java, you can also make the methods by the same name as of class, in-fact this code also works:
            Code:
                class Temp {
                    Temp() {
                        System.out.println("constructor"); }

                    void Temp() {
                        System.out.println("method"); }

                    public static void main (String...args) {
                        new Temp().Temp();
                        Temp();
                        new Temp();
                    }
                }

            Output:
                constructor
                method

                method

                constructor

        Copy Constructor:
            The copy constructor is used to create an exact replica of an object. Often times when an object is sent to
            a different method in different class or package for some operation, then to prevent the object. Rather than
             the real object, its copy is sent to the work.
            It copies all the data in fields from one object to another. It is sort of same as a Parameterized
                constructor but here the parameter is the same class' object.

            class Temp {
                int x;
                int y;

                Temp(int x, int y) {
                    this.x = x;
                    this.y = y; }

                Temp(Temp copyFrom) {
                    this.x = copyFrom.x;
                    this.y = copyFrom.y; }

                void show() {
                    System.out.println(x + " " + y); }

                public static void main(String[] args) {
                    Temp obj = new Temp(1,2);
                    Temp nO = new Temp(obj);
                    obj.show(); // 1 2
                    nO.show(); // 1 2
                }
            }


                                    Java does not support call by reference.


        Constructors can be chained, this phenomenon is called constructor chaining. It is the [process of calling one
            constructor from another constructor with respect to the current object.

            There are two ways of chaining a constructor
            a. Using super();

            b. Using this();
                It is a special method of this. Whenever we are achieving chaining using this(), it must be the first
                    line in the constructor. Whenever we are achieving chaining then there must be at-least one
                    constructor without this() as its first line. constructor chaining can be achieved in any order.
                    If u want to provide multiple resources to each object of your own class like database connection,
                    or network connection, creating GUI rather than doing all of it in one constructor, we do this in
                    a chain of constructors.

                Code:
                    class Temp {
                        int x, y;
                        Temp () {
                            this(new Scanner(System.in).nextInt());
                            System.out.println("out of constructor 1.");
                        }

                        Temp(int x) {
                            this(x, new Scanner(System.in).nextInt());
                            System.out.println("out of constructor 2.");
                        }

                        Temp(int x, int y) {
                            System.out.println(x + y);
                            System.out.println("out of constructor 3.");
                        }

                        public static void main(String[] args) {
                            new Temp();
                        }
                    }

                Output:
                    4
                    5
                    9
                    out of constructor 3.
                    out of constructor 2.
                    out of constructor 1.

     */

}

















