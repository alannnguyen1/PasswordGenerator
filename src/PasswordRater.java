import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordRater {
    
    public static String rate(String input){
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
       return grade;

    }

    public static String timeEstimationDictionary(String input){
        long startTime = System.nanoTime();
        boolean check = dictionaryAttack(input);
        long finishTime = System.nanoTime();
        long execution = finishTime - startTime;
        long toSeconds =  TimeUnit.NANOSECONDS.toSeconds(execution);
        
        if(check == false){
            return ("Input password could not be found in dictionary");
        }
        else if(check == true){
            return("Password found in dictionary.\n Time taken(ns):" + execution);
        }
        return "N/A";
    }

    public static boolean hasSymbol(String input){
        Pattern specialPattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE);
        Matcher specialMatcher = specialPattern.matcher(input);
        boolean specialBoolean = specialMatcher.find();
        return specialBoolean;
    }

    public static boolean hasUppers(String input){
        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLower(String input){
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLowerCase(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    public static boolean hasNumbers(String input){
        Pattern numberPattern = Pattern.compile("[0-9]");
        Matcher numberMatcher = numberPattern.matcher(input);
        boolean numberBoolean = numberMatcher.find();
        return numberBoolean;
    }

    public static String bruteForce(String input){
        int stringLength = input.length();
        if(stringLength <= 5){
            return "Instantly";
        }
        switch(stringLength){
            case 6:
                if(hasNumbers(input) && hasLower(input) && hasUppers(input) && hasSymbol(input)){
                    return ("5 seconds");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("1 second");
                }
              
                else{
                    return ("Instantly");

                }
            case 7:
                if((hasNumbers(input) && hasLower(input) && hasUppers(input) && hasSymbol(input))){
                    return ("6 minutes");

                 }
                 else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("1 minute");
                }
             
                
                else if(hasUppers(input) && hasLower(input)){
                    return ("25 seconds");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("25 seconds");
                }
              
                else{
                    return ("Instantly");
                }


            case 8:
                if(rate(input).equals("Password Grade = A")){
                    return ("8 hours");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                )
                {
                    return ("1 hour");

                }

                else if (hasUppers(input) && hasLower(input)){
                    return ("22 minutes");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return("5 seconds");
                }

                else if(hasNumbers(input) || hasSymbol(input)){
                    return ("Instantly");

                }
                else if(hasLower(input) || hasUppers(input)){
                    return ("5 seconds");

                }


            case 9:
                if(rate(input).equals("Password Grade = A")){
                    return ("3 weeks");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("3 days");
                }
        
                else if (hasUppers(input) && hasLower(input)){
                    return ("19 hours");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("2 minutes");
                }
                
                else if(hasLower(input) || hasUppers(input)){
                    return ("2 minutes");

                }

                else if(hasNumbers(input)|| hasSymbol(input)){
                    return ("Instantly");

                }
                break;

            case 10:
                if(rate(input).equals("Password Grade = A")){
                    return ("5 years");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("7 months");
                }
            
                else if (hasUppers(input) && hasLower(input)){
                    return ("1 month");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("58 minutes");
                }
            
                else if(hasLower(input) || hasUppers(input)){
                    return ("58 minutes");

                }

                else if(hasNumbers(input) || hasSymbol(input)){
                    return ("Instantly");

                }
        

            case 11:
                if(rate(input).equals("Password Grade = A")){
                    return ("400 years");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("41 years");
                }
             
                else if (hasUppers(input) && hasLower(input)){
                    return ("5 years");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("1 years");
                }
              
                else if(hasLower(input) || hasUppers(input)){
                    return ("1 day");

                }

                else if(hasNumbers(input) || hasSymbol(input)){
                    return ("2 seconds");

                }

            case 12:
                if(rate(input).equals("Password Grade = A")){
                    return ("34,000 years");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("2,000 years");
                }
               
                else if (hasUppers(input) && hasLower(input)){
                    return ("300 years");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("3 years");
                }
                
                else if(hasLower(input) || hasUppers(input)){
                    return ("3 weeks");

                }

                else if(hasNumbers(input)|| hasSymbol(input)){
                    return ("25 seconds");

                }
            
            case 13:
                if(rate(input).equals("Password Grade = A")){
                    return ("2,000,000 years");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("100,000 years");
                }
               
                else if (hasUppers(input) && hasLower(input)){
                    return ("16,000 years");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("1 years");
                }
                else if((hasLower(input) && hasNumbers(input)) || (hasUppers(input) && hasNumbers(input))){
                    return("1 years");
                }

                else if(hasLower(input) || hasUppers(input)){
                    return ("1 year");

                }
                else if(hasNumbers(input) || hasSymbol(input)){
                    return ("4 minutes");

                }
                break;

            case 14:
                if(rate(input).equals("Password Grade = A")){
                    return ("200,000,000 years");

                }
                else if((hasNumbers(input) && hasLower(input) && hasUppers(input)) || 
                (hasUppers(input) && hasLower(input) && hasSymbol(input)) || 
                (hasUppers(input) && hasNumbers(input) && hasSymbol(input)) ||
                hasLower(input) && hasNumbers(input) && hasSymbol(input)
                ){
                    return ("9,000,000 years");
                }
            
                else if (hasUppers(input) && hasLower(input)){
                    return ("800,000 years");

                }
                else if((hasLower(input) && hasNumbers(input)) 
                || (hasUppers(input) && hasNumbers(input)) ||
                (hasUppers(input) && hasSymbol(input)) ||
                (hasLower(input) && hasSymbol(input))
                ){
                    return ("51 years");
                }
            
                else if(hasLower(input) || hasUppers(input)){
                    return ("51 years");

                }
                else if(hasNumbers(input)|| hasSymbol(input)){
                    return ("41 minutes");

                }
        }
        return "Computational Infeasible";
    }

    public static boolean  dictionaryAttack(String input){
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
                    return true;
                }
            }
        }
        catch(Exception e){
            System.out.println("Error with reading file");
        }

        return false;
    }
    /*
    public static void main(String[] args){
        String grade = rate("hellS1*D");
        System.out.println(grade);
        timeEstimationDictionary("123456");
        bruteForce("12AAbb!!o0");
    }f
     */

}
