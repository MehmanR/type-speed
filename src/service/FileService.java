package service;

import global.GlobalStrings;
import service.interfaces.FileServiceInter;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class FileService implements FileServiceInter {


    @Override
    public String pullRandomWord() {
        String urlPath = GlobalStrings.RANDOM_WORD_URL_PATH;
        String splitedWord = null;
        try {
            URL url = new URL(urlPath);
            Scanner sc = new Scanner(url.openStream());
            String randomWord = sc.useDelimiter("\\A").nextLine();
            splitedWord = randomWord.replace("[\"", "").replace("\"]", "");


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return splitedWord;
    }

    @Override
    public void wrtiteWordToFile(String word) {
        try {
            File file = new File(GlobalStrings.RANDOM_WORD_FILE);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            if (!file.exists()) {
                file.createNewFile();
            }
            bufferedWriter.write(word);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void readWordFromFile(String fileName) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String word = null;
            while ((word = bufferedReader.readLine()) != null) {
                stringBuilder.append(word + "\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public String[] writeWordsToArray() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GlobalStrings.RANDOM_WORD_FILE));
            int arraySize = 0;
            while (bufferedReader.readLine() != null) {
                arraySize++;
            }
            bufferedReader.close();

            bufferedReader = new BufferedReader(new FileReader(GlobalStrings.RANDOM_WORD_FILE));
            String line;
            String[] randomWordsDinamicArr = new String[arraySize];
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                randomWordsDinamicArr[index] = line;
                index++;
            }
            return randomWordsDinamicArr;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
