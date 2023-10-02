import service.FileService;
import service.interfaces.FileServiceInter;
import utils.RandomNum;


public class Main {
    public static void main(String[] args) {


        FileServiceInter fileServiceInter = new FileService();

        for (int i = 0; i < 5; i++) {
            String[] wordsArray = fileServiceInter.writeWordsToArray();
            int randomNumber = RandomNum.getRandomNumber(wordsArray.length);
            System.out.println(wordsArray[randomNumber]);
        }

        

    }
}