package model;

public class AssistantCoach extends Coach{
  
    private boolean wasPlayer;
    private String expertise;

    public AssistantCoach(boolean wasPlayer, int expertise) {
        this.wasPlayer = wasPlayer;
        this.expertise = String.valueOf(Expertise.values()[expertise]);
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
