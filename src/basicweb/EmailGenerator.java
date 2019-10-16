package basicweb;

import org.openqa.selenium.By;

import java.util.Random;

public class EmailGenerator {


    public String randomString(){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String randomString = "";
        int length = 5;
        Random random = new Random();
        char [] text = new char[length];

        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        for (int i = 0; i < text.length; i++){
            randomString += text[i];
        }
        return randomString;
    }
}
