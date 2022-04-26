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

    public static void timeEstimation(String input){
        long startTime = System.currentTimeMillis();
        dictionaryAttack(input);
        long finishTime = System.currentTimeMillis();
        long execution = finishTime - startTime;
        long toMinute = TimeUnit.MILLISECONDS.toMinutes(execution);
        long toSeconds = TimeUnit.MILLISECONDS.toSeconds(execution);
        System.out.println("Execution time of dictionary attack in miliseconds: " + execution);
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
            if (Character.isUpperCase(input.charAt(i))) {
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

    public static void bruteForce(String input){
        int stringLength = input.length();
        if(stringLength <= 5){
            System.out.println("Instantly");
        }
        switch(stringLength){
            case 6:
                if(hasNumbers(input) && hasLower(input) && hasUppers(input) && hasSymbol(input)){
                    System.out.println("5 seconds");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("1 second");
                    break;
                }
                else{
                    System.out.println("Instantly");
                    break;
                }

            case 7:
                if((hasNumbers(input) && hasLower(input) && hasUppers(input) && hasSymbol(input))){
                System.out.println("6 minutes");
                break;
                 }
                else if(hasUppers(input) && hasLower(input) && hasNumbers(input)){
                    System.out.println("1 minute");
                    break;
                }
                else if(hasUppers(input) && hasLower(input)){
                    System.out.println("25 seconds");
                    break;
                }


            case 8:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("8 hours");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("1 hour");
                    break;
                }

                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("22 minutes");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("Instantly");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("5 seconds");
                    break;
                }


            case 9:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("3 weeks");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("3 days");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("19 hours");
                    break;
                }

                else if(hasLower(input)){
                    System.out.println("2 minutes");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("Instantly");
                    break;
                }

            case 10:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("5 years");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("7 months");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("1 month");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("58 minutes");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("Instantly");
                    break;
                }

            case 11:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("400 years");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("41 years");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("5 years");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("1 day");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("2 seconds");
                    break;
                }

            case 12:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("34,000 years");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("2,000 years");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("300 years");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("3 weeks");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("25 seconds");
                    break;
                }

            case 13:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("2,000,000 years");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("100,000 years");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("16,000 years");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("1 year");
                    break;
                }
                else if(hasNumbers(input)){
                    System.out.println("4 minutes");
                    break;
                }

            case 14:
                if(rate(input).equals("Password Grade = A")){
                    System.out.println("200,000,000 years");
                    break;
                }
                else if(hasNumbers(input) && hasLower(input) && hasUppers(input)){
                    System.out.println("9,000,000 years");
                    break;
                }
                else if (hasUppers(input) && hasLower(input)){
                    System.out.println("800,000 years");
                    break;
                }
                else if(hasLower(input)){
                    System.out.println("51 years");
                    break;
                }

                else if(hasNumbers(input)){
                    System.out.println("41 minutes");
                    break;
                }
        }
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
        String grade = rate("hellS1*D");
   //     bruteForce("hellS1*Da");
        System.out.println(grade);
    //    timeEstimation("Aaron615");
        bruteForce("12AAbb!!o0");
    }

}