package service;

import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;
import utils.InputUtil;
import utils.RandomNum;

import java.util.Date;

public class GameService implements GameServiceInter {

    FileServiceInter fileServiceInter = new FileService();

    public String getRandomWord() {

        String[] wordsArray = fileServiceInter.writeWordsToArray();
        int randomNumber = RandomNum.getRandomNumber(wordsArray.length);
        return wordsArray[randomNumber];
    }

    @Override
    public void start() {
        int allWords = 0;
        int correctWords = 0;
        double wps = 0;
        long startTime = System.currentTimeMillis();
        long end = startTime + 60000;

        while (System.currentTimeMillis()<end) {
            String randomWord = getRandomWord();
            System.out.println(randomWord);
            String enteredWord = InputUtil.requeirString("");

            if (randomWord.equalsIgnoreCase(enteredWord)){
                correctWords++;
            }
            allWords++;
        }

        wps = (double) correctWords /60;
        System.out.println("WPS - " + wps);
        System.out.println("Correct words : " + correctWords);
    }

}
