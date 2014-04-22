// CookieJar attempts to demonstrate that Operator Precedence is not the same  
// thing as Order of Evaluation. Specifically, we will see that placing an expression  
// in parentheses does not necessarily cause it to be evaluated first.  
// We will also see that using a ++ in an expression does not necessarily cause it to  
// be evaluated first.  
// In these examples the order of evaluation is being determined not by operator precedence,   
// but by the rule described in the Java Language Specification 15.7 Evaluation Order which states:  
// "The Java programming language guarantees that the operands of operators appear to be  
// evaluated in a specific evaluation order, namely, from left to right."  
// And the Java Language Specification 15.7.1 Evaluate Left-Hand Operand First:  
// "The left-hand operand of a binary operator appears to be fully evaluated before any part  
// of the right-hand operand is evaluated."  
  
public class CookieJar {  
      
    static int numCookiesInJar = 14;  
      
    public static void main(String[] args) {  
        System.out.println("Evaluating this statement: ");  
        String statement = "int sum = askForCookie(5) + (askForCookie(4) + askForCookie(3) + (askForCookie(2) + (askForCookie(1))));";  
        System.out.println(statement);  
        System.out.println();  
        int sum = askForCookie(5) + (askForCookie(4) + askForCookie(3) + (askForCookie(2) + (askForCookie(1))));  
          
        System.out.println("**********************");  
        System.out.println("Contrast with left-to-right operands of 1,2,3,4,5 as opposed to 5,4,3,2,1 (notice no \"end of the world!\")");  
        statement = "sum = askForCookie(1) + (askForCookie(2) + askForCookie(3) + (askForCookie(4) + (askForCookie(5))));";  
        System.out.println("Evaluating this statement: ");  
        System.out.println(statement);  
        System.out.println();  
        numCookiesInJar = 14; // reset numCookies in jar for second demonstration  
        sum = askForCookie(1) + (askForCookie(2) + askForCookie(3) + (askForCookie(4) + (askForCookie(5))));  
          
        System.out.println("**********************");  
        System.out.println("And to make it clearer with fewer parens:");  
        System.out.println("In the interest of fairness, we will attempt to use parens to fulfill the request for the smallest number of cookies first.");  
        statement = "sum = askForCookie(5) + askForCookie(4) + askForCookie(3) + askForCookie(2) + (received = askForCookie(1))";  
        System.out.println("Evaluating this statement: ");  
        System.out.println(statement);  
        System.out.println();  
        numCookiesInJar = 14; // reset numCookies in jar for third demonstration  
        int received;  
        sum = askForCookie(5) + askForCookie(4) + askForCookie(3) + askForCookie(2) + (received = askForCookie(1));  
        System.out.printf("Value of received: %d\n", received);  
        System.out.println("Even though the assignment 'received = askForCookie(1)' was inside parens, it was evaluated last.");  
        System.out.println("The expression '(received = askForCookie(1))' was the right operand of the last binary operator so it was evaluated last.");  
        System.out.println("This demonstrates a non-trivial example (at least for the kid who got no cookie),");  
        System.out.println("of confusing operator precedence with order of evaluation.");  
        System.out.println("Operator precedence is not the same thing as order of evaluation");  
        System.out.println();  
          
        System.out.println("**********************");  
        System.out.println("One last example. We will try to force the assignment 'received = askForCookie(1)' to be evaluated first by using");  
        System.out.println("another high precedence operator, ++. Notice this has no effect whatsoever on order of evaluation.");  
        System.out.println("In the interest of fairness, and since he got no cookie at all last time, we will attempt to allow child who requested the");  
        System.out.println("fewest number of cookies to steal an extra cookie from the cookie jar this time with the ++ operator.");  
        statement = "sum = askForCookie(5) + askForCookie(4) + askForCookie(3) + askForCookie(2) + (received = askForCookie(++one))";  
        System.out.println("Evaluating this statement: ");  
        System.out.println(statement);  
        System.out.println();  
        numCookiesInJar = 14; // reset numCookies in jar for third demonstration  
        int one = 1;  
        sum = askForCookie(5) + askForCookie(4) + askForCookie(3) + askForCookie(2) + (received = askForCookie(++one));  
        System.out.printf("Value of received: %d\n", received);  
        System.out.println("Even though the assignment 'received = askForCookie(++one)' was inside parens and included ++ operator, it was evaluated last.");  
        System.out.println("The expression '(received = askForCookie(++one))' was the right operand of the last binary operator so it was evaluated last.");  
        System.out.println("Whether by being polite and asking for only 1 cookie, or by trying to steal a cookie from the cookie jar with ++,");  
        System.out.println("the child who was on the right of the binary operator got no cookie and it was the end of the world.");  
        System.out.println("This demonstrates a non-trivial example (at least for the kid who got no cookie),");  
        System.out.println("of confusing operator precedence with order of evaluation.");  
        System.out.println("Operator precedence is not the same thing as order of evaluation");  
    }  
      
    // This method is used to request a number of cookies.  
    // numRequested: the number of cookies requested  
    // returns: numRequested if <= cookies in jar; otherwise returns available cookies  
    public static int askForCookie(int numRequested)  
    {  
        int cookies;  
          
        System.out.printf("There are %d cookies in the jar.\n", numCookiesInJar);  
        System.out.printf("Someone requested %d cookies.\n", numRequested);  
          
        if (numRequested <= numCookiesInJar) // enough cookies in the jar, give num requested  
        {  
            cookies = numRequested;  
            numCookiesInJar = numCookiesInJar - numRequested;  
            System.out.printf("There's enough cookies, someone gets %d.\n", cookies);  
            System.out.printf("Now there's %d cookies in the jar.\n", numCookiesInJar);  
            System.out.println();  
        }  
        else // not enough cookies, give what's left in jar  
        {  
            cookies = numCookiesInJar;  
            numCookiesInJar = 0;  
            System.out.printf("There's not enough cookies in the jar, someone only gets %d.\n", cookies);  
            if (cookies >= 1) // someone gets at least 1 cookie  
            {  
                System.out.println("Oh, well. At least I got something.\n");  
                System.out.println();  
            }  
            else // someone gets no cookie at all  
            {  
                System.out.println("I get no cookie! It's the end of the world!");  
                System.out.println();  
            }  
        }  
          
        return cookies;  
    }  
  
}    