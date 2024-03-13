import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 등급별 과목 평점
        String[] ranks = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F"};
        double[] scores = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0};

        double denomin = 0;  // 학점 총합
        double numer = 0;    // 학점 * 과목평점 합
        for(int i=0; i<20; i++){
            sc.next();
            double grade = sc.nextDouble();
            String rank = sc.next();

            if(!rank.equals("P")){
                denomin += grade;
                numer += (grade * scores[Arrays.binarySearch(ranks, rank)]);
            }

        }

        // 전공평점 출력
        double avg = numer / denomin;
        System.out.println(String.format("%.6f", avg));
    }
}