package model;

public class AssistantCoach extends Coach{
  
    private boolean wasPlayer;
    private String expertise;

    public AssistantCoach(boolean wasPlayer, int expertise, int yearsExperience, String name, String ID, int salary, boolean status) {
        super(yearsExperience, name, ID, salary, status);
        this.wasPlayer = wasPlayer;
        this.expertise = String.valueOf(Expertise.values()[expertise]);
    }

    @Override
    public String showInfo(){ 
        String player = (wasPlayer)?"SI":"NO";
        String status = (getStatus())?"Activo":"Inactivo";
        String info = "***********Entrenador asistente***********\n";
                  info += "Nombre: " + getName() + "\n";
                  info += "ID: " + getID() + "\n";
                  info += "Salary: " + getSalary() +" USD\n";
                  info += "Estado: " + status + "\n";
                  info += "Años de experiencia: " + getYearsExperience() + "\n";
                  info += "Fue jugador: " + player + "\n";
                  info += "Experticio: " + getExpertise() + "\n\n";
        return info;
    }
	   public boolean getWasPlayer() {
        return wasPlayer;
    }

    public void setWasPlayer(boolean wasPlayer) {
        this.wasPlayer = wasPlayer;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

}

