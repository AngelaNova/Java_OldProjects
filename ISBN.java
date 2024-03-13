public class ISBN {

 public static void main(String[] args) {
 
 
  //Declaring the variable to represent the ISBN number
        int n = Integer.parseInt(args[0]);
        
    
    /*declaring variables that will represent the digits in the position 5, 4, 3 and 2 
     * + the equation with which it is possible to determine the value of the digit in position 1
    */
    int d5,d4,d3,d2,d1,equation;
    
    
    /*Using operations to obtain the digit for each position and to obtain an equation to find 
     * the value of the digit number 1 that . 
    *Assigning values to the variables d5, d4, d3, d2 and equation
    */
    
    d5=n/1000;
    d4=(n/100)%10;
    d3=(n/10)%10;
    d2=n%10;
    
    /*Using a equation where the sum of all the digit multiplied by the number of the position in which they are
     * is a multiple of 11, if not d1 will be the smallest number that must be able for the equation to be
     * a multiple of 11
    */
    
    equation=(5*d5+4*d4+3*d3+2*d2)%11;

  
    //Using conditional statement in chain form to obtain the first digit  
    if (equation==0) {System.out.println(0);}
    else if (equation==1) {System.out.println("X");}
    else if (equation==2) {System.out.println(9);}
    else if (equation==3) {System.out.println(8);}
    else if (equation==4) {System.out.println(7);}
    else if (equation==5) {System.out.println(6);}
    else if (equation==6) {System.out.println(5);}
    else if (equation==7) {System.out.println(4);}
    else if (equation==8) {System.out.println(3);}
    else if (equation==9) {System.out.println(2);}
    else if (equation==10) {System.out.println(1);}
    
        
        
 }

}
