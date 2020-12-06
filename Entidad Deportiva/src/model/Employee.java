package model;

public abstract class Employee {
    
    private String name;
    private String ID;
    private int salary;
    private boolean status;

    public Employee(String name, String ID, int salary, boolean status) {
        this.name = name;
        this.ID = ID;
        this.salary = salary;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
	
    public abstract String showInfo();
	
	
}




