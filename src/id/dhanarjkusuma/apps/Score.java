package id.dhanarjkusuma.apps;

public class Score {
    private String code;
    private String name;
    private String grade;
    private int sks;

    public Score() {
    }

    public Score(String code, String name, String grade, int sks) {
        this.code = code;
        this.name = name;
        this.grade = grade;
        this.sks = sks;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }
}
