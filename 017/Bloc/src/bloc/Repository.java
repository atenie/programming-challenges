package bloc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Random;

@ManagedBean
@ViewScoped
public class Repository {
    public int colCount = 1;
    public static int startCount = 0;
    public static int gameCount = 0;

    public static int[][] numberList;
    public static int[][] mergeMap;

    public Repository() {
        numberList = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        mergeMap = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }


    public static int getRand() {
        int a;
        Random random = new Random();
        a = random.nextInt(3) + 0;
        return a;
    }

    public static void setFirst() {
        if (startCount == 0) {
            int a = getRand();
            int b = getRand();
            numberList[a] = new int[]{0, 0, 1, 0};
            numberList[b] = new int[]{0, 1, 0, 0};
            startCount = 1;
        }
    }

    public static boolean checkFull() {
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++)
                if (numberList[i][j] == 0)
                    count++;
        }
        if (count != 0)
            return false;
        else return true;
    }

    public static boolean checkMax() {
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++)
                if (numberList[i][j] == 8)
                    count++;
        }
        if (count != 0)
            return false;
        else return true;
    }

    public static void setRand() {
        if (!checkFull()) {
            int added;
            added = 0;

            while (added == 0) {
                int a = getRand();
                int b = getRand();
                int[] copy = numberList[a];
                if (copy[b] == 0) {
                    copy[b] = 1;
                    numberList[a] = copy;
                    added = 1;
                }
            }
        } else if(checkFull())
            GameEndBad();
        if(!checkMax())
            GameEndGood();
    }

    private static void GameEndBad() {
        gameCount=2;
    }
    private static void GameEndGood() {
        gameCount=1;
    }

    public int[][] getNumberList() {
        return numberList;
    }

    public void setNumberList(int[][] numberList) {
        this.numberList = numberList;
    }

    public static void up() {
        for (int i = 3; i >= 1; i--) {
            for (int j = 0; j <= 3; j++) {
                if (numberList[i - 1][j] == 0) {
                    numberList[i - 1][j] += numberList[i][j];
                    numberList[i][j] = 0;
                } else if (numberList[i - 1][j] == numberList[i][j]) {
                    if (mergeMap[i][j] == 0) {
                        numberList[i - 1][j] += numberList[i][j];
                        numberList[i][j] = 0;
                        mergeMap[i - 1][j] = 1;
                    }
                }
            }
        }
        clearMap();
    }

    public static void down() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (numberList[i + 1][j] == 0) {
                    numberList[i + 1][j] += numberList[i][j];
                    numberList[i][j] = 0;
                } else if (numberList[i + 1][j] == numberList[i][j]) {
                    if (mergeMap[i][j] == 0) {
                        numberList[i + 1][j] += numberList[i][j];
                        numberList[i][j] = 0;
                        mergeMap[i + 1][j] = 1;
                    }
                }
            }
        }
        clearMap();
    }

    public static void left() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 3; j >= 1; j--) {
                if (numberList[i][j - 1] == 0) {
                    numberList[i][j - 1] += numberList[i][j];
                    numberList[i][j] = 0;
                } else if (numberList[i][j - 1] == numberList[i][j]) {
                    if (mergeMap[i][j] == 0) {
                        numberList[i][j - 1] += numberList[i][j];
                        numberList[i][j] = 0;
                        mergeMap[i][j - 1] = 1;
                    }
                }
            }
        }
        clearMap();
    }

    public static void right() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                if (numberList[i][j + 1] == 0) {
                    numberList[i][j + 1] += numberList[i][j];
                    numberList[i][j] = 0;
                } else if (numberList[i][j + 1] == numberList[i][j]) {
                    if (mergeMap[i][j] == 0) {
                        numberList[i][j + 1] += numberList[i][j];
                        numberList[i][j] = 0;
                        mergeMap[i][j + 1] = 1;
                    }
                }
            }
        }
        clearMap();
    }

    public static void print() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(numberList[i][j]);
            }
            System.out.println();
        }
        System.out.println("____");
    }

    public static void clearMap() {
        mergeMap = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }
}
