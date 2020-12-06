package model;

import java.util.ArrayList;

public class Club {

    //Constants
    private final static int DRESSING_ROOM_A_LONG = 7;
    private final static int DRESSING_ROOM_A_WIDTH = 6;

    private final static int DRESSING_ROOM_B_LONG = 7;
    private final static int DRESSING_ROOM_B_WIDTH = 7;

    private final static int OFFICE_SECTOR_LONG = 6;
    private final static int OFFICE_SECTOR_WIDTH = 6;

    private final static int AMOUNT = 2;

    private Team[] teams;

    private Coach[][] officeSector;

    private ArrayList<Employee> employees;

    private Player[][] dressingRoomA;
    private Player[][] dressingRoomB;

    private int nit;
    private String name;
    private String date;

    public Club() {

        this.nit = 162156564;
        this.date = "26/03/2003";
        this.name = "Real Madrid";
        teams = new Team[AMOUNT];
        Team teamA = new Team("R.Madrid A");
        Team teamB = new Team("R.Madrid B");
        teams[0] = teamA;
        teams[1] = teamB;
        officeSector = new Coach[OFFICE_SECTOR_LONG][OFFICE_SECTOR_WIDTH];
        employees = new ArrayList<>();
        dressingRoomA = new Player[DRESSING_ROOM_A_LONG][DRESSING_ROOM_A_WIDTH];
        dressingRoomB = new Player[DRESSING_ROOM_B_LONG][DRESSING_ROOM_B_WIDTH];

    }

   

    public String contractEmployee(int shirtNumber, int goalsNumbers, double averageMark, int position, String name, String ID, int salary, boolean status) {

        String info = "";

        Player player = new Player(shirtNumber, goalsNumbers, averageMark, position, name, ID, salary, status);
        player.calculateMarketPrice();
        player.calculateStarts();
        employees.add(player);

        info = "El jugador ha sido contratado correctamente";

        return info;
    }

    public String contractEmployee(int teamsInCharge, int numberChampionships, int yearsExperience, String name, String ID, int salary, boolean status) {

        String info = "";

        MainCoach coach = new MainCoach(teamsInCharge, numberChampionships, yearsExperience, name, ID, salary, status);
        coach.calculateMarketPrice();
        coach.calculateStarts();
        employees.add(coach);

        info = "El entrenador ha sido contratado correctamente.";

        return info;
    }

    public String contractEmployee(boolean wasPlayer, int expertise, int yearsExperience, String name, String ID, int salary, boolean status) {

        String info = "";

        AssistantCoach coach = new AssistantCoach(wasPlayer, expertise, yearsExperience, name, ID, salary, status);
        employees.add(coach);

        info = "El entrenador ha sido contratado.";

        return info;

    }
	newbi

