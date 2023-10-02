package service.interfaces;

public interface FileServiceInter {

    String pullRandomWord();
    void wrtiteWordToFile(String word);

    void readWordFromFile(String fileName);

    String[] writeWordsToArray();






}
