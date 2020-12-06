package model;

import java.util.ArrayList;

public class Team {
    
    private final static int ASSITANT_NUMBERS = 3;
    private final static int PLAYER_NUMBERS = 25;
    
    private String name;
    private Player[] players;
    private AssistantCoach[] assistantCoachs;
    private MainCoach mainCoach;
    private ArrayList<LineUps> lineUps;
    
    public Team(String name) {
        this.name = name;
        players = new Player[PLAYER_NUMBERS];
        assistantCoachs = new AssistantCoach[ASSITANT_NUMBERS];
        lineUps = new ArrayList<>();
    }
    
  
    public void addLineUp(String date, int tactic, String formation){
        LineUps lineFormation = new LineUps(date, tactic);
        lineFormation.convertFormation(formation);
        lineUps.add(lineFormation);
    }
    
    public String showInfo(){
        String info = "";
        int main = (mainCoach != null)?1:0;
        int assistant = 0;
        int players = 0;
        
            for(int i = 0; i < assistantCoachs.length; i++){
                if(assistantCoachs[i] == null){
                    assistant = i;
                    i = assistantCoachs.length;
                }
            }
        
            for(int i = 0; i < this.players.length; i++){
                if(this.players[i] == null){
                    players = i;
                    i = this.players.length;
                }
            }
            
            info =  "*************Equipo***************\n";
            info += "Nombre: " + getName() + "\n";
            info += "Jugadores: " + players + "/25\n";
            for(int i = 0; i < this.players.length; i++){
                if(this.players[i] != null){
                    info += "     Jugador " + (i+1) + ": " + this.players[i].getName() + "\n";
                }
            }
            
            info += "Entrenador principal: " + main + "/1\n";
            if(mainCoach != null){
                    info += "      Entrenador: " + mainCoach.getName() + "\n";
            }
            
            info += "Entrenadores secundarios: " + assistant + "/2\n";
            for(int i = 0; i < assistantCoachs.length; i++){
                if(assistantCoachs[i] != null){
                    info += "     Asistente " + (i+1) + ": " + assistantCoachs[i].getName() + "\n";
                }
            }
            
            info += "Alineaciones: " + lineUps.size() + "\n";
            
            for(int i = 0; i < lineUps.size(); i++){
                info += lineUps.get(i).showInfo();
            }

            info += "\n\n";
            
        return info;
    }
	  public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public AssistantCoach[] getAssistantCoachs() {
        return assistantCoachs;
    }

    public void setAssistantCoachs(AssistantCoach[] assistantCoachs) {
        this.assistantCoachs = assistantCoachs;
    }

    public MainCoach getMainCoach() {
        return mainCoach;
    }

    public void setMainCoach(MainCoach mainCoach) {
        this.mainCoach = mainCoach;
    }
    
}


