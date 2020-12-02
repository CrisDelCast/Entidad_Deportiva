package model;

public class Player extends Employee implements SoccerWorld{
    
    private int shirtNumber;
    private int goalsNumbers;
    private float averageMark;
    private String position;
    private float value;
    private float level;
    
    public Player(int shirtNumber, int goalsNumbers, float averageMark, int position, String name, String ID, int salary, boolean status) {
        super(name, ID, salary, status);
        this.shirtNumber = shirtNumber;
        this.goalsNumbers = goalsNumbers;
        this.averageMark = averageMark;
        this.position = String.valueOf(Position.values()[position]);
    }
    
    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public int getGoalsNumbers() {
        return goalsNumbers;
    }

    public void setGoalsNumbers(int goalsNumbers) {
        this.goalsNumbers = goalsNumbers;
    }

    public float getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(float averageMark) {
        this.averageMark = averageMark;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void calculateMarketPrice() {
        switch (position) {
            case "Portero":
                
                value = (getSalary()*12) + (averageMark*150);
                
                break;
                
            case "Defensor":
                
                value = (getSalary()*13) + (averageMark*125) + (goalsNumbers*100);
                
                break;
                
            case "Volante":
                
                value = (getSalary()*14) + (averageMark*135) + (goalsNumbers*125);
                
                break;
                
            case "Delantero":
                
                value = (getSalary()*15) + (averageMark*145) + (goalsNumbers*150);
                
                break;
        }
    }

    @Override
    public void calculateStarts() {
        
        switch (position) {
            case "Portero":
                
                level = (float) (averageMark * 0.9);
                
                break;
                
            case "Defensor":
                
                level = (float) (averageMark * 0.9) + (goalsNumbers/100);
                
                break;
                
            case "Volante":
                
                level = (float) (averageMark * 0.9) + (goalsNumbers/90);
                
                break;
                
            case "Delantero":
                
                level = (float) (averageMark * 0.9) + (goalsNumbers/80);
                
                break;
        }   
    }
    
    
    
}