import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Random;


public class Repository {
    static int[][] mat = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 10 },
            { 1, 0, 3, 4, 5, 0, 7, 8, 0, 10 },
            { 1, 0, 3, 0, 0, 0, 0, 8, 0, 10 },
            { 1, 0, 0, 0, 5, 6, 0, 8, 0, 10 },
            { 1, 0, 3, 0, 5, 6, 0, 0, 0, 10 },
            { 1, 0, 3, 0, 0, 0, 0, 8, 0, 10 },
            { 1, 0, 3, 4, 0, 6, 7, 8, 0, 10 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 10 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }
            };
    public static boolean valid(int x, int y){
        if(mat[x][y]==0)
            return true;
        else
            return false;
    }

    public static int botThread(){
        Thread t = new Thread(new MyRunnable());
        t.start();
        System.out.println(Thread.currentThread().getName());
        Random rand = new Random();
        t.stop();
        return rand.nextInt(2);

    }

    public static boolean sameSpot(int pX,int pY, int hX, int hY){
        if(pX==hX&&pY==hY)
            return true;
        else
            return false;
    }
}
