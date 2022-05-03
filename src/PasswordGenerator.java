import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PasswordGenerator {
    public static String generate(boolean letters, boolean symbols, boolean numbers, boolean capitals, int passLength){
        if(!letters && !symbols && !numbers && !capitals) {
            return "Please select at least one requirement";
        }
        if(passLength == 0) {
            return "Please insert a length greater than 0";
        }
        Random rand = new Random();
        ArrayList<String> lettersList = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m",
                "n","o","p","q","r","s","t","u","v","w","x","y","z"));
        ArrayList<String> symbolsList = new ArrayList<>(Arrays.asList("!","@","#","$","%","^","&","*","(",")"));
        ArrayList<String> numbersList = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","0"));
        int capital = rand.nextInt(passLength);
        int special = rand.nextInt(passLength);
        while (capital == special) {
            special = rand.nextInt(passLength);
        }
        int number = rand.nextInt(passLength);
        while (capital == number || special == number) {
            number = rand.nextInt(passLength);
        }
        StringBuilder password = new StringBuilder("");
        for(int i = 0; i < passLength; i++) {
            boolean done = false;
            do {
                int picker = rand.nextInt(4);
                if(picker == 0 && capitals){
                    password.append(lettersList.get(rand.nextInt(lettersList.size())).toUpperCase());
                    done = true;
                }
                else if(picker == 1 && symbols){
                    password.append(symbolsList.get(rand.nextInt(symbolsList.size())));
                    done = true;
                }
                else if(picker == 2 && numbers){
                    password.append(numbersList.get(rand.nextInt(numbersList.size())));
                    done = true;
                }
                else if (picker == 3 && letters){
                    password.append(lettersList.get(rand.nextInt(lettersList.size())));
                    done = true;
                }
            } while (!done);
        }
        return password.toString();
    }
    public static void main(String[] args) {
        String pass = generate(true, true, true, true, 5);
        System.out.println(pass);
    }
}
