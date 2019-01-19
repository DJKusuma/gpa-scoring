package id.dhanarjkusuma.apps;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {
    private static final int SCORE_NOTFOUND = -1;
    private static final int INVALID_GRADE = -1;
    private List<Score> scoreList;

    public ScoreCalculator(){
        scoreList = new ArrayList<>();
    }

    public void recordScore(String code, String name, String grade, int sks){
        Score score = new Score(code, name, grade, sks);
        scoreList.add(score);
    }

    public void calculateIPS(){
        int sigmaSKS = 0;
        int sigmaMultipleSKSGrade = 0;
        System.out.println("Matakuliah yang Anda ambil adalah : ");
        for(int i=0; i<scoreList.size(); i++){
            int gradeScore = gradeToNumber(scoreList.get(i).getGrade());
            if(gradeScore == INVALID_GRADE){
                continue;
            }
            sigmaMultipleSKSGrade += (scoreList.get(i).getSks() * gradeScore);
            sigmaSKS += scoreList.get(i).getSks();
            System.out.println(scoreList.get(i).getCode() + "\t" + scoreList.get(i).getName() + "\t" + scoreList.get(i).getGrade() + "\t" + scoreList.get(i).getSks());
        }
        float score = Float.valueOf(String.valueOf(sigmaMultipleSKSGrade)) / Float.valueOf(String.valueOf(sigmaSKS));
        System.out.println("Nilai IPS Anda adalah " + score);
    }

    public int getScoreIndexByCode(String code){
        for(int i=0; i<scoreList.size(); i++){
            if(scoreList.get(i).getCode().equals(code)){
                return i;
            }
        }
        return SCORE_NOTFOUND;
    }

    public void updateScore(String code, String grade){
        int idx = getScoreIndexByCode(code);
        if(idx == SCORE_NOTFOUND){
            return;
        }
        scoreList.get(idx).setGrade(grade);
    }

    private int gradeToNumber(String grade){
        switch (grade){
            case "A":
                return 4;
            case "B":
                return 3;
            case "C":
                return 2;
            case "D":
                return 1;
            case "E":
                return 0;
            default:
                return INVALID_GRADE;
        }
    }

    private String numberToGrade(int grade){
        switch (grade){
            case 4:
                return "A";
            case 3:
                return "B";
            case 2:
                return "C";
            case 1:
                return "D";
            case 0:
                return "E";
            default:
                return "INVALID_GRADE";
        }
    }
}
