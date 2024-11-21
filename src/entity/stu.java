package entity;

public class stu {
    private String id;
    private String name;
    private String sex;
    private double score;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

    public String toString() {
        return "学号: " + id + ", 姓名: " + name + ", 性别: " + sex + ", 分数: " + score;
    }
}
