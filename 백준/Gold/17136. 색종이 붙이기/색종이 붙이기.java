
import java.io.*;
import java.util.*;

public class Main {
    static int[] myPapers = new int[]{5, 5, 5, 5, 5};
    static final int BIG_PAPER_SIZE = 10;
    static int[][] bigPaper = new int[BIG_PAPER_SIZE][BIG_PAPER_SIZE];
    static int minCount = 26;
    static int nextX = 0;
    static int nextY = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 10 X 10 종이 정보 받기
        for(int i=0; i<BIG_PAPER_SIZE; i++) {
            bigPaper[i] = new int[BIG_PAPER_SIZE];
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<BIG_PAPER_SIZE; j++) {
                bigPaper[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        tracking(0, 0, 0);

        bw.write((minCount >= 26 ? -1 : minCount)+"\n");

        bw.close();
    }

    static void tracking(int x, int y, int count) {
        if(minCount <= count) {
            return;
        }

        findNextCoordinate(x, y);
        int row = nextX;
        int col = nextY;

        if(row == -1 && col == -1) {
            minCount = count;
            return;
        }

        for(int i=1; i<=5; i++) {
            if(myPapers[i-1] == 0 || !isPossible(row, col, i)) {
                continue;
            }

            fill(row, col, i, 0);
            myPapers[i-1] -= 1;
            tracking(row, col, count+1);
            fill(row, col, i, 1);
            myPapers[i-1] += 1;
        }

    }

    static boolean isPossible(int x, int y, int size) {
        if(x+size> BIG_PAPER_SIZE || y+size> BIG_PAPER_SIZE) {
            return false;
        }
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(bigPaper[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
    static void fill(int x, int y, int size, int color) {
        for(int i = x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                bigPaper[i][j] = color;
            }
        }
    }

    static void findNextCoordinate(int x, int y) {
        nextX = -1;
        nextY = -1;
        for(int i = x; i<BIG_PAPER_SIZE; i++) {
            for(int j= 0; j<BIG_PAPER_SIZE; j++) {
                if(bigPaper[i][j] == 1) {
                    nextX = i;
                    nextY = j;
                    return;
                }
            }

        }
    }

}
