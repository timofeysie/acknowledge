class C {void method(int i){System.out.println("C:i "+i);}}
interface I {void method(int i);}
interface J {}
abstract class A extends C implements I {public void method(int i){System.out.println("A:i "+i);}}
public class P2 extends A implements J {public void method(int i){System.out.println("P2:i "+i);}
public static void main(String[] args) {new P2().method(1);}}