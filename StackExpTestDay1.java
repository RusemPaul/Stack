import java.util.Stack;
import java.lang.Math;

public class StackExpTestDay1
{
 public static double evalAns(String exp)
 {
  Stack<Double> computer = new Stack<Double>();
  for (int i = 0; i < exp.length(); i++)
  {
    String part = exp.substring(i, i + 1);
    if (!(isOperator(part)))
    {
      computer.push(Double.parseDouble(part));
    }
    else
    {
      if (part.equals("+"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(y + x);
      }
      if (part.equals("-"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(y - x);
      }
      if (part.equals("*"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(y * x);
      }
      if (part.equals("/"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(y / x);
      }
      if (part.equals("^"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(Math.pow(y, x));
      }
      if (part.equals("!"))
      {
        double x = computer.pop();
        computer.push(factorial(x));
      }
      if (part.equals("%"))
      {
        double x = computer.pop();
        double y = computer.pop();
        computer.push(y % x);
      }
    }
  }
  return computer.pop();
 }
 
 public static boolean isOperator(String s)
 {
   return s.equals("!") ||
       s.equals("+") ||
       s.equals("-") ||
       s.equals("*") ||
       s.equals("/") ||
       s.equals("^") ||
       s.equals("%");
 }
 
 public static double factorial(double n)
 {
   if (n == 1)
   {
     return n;
   }
   return n * factorial(n - 1);
 }
 
  public static void main(String[] args)
  {
    double answer, yourAns;
    String exp;
  int c=0, w=0;
    
    exp = "256++";
    System.out.println("Testing Post-fix Single Digit Operation");
    System.out.println("Operations tested: +,-,*,/,%,^,!");
    System.out.println("Testing 2+5+6");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 13;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "256*+9-";
    System.out.println("Testing 2+5*6-9");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 23;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }
    
    System.out.println();
    exp = "111+3^+2/";
    System.out.println("Testing (1+(1+1)^3)/2");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4.5;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "12+3*23+%";
    System.out.println("Testing (1+2)*3%(2+3)");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 4;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
    exp = "473%-!";
    System.out.println("Testing (4-7%3)!");
    System.out.print("Postfix equivalent " + exp + "...");
    answer = 6;
    yourAns = evalAns(exp);
    if(yourAns==answer){
      System.out.println("Pass");
   c++;
    }else{
      System.out.println("Failed... Your answer: " + yourAns + "; Correct answer: " + answer);
   w++;
    }

  System.out.println();
  System.out.println("Number of correct answer: " + c);
  System.out.println("Number of incorect answer: " + w);
  System.out.println("Accuracy: " + Math.round((double)c/(c+w)*100)/100 + "%");
  }
}

