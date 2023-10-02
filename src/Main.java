import service.FileService;
import service.GameService;
import service.interfaces.FileServiceInter;
import service.interfaces.GameServiceInter;

import java.util.concurrent.TimeUnit;



public class Main {
    public static void main(String[] args) throws InterruptedException {


        FileServiceInter fileServiceInter = new FileService();
        GameServiceInter gameServiceInter = new GameService();

        System.out.println("Game is starting ");
        System.out.println(3);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println(1);
        TimeUnit.SECONDS.sleep(1);

                      //  Or

//        for (int i = 3; i >=0; i--) {
//            Thread.sleep(1000);
//            System.out.print("\rGame starts in " + i + " seconds");
//        }

        gameServiceInter.start();

    }
}