package JOL;

import org.openjdk.jol.info.ClassLayout;

public class Demo {
    /*
        JOL : Java Object Layout, is a build tool that helps us in identifying the system properties, size of classes
        and objects in them. It tells the configuration of how a class is build and how much space is used by what
        component of the class.

        Temp Class Definition :
            class Temp {
                private boolean variable;
                private int var2;
                private long var3;
                private int[] nums;

                Temp() {
                    nums = new int[10];
                    var2 = 15;
                    variable = true;
                    var3 = 100L;
                }

                public int method2() {
                    return var2;
                }
            }

        ClassLayout.parseClass(Temp.class).toPrintable() prints the data of the file in memory spaces:
        OFF  SZ      TYPE DESCRIPTION               VALUE
          0   8           (object header: mark)     N/A   -> The mark word describes the object header.
                                                             The HotSpot JVM uses this word to store identity hashcode,
                                                             biased locking pattern, locking information, and GC
                                                             metadata.

          8   4           (object header: class)    N/A   -> the klass word encapsulates the language-level class
                                                             information such as class name, its modifiers, superclass
                                                             info, and so on.

         12   4       int Temp.var2                 N/A   -> Simple class variable defined in the class.
         16   8      long Temp.var3                 N/A   -> Simple class variable defined in the class.
         24   1   boolean Temp.variable             N/A   -> Simple class variable defined in the class.

         25   3           (alignment/padding gap)         -> The Padding is added to make this size a multiple of
                                                             8 bytes the JVM has added 3 bytes to the class size.

         28   4     int[] Temp.nums                 N/A   -> Reference type variable for int[] head.

        Instance size: 32 bytes
        Space losses: 3 bytes internal + 0 bytes external = 3 bytes total

         Important :
             Also, there is no value for the object header and the state because we're parsing a class layout, not an
             instance layout.

         Internally it uses the instrumentation class for this calculation.

     */

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseClass(Temp.class).toPrintable());
    }
}
