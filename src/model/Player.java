package model;

public class Player extends Employee implements SoccerWorld{
    
    private int shirtNumber;
    private int goalsNumbers;
    private double averageMark;
    private String position;
    private double value;
    private double level;
    
    public Player(int shirtNumber, int goalsNumbers, double averageMark, int position, String name, String ID, int salary, boolean status) {
        super(name, ID, salary, status);
        this.shirtNumber = shirtNumber;
        this.goalsNumbers = goalsNumbers;
        this.averageMark = averageMark;
        this.position = String.valueOf(Position.values()[position]);
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
                
                level = (averageMark * 0.9);
                
                break;
                
            case "Defensor":
                
                level = (averageMark * 0.9) + (goalsNumbers/100);
                
                break;
                
            case "Volante":
                
                level = (averageMark * 0.9) + (goalsNumbers/90);
                
                break;
                
            case "Delantero":
                
                level = (averageMark * 0.9) + (goalsNumbers/80);
                
                break;
        }   
    }
    
    @Override
    public String showInfo(){
        String estado = (getStatus())?"Activo":"Inactivo";
        String info = "**************Jugador*************\n";
                  info += "Nombre: " + getName() + "\n";
                  info += "ID: " + getID() + "\n";
                  info += "Salary: " + getSalary() + " USD\n";
                  info += "Estado: " + estado + "\n";
                  info += "Numero de camisa: " + getShirtNumber() + "\n";
                  info += "Numero de goles: " + getGoalsNumbers() + "\n";
                  info += "Calificacion promedio: " + getAverageMark() + "\n";
                  info += "Posicion: " + getPosition() + "\n";
                  info += "Precio en el mercado: " + getValue() + "\n";
                  info += "Nivel: " + getLevel() + "\n\n";
                  
        return info;
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

    public double getAverageMark() {
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

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
    
}
