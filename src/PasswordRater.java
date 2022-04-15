import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
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
        long startTime = System.currentTimeMillis();
        dictionaryAttack(input);
        long finishTime = System.currentTimeMillis();
        long execution = finishTime - startTime;
        long toMinute = TimeUnit.MILLISECONDS.toMinutes(execution);
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(execution);
        System.out.println("Execution time of dictionary attack in miliseconds: " + execution);
    }

    public static void dictionaryAttack(String input){
        BufferedReader br = null;
        String line;
        boolean found = false;
        try{
            FileReader fr = new FileReader("rockyou.txt");
            br = new BufferedReader(fr);
            while((line = br.readLine())!= null){
                if(line.equals(input)){
                    System.out.println("Found password in dictionary");
                    found = true;
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error with reading file");
        }
        if(found == false){
            System.out.println("Input password could not be found in dictionary");
        }

    }
    public static void main(String[] args){
        rate("hellS1*D");
        timeEstimation("Aaron615");
    }

}