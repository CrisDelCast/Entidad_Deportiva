package model;

public class MainCoach extends Coach implements SoccerWorld{
    
    private int teamsInCharge;
    private int numberChampionships;
    private float value;
    private float level;

    public MainCoach(int teamsInCharge, int numberChampionships, int yearsExperience, String name, String ID, int salary, boolean status) {
        super(yearsExperience, name, ID, salary, status);
        this.teamsInCharge = teamsInCharge;
        this.numberChampionships = numberChampionships;
    }

    @Override
    public void calculateMarketPrice() {
        value = (getSalary() * 10) + (getYearsExperience() * 100) + (numberChampionships * 50);
    }

    @Override
    public void calculateStarts() {
        
        level = 5 + (numberChampionships/10);
        
    }
	
    @Override
	public String showInfo(){
            String estatus = (getStatus())?"Activo":"Inactivo";
            String info = "***********Entrenador principal***********\n";
                  info += "Nombre: " + getName() + "\n";
                  info += "ID: " + getID() + "\n";
                  info += "Salary: " + getSalary() + " USD\n";
                  info += "Estado: " + estatus + "\n";
                  info += "Años de experiencia: " + getYearsExperience() + "\n";
                  info += "Equipos a cargo en su carrera: " + getTeamsInCharge() + "\n";
                  info += "Campeonatos ganados en su carrera: " + getNumberChampionships() + "\n";
                  info += "Nivel: " + getLevel() + "\n\n";

            return info;
	}
	 public int getTeamsInCharge() {
        return teamsInCharge;
    }

    public void setTeamsInCharge(int teamsInCharge) {
        this.teamsInCharge = teamsInCharge;
    }

    public int getNumberChampionships() {
        return numberChampionships;
    }

    public void setNumberChampionships(int numberChampionships) {
        this.numberChampionships = numberChampionships;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getLevel() {
        return level;
    }

    public void setLevel(float level) {
        this.level = level;
    }
    
    
}








