public class C{
    public static void m(int a , int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
    public static void main (String[] args){
        int a = 1;
        int b = 2;
        m(a,b);
        System.out.println(a+","+b);
    }
}