    public String dismissEmployee(String name) {

        String dismiss = "";

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equalsIgnoreCase(name)) {
                employees.remove(i);
                i = employees.size();
                dismiss = "El empleado fue despedido";
            } else {
                dismiss = "El empleado no esta registrado.";
            }
        }

        return dismiss;
    }

    public String showEmployeeInfo() {

        String info = "";

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof Player) {
                info += employees.get(i).showInfo();
            }
        }

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof MainCoach) {
                info += employees.get(i).showInfo();
            }
        }

        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof AssistantCoach) {
                info += employees.get(i).showInfo();
            }
        }

        return info;
    }

    public String addEmployeeToTeam(String name, int team) {

        String add = "";

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Player) {
                if (employees.get(i).getName().equalsIgnoreCase(name)) {

                    for (int j = 0; j < teams[team].getPlayers().length; j++) {
                        if (teams[team].getPlayers()[j] == null) {
                            teams[team].getPlayers()[j] = (Player) employees.get(i);
                            add = "El jugador se añadio correctamente.";
                            j = teams[team].getPlayers().length;
                            i = employees.size();
                        } else {
                            add = "No se pudo agregar el jugador, no hay cupos en el equipo.";
                        }
                    }

                } else {
                    add = "El trabajador no se encuentra registrado.";
                }

            } else if (employees.get(i) instanceof MainCoach) {
                if (employees.get(i).getName().equalsIgnoreCase(name)) {

                    if (teams[team].getMainCoach() == null) {
                        teams[team].setMainCoach((MainCoach) employees.get(i));
                        add = "El entrenador se añadio correctamente.";
                        i = employees.size();
                    } else {

                        add = "El equipo ya tiene entrenador principal.";
                    }
                } else {
                    add = "El trabajador no se encuentra registrado.";
                }

            } else if (employees.get(i) instanceof AssistantCoach) {
                if (employees.get(i).getName().equalsIgnoreCase(name)) {

                    for (int j = 0; j < teams[team].getAssistantCoachs().length; j++) {
                        if (teams[team].getAssistantCoachs()[j] == null) {
                            teams[team].getAssistantCoachs()[j] = (AssistantCoach) employees.get(i);
                            add = "El entrenador asistente se añadio correctamente.";
                            j = teams[team].getAssistantCoachs().length;
                            i = employees.size();
                        } else {
                            add = "El equipo ya tiene entrenadores asistentes.";
                        }
                    }

                } else {
                    add = "El trabajador no se encuentra registrado.";
                }
            }
        }

        return add;
    }

    public String addLineUp(int team, String date, int tactic, String formation) {
        String add = "";

        teams[team].addLineUp(date, tactic, formation);
        add = "Se añadio la formacion.";

        return add;
    }

    public String showTeamInfo() {
        String info = "";

        for (int i = 0; i < teams.length; i++) {
            info += teams[i].showInfo();
        }

        return info;
    }

    public void upDateEmployeeInfo(int employee, int shirtNumber, int goalsNumbers, double averageMark, int position, int salary, boolean status) {
        Player player = (Player) employees.get(employee);
        player.setShirtNumber(shirtNumber);
        player.setGoalsNumbers(goalsNumbers);
        player.setAverageMark(salary);
        player.setPosition(date);
        player.setSalary(salary);
        player.setStatus(status);
        employees.remove(employee);
        employees.add(employee, player);
    }

    public void upDateEmployeeInfo(int employee, int teamsInCharge, int numberChampionships, int yearsExperience, int salary, boolean status) {
        MainCoach main = (MainCoach) employees.get(employee);
        main.setTeamsInCharge(teamsInCharge);
        main.setNumberChampionships(numberChampionships);
        main.setYearsExperience(yearsExperience);
        main.setSalary(salary);
        main.setSalary(salary);
        employees.remove(employee);
        employees.add(employee, main);
    }

    public void upDateEmployeeInfo(int employee, boolean wasPlayer, String expertise, int yearsExperience, int salary, boolean status) {
        AssistantCoach assistant = (AssistantCoach) employees.get(employee);
        assistant.setWasPlayer(wasPlayer);
        assistant.setExpertise(expertise);
        assistant.setYearsExperience(yearsExperience);
        assistant.setSalary(salary);
        assistant.setSalary(salary);
        employees.remove(employee);
        employees.add(employee, assistant);
    }

    public String addToDressingRoomA(int player) {

        int cont = 0;
        String add = "";
        for (int i = 0; i < dressingRoomA.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < dressingRoomA[0].length; j += 2) {
                    if (dressingRoomA[i][j] == null) {
                        dressingRoomA[i][j] = teams[0].getPlayers()[player];
                        add = "Se añadio correctamente.";
                        i = dressingRoomA.length;
                        j = dressingRoomA[0].length;
                    }
                }
            } else {
                for (int j = 1; j < dressingRoomA[0].length; j += 2) {
                    if (dressingRoomA[i][j] == null) {
                        dressingRoomA[i][j] = teams[0].getPlayers()[player];
                        add = "Se añadio correctamente.";
                        i = dressingRoomA.length;
                        j = dressingRoomA[0].length;

                    } else {
                        cont++;
                        if (cont == 3) {
                            i++;
                        }

                    }
                }
            }
        }
        return add;
    }

    public String addToDressingRoomB(int player) {
        String add = "";
        int cont = 0;
        int cont2 = 0;
        for (int i = 0; i < dressingRoomB.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < dressingRoomB[0].length; j += 2) {
                    if (dressingRoomB[i][j] == null) {
                        dressingRoomB[i][j] = teams[1].getPlayers()[player];
                        add = "Se agrego correctamente.";
                        i = dressingRoomB.length;
                        j = dressingRoomB[0].length;
                    } else {
                        cont2++;
                        if (cont2 == 3) {
                            i++;
                        }
                    }
                }
            } else {
                for (int j = 1; j < dressingRoomB[0].length; j += 2) {
                    if (dressingRoomB[i][j] == null) {
                        dressingRoomB[i][j] = teams[1].getPlayers()[player];
                        add = "Se agrego correctamente.";
                        i = dressingRoomB.length;
                        j = dressingRoomB[0].length;
                    } else {
                        cont++;
                        if (cont == 3) {
                            i++;
                        }

                    }
                }
            }
        }
        return add;
    }

    public String addToOfficeSector(String coach) {
        String add = "";
        int cont = 0;
        int cont2 = 0;
        int ind = 0;

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(coach)) {
                ind = i;
            }
        }

        for (int i = 0; i < officeSector.length; i++) {

            if (i % 2 == 0) {
                for (int j = 0; j < officeSector[0].length; j += 2) {
                    if (officeSector[i][j] == null) {
                        officeSector[i][j] = (Coach) employees.get(ind);
                        add = "Se añadio correctamente.";
                        i = officeSector.length;
                        j = officeSector[0].length;
                    } else {
                        cont2++;
                        if (cont2 == 3) {
                            i++;
                        }
                    }
                }
            } else {
                for (int j = 1; j < officeSector[0].length; j += 2) {
                    if (officeSector[i][j] == null) {
                        officeSector[i][j] = (Coach) employees.get(ind);
                        add = "Se añadio correctamente.";
                        i = officeSector.length;
                        j = officeSector[0].length;
                    } else {
                        cont++;
                        if (cont == 3) {
                            i++;
                        }

                    }
                }
            }
        }
        return add;
    }

    public String showDresingRoomInfo() {

        String info = "";
        info += "*************************\n";
        info += "Vestidor del equipo Newpi\n";
        info += "*************************\n";
        for (int i = 0; i < dressingRoomA.length; i++) {
            info += "     ";
            for (int j = 0; j < dressingRoomA[0].length; j++) {
                if (dressingRoomA[i][j] != null) {
                    info += 1;
                } else {
                    info += 0;
                }
            }
            info += "\n";
        }
        info += "\n";
        info += "***************************\n";
        info += "Vestidor del equipo NewTeam\n";
        info += "***************************\n";

        for (int i = 0; i < dressingRoomB.length; i++) {
            info += "     ";
            for (int j = 0; j < dressingRoomB[0].length; j++) {
                if (dressingRoomB[i][j] != null) {
                    info += 1;
                } else {
                    info += 0;
                }
            }
            info += "\n";
        }

        return info;
    }

    public String showOfficeSector() {

        String info = "";
        info += "******************\n";
        info += "Sector de oficinas\n";
        info += "******************\n";
        for (int i = 0; i < officeSector.length; i++) {
            info += "      ";
            for (int j = 0; j < officeSector[0].length; j++) {
                if (officeSector[i][j] != null) {
                    info += 1;
                } else {
                    info += 0;
                }
            }
            info += "\n";
        }

        return info;
    }

    public String showClubInfo() {
        String info = "";

        info += showEmployeeInfo();
        info += showTeamInfo();
        info += showDresingRoomInfo();
        info += showOfficeSector();

        return info;
    }
    
    public String findPlayer(String name){
        String find = "";
        int ind = -1;
        int jnd = -1;
        boolean findTrue = false;
        
        find = "El jugador " + name + " esta ubicado en el vestidor A en el espacio encerrado.\n";
        for(int i = 0; i < dressingRoomA.length; i++){
            for(int j = 0; j < dressingRoomA[0].length; j++){
                if(dressingRoomA[i][j] != null){
                    if(dressingRoomA[i][j].getName().equals(name)){
                        ind = i;
                        jnd = j;
                        findTrue = true;
                    }
                }
            }
        }

        for (int i = 0; i < dressingRoomA.length; i++) {
            for (int j = 0; j < dressingRoomA[0].length; j++) {
                if (dressingRoomA[i][j] != null) {

                    find += (findTrue && i == ind && j == jnd)?"[1]":1;
                } else {
                    find += 0;
                }
            }
            find += "\n";
        }
        
        if(ind != 0 && jnd != 0){
            find = "El jugador " + name + " esta ubicado en el vestidor B en el espacio cerrado.\n";
            for(int i = 0; i < dressingRoomB.length; i++){
                for(int j = 0; j < dressingRoomB[0].length; j++){
                    if(dressingRoomB[i][j] != null){
                        if(dressingRoomB[i][j].getName().equals(name)){
                            ind = i;
                            jnd = j;
                            findTrue = true;
                        }
                    }
                }
            }

            for (int i = 0; i < dressingRoomB.length; i++) {
                for (int j = 0; j < dressingRoomB[0].length; j++) {
                    if (dressingRoomB[i][j] != null) {                      
                        find += (findTrue && i == ind && j == jnd)?"[1]":1;
                    } else {
                        find += 0;
                    }
                }
                find += "\n";
            }
        }
        return find;
    }
    
    public String findCoach(String name){
        String find = "";
        int ind = -1;
        int jnd = -1;
        boolean findTrue = false;
        
        find = "El entrenador " + name + " esta ubicado en el vestidor A en el espacio encerrado.\n";
        for(int i = 0; i < officeSector.length; i++){
            for(int j = 0; j < officeSector[0].length; j++){
                if(officeSector[i][j] != null){
                    if(officeSector[i][j].getName().equals(name)){
                        ind = i;
                        jnd = j;
                        findTrue = true;
                    }
                }
            }
        }

        for (int i = 0; i < officeSector.length; i++) {
            for (int j = 0; j < officeSector[0].length; j++) {
                if (officeSector[i][j] != null) {

                    find += (findTrue && i == ind && j == jnd)?"[1]":1;
                } else {
                    find += 0;
                }
            }
            find += "\n";
        }
        
        return find;
    }
	 public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public Coach[][] getOfficeSector() {
        return officeSector;
    }

    public void setOfficeSector(Coach[][] officeSector) {
        this.officeSector = officeSector;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public Player[][] getDressinRoomA() {
        return dressingRoomA;
    }

    public void setDressinRoomA(Player[][] dressinRoomA) {
        this.dressingRoomA = dressinRoomA;
    }

    public Player[][] getDressinRoomB() {
        return dressingRoomB;
    }

    public void setDressinRoomB(Player[][] dressinRoomB) {
        this.dressingRoomB = dressinRoomB;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}



