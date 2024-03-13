public class JudgeScore {
 public static void main(String[] args) {

 
  //Declaring the variables for storing the judges scores.
  int judge1, judge2, judge3, judge4;
  judge1 = Integer.valueOf(args[0]);
  judge2 = Integer.valueOf(args[1]);
  judge3 = Integer.valueOf(args[2]);
  judge4 = Integer.valueOf(args[3]);
  

  
  //Declaring the variable max1, max2 and max for storing the highest score 
  //max1 is the highest score between judge1's and judge2's scores
  //max2 is the highest score between max1's and judge3's scores
  //max is the highest score that was received from the judges
  int max1,max2,max;
  
  //Finding the maximum value by using conditional statements (if,else)in a chain form
  if (judge1>judge2) { max1=judge1;}
  else { max1=judge2;}
  if (judge3>max1) {max2=judge3;}
  else {max2=max1;}
  if (judge4>max2) {max=judge4;}
  else {max=max2;}
  
 
  //Declaring the variable min1, min2 and min for storing the lowest score 
  //min1 is the lowest score between judge1's and judge2's scores
  //min2 is the lowest score between min1's and judge3's scores
  //min is the lowest score that was received from the judges
  int min1,min2,min;
  
  //Finding the minimum value by using conditional statements (if,else)in a chain form
  if (judge1<judge2){ min1=judge1;}
  else { min1=judge2;}
  if (judge3<min1) {min2=judge3;}
  else {min2=min1;}
  if (judge4<min2) {min=judge4;}
  else {min=min2;}
  
  
  //We are doing a typecasting from integer to double to provide a more precise answer.
  double average= (double)( (judge1+judge2+judge3+judge4-max-min)/2.0);
  
    //  System.out.print("The average score is: ");
  //This statement shows on the screen what value of type double was stored in the variable "average".
      System.out.println (average);
   
  
  
  
 }
}
