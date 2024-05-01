
import java.util.Scanner;

public class Main {
    public static int[] strArryToIntArray(String[] strArray) {
        int[] intArray = new int[strArray.length];
        for(int i=0; i<intArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        return intArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] current = strArryToIntArray(sc.next().split(":"));
        int[] target = strArryToIntArray(sc.next().split(":"));

        int[] max = {24, 60, 60};

        int[] remain = new int[3];
        for(int i=2; i>=0; i--) {

            if(target[i] < current[i]) {
                remain[i] = max[i] - current[i] + target[i];
                if(i != 0) {
                    current[i-1] += 1;
                }
            } else if(target[i] > current[i]) {
                remain[i] = target[i] - current[i];
            }
        }

        if(remain[0]+remain[1] + remain[2] == 0) {
            System.out.print("24:00:00");
        } else {
            System.out.print(String.format("%02d:%02d:%02d", remain[0], remain[1], remain[2]));
        }

    }
}
