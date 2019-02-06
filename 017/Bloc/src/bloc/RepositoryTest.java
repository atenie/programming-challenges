package bloc;

import static org.junit.Assert.*;

public class RepositoryTest {

    @org.junit.Test
    public void getRand() {
        Repository repository = new Repository();
        boolean value = false;
        int a = repository.getRand();
        if(a>=0 || a<=3)
            value=true;
        assertEquals(value,true);
    }

    @org.junit.Test
    public void setFirst() {
        Repository repository = new Repository();
        repository.setFirst();
        int count=0;
        for(int i = 0;i <=3;i++) {
            for (int j = 0; j <= 3; j++) {
                if (repository.numberList[i][j] !=0)
                    count++;
            }
        }
        assertEquals(count,2);
    }

    @org.junit.Test
    public void checkFull() {
        Repository repository = new Repository();
        assertEquals(repository.checkFull(),false);
    }

    @org.junit.Test
    public void setRand() {
        Repository repository = new Repository();
        repository.setRand();
        int count=0;
        for(int i = 0;i <=3;i++) {
            for (int j = 0; j <= 3; j++) {
                if (repository.numberList[i][j] !=0)
                    count++;
            }
        }
        assertEquals(count,1);
    }

    @org.junit.Test
    public void up() {
        Repository repository = new Repository();
        repository.numberList[2][2]=1;
        repository.up();
        assertEquals(repository.numberList[0][2],1);
    }

    @org.junit.Test
    public void down() {
        Repository repository = new Repository();
        repository.numberList[2][2]=1;
        repository.down();
        assertEquals(repository.numberList[3][2],1);
    }

    @org.junit.Test
    public void left() {
        Repository repository = new Repository();
        repository.numberList[2][2]=1;
        repository.left();
        assertEquals(repository.numberList[2][0],1);
    }

    @org.junit.Test
    public void right() {
        Repository repository = new Repository();
        repository.numberList[2][2]=1;
        repository.right();
        assertEquals(repository.numberList[2][3],1);
    }
}