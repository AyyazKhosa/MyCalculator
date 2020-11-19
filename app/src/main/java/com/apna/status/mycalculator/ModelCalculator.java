package com.apna.status.mycalculator;


public class ModelCalculator {
    private String ViewClass;
    private String Grade;
    private int Credits;

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public String getViewClass() {
        return ViewClass;
    }

    public void setViewClass(String viewClass) {
        ViewClass = viewClass;
    }
}
