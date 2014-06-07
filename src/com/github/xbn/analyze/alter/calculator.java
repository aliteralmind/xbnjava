import java.util.Scanner;
public class calculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String x,y;


        System.out.println("Enter first fraction in a / b form: ");
        x = input.nextLine();

        System.out.println("Enter operation: ");
        char z = input.next().charAt(0);

        System.out.println("Enter second fraction in c / d form: ");
        y = input.nextLine();

        String aString = x.substring(0,1);
        String bString = x.substring(4,5);
        String cString = x.substring(0,1);
        String dString = x.substring(4,5);

        int a = Integer.parseInt(aString);
        int b = Integer.parseInt(bString);
        int c = Integer.parseInt(cString);
        int d = Integer.parseInt(dString);


        int answer = 0;
        switch (z)
        {
            case '+':
                answer = (a/b) + (c/d);
                break;
            case '-':
                answer = (a/b) - (c/d);
                break;
            case '*':
                answer = (a/b) * (c/d);
                break;
            case '/':
                answer = (a/b) /(c/d);
                break;
            default:
                System.out.println("ERROR");
                break;
        }
        System.out.println("Answer = " + answer);
    }
}
