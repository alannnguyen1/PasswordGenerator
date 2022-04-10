import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PasswordGenerator {
    public static void generate(){
        Random rand = new Random();
        ArrayList<String> lettersList = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m",
                "n","o","p","q","r","s","t","u","v","w","x","y","z"));
        ArrayList<String> specialList = new ArrayList<>(Arrays.asList("!","@","#","$","%","^","&","*","(",")"));
        ArrayList<String> numbersList = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","0"));
        int length = 8 + rand.nextInt(8);
        int capital = rand.nextInt(length);
        int special = rand.nextInt(length);
        while (capital == special) {
            special = rand.nextInt(length);
        }
        int number = rand.nextInt(length);
        while (capital == number || special == number) {
            number = rand.nextInt(length);
        }
        StringBuilder password = new StringBuilder("");
        for(int i = 0; i < length; i++) {
            if(i == capital){
                password.append(lettersList.get(rand.nextInt(lettersList.size())).toUpperCase());
            }
            else if(i == special){
                password.append(specialList.get(rand.nextInt(specialList.size())));
            }
            else if(i == number){
                password.append(numbersList.get(rand.nextInt(numbersList.size())));
            }
            else{
                password.append(lettersList.get(rand.nextInt(lettersList.size())));
            }
        }
        System.out.println(password);
    }
    public static void main(String[] args) {
        for (int i = 0 ; i < 10; i++) {
            generate();
        }
    }
}
