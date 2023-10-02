package utils;

import java.util.Random;

public class RandomNum {

    public static int getRandomNumber(int size){
        Random random = new Random();
        int randomNum = random.nextInt(size);
        return randomNum;
    }

}
