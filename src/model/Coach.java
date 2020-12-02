package model;

public abstract class Coach extends Employee{
    
    private int yearsExperience;

    public Coach(int yearsExperience, String name, String ID, int salary, boolean status) {
        super(name, ID, salary, status);
        this.yearsExperience = yearsExperience;
    }

    public int getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience) {
        this.yearsExperience = yearsExperience;
    }
    
}