package model;

public class LineUps {
    
    private final static int FIELD_TRINING_LONG = 10;
    private final static int FIELD_TRINING_WIDTH = 7;
    
    private String date;
    private String tactic;
    private int[][] fieldFormation;

    public LineUps(String date, int tactic) {
        this.date = date;
        this.tactic = String.valueOf(Tactic.values()[tactic]);
        fieldFormation = new int[FIELD_TRINING_LONG][FIELD_TRINING_WIDTH];
    }

   
    
    public void convertFormation(String fieldFormation){
        String[] positions = fieldFormation.split("-");
        int[] formation = new int[this.fieldFormation.length];
        int[] pair =  {2,4,1,5,0,6};
        int[] odd = {3,2,4,1,5,0,6};
        
        for(int i = 0; i < positions.length; i++){
            formation[i] = Integer.parseInt(positions[i]);
        }
        
        for(int i = 0; i < this.fieldFormation.length; i++){
            for(int j = 0; j < formation[i]; j++){
                if(formation[i]%2 == 0){
                    this.fieldFormation[i][pair[j]] = 1;
                } else{
                    this.fieldFormation[i][odd[j]] = 1;
                }
            }
        }
        
    }
    
    public String showInfo(){
        String info = "";
            info += "     Fecha: " + date + "\n";
            info += "     Tactica: " + tactic + "\n";
            info += "     Formacion\n";
            for(int i = fieldFormation.length -1; i >= 0; i--){
                info += "     ";
                for(int j = 0; j < fieldFormation[0].length; j++){
                    info += fieldFormation[i][j];
                }
                info += "\n";
            }
            
            info += "\n\n";
            
        return info;
    }
	 public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTactic() {
        return tactic;
    }

    public void setTactic(String tactic) {
        this.tactic = tactic;
    }

    public int[][] getFieldFormation() {
        return fieldFormation;
    }

    public void setFieldFormation(int[][] fieldFormation) {
        this.fieldFormation = fieldFormation;
    }
    
}

