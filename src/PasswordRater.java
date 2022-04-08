import java.util.regex.Matcher; 
import java.util.regex.Pattern;
public class PasswordRater {
    
    public static void rate(String input){
       int counter = 0;
       String grade="";
       if (input.length()>= 8)
       {
           counter++;
       }
       Pattern specialPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
       Matcher specialMatcher = specialPattern.matcher(input);
       boolean specialBoolean = specialMatcher.find();
       if (specialBoolean)
       {
        counter++;
       }
       Pattern numberPattern = Pattern.compile("[0-9]");
       Matcher numberMatcher = numberPattern.matcher(input);
       boolean numberBoolean = numberMatcher.find();
       if (numberBoolean)
       {
        counter++;
       }
       
        for (int i = 0; i < input.length(); i++) {
          if (Character.isUpperCase(input.charAt(i))) {
            counter++;
            break;
          }
        }
     
        for (int i = 0; i < input.length(); i++) {
          if (Character.isLowerCase(input.charAt(i))) {
            counter++;
            break;
          }
        }
       if(counter==5)
       {
           grade= "Password Grade = A";
       }
       else if(counter==4)
       {
           grade= "Password Grade = B";
       }
       else if(counter==3)
       {
           grade= "Password Grade = C";
       }
       else if(counter==2)
       {
           grade= "Password Grade = D";
       }
       else 
       {
           grade= "Password Grade = F";
       }
       System.out.println(grade);
    }

    public static void timeEstimation(String input){
        
    }
    public static void main(String[] args){
        rate("hellS1*D");
        
    }

}