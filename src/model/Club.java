package model;

public class Club {
	
	//Constants
	private final static int DRESSING_ROOM_A_LONG = 7;
	private final static int DRESSING_ROOM_A_WIDTH = 6;
	
	private final static int DRESSING_ROOM_B_LONG = 7;
	private final static int DRESSING_ROOM_B_WIDTH = 7;
	
	private final static int AMOUNT_EMPLOYEE = 58;
	
	private final static int OFFICE_SECTOR_LONG = 6;
	private final static int OFFICE_SECTOR_WIDTH = 6;
	
	private final static int AMOUNT_TEAMS = 2;
	//
	
	private Team[] teams;
	
	private Coach[][] officeSector;
	
	private Employee[] employees;
	
	private Player[][] dressinRoomA;
	private Player[][] dressinRoomB;

	private int nit;
	private String date;
	
	
	public Club(int nit, String date){
		
		this.nit = nit;
		this.date = date;
		
		teams = new Team[AMOUNT_TEAMS];
		officeSector = new Coach[OFFICE_SECTOR_LONG][OFFICE_SECTOR_WIDTH];
		employees = new Employee[AMOUNT_EMPLOYEE];
		dressinRoomA = new Player[DRESSING_ROOM_A_LONG][DRESSING_ROOM_A_WIDTH];
		dressinRoomB = new Plyer[DRESSING_ROOM_B_LONG][DRESSING_ROOM_B_WIDTH];
		
	}
    
	
	public String contractEmployee(int shirtNumber, int goalsNumbers, float averageMark, int position, String name, String ID, int salary, boolean status){
		
		String msg = "";
		int cont = 0;
		
		for(int i = 0; i < employees.length; i++){
			
			if(employees[i] != null){
				
				for(int i = 0; i < employees.length; i++){
					
					if(employees[i] instanceof Player){
						
						cont ++;
					}
				}
				
				if(cont < 50){
					
					Player player = new Player(shirtNumber, goalsNumbers, averageMark, position, name, ID, salary, status);
					employees[i] = player;
					i = employees.length;
				
					msg = "El jugador se ha añadido correctamente"
					
				}
				
				
			} else {
				
				msg = "No se ha podido agregar el jugador"
			}
			
		}
		
		return msg;
	}
	
	public String showInfo(){
		
		
	}
}



