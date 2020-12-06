package ui;

import model.*;
import java.util.Scanner;

public class Menu {
    
    private Scanner in;
    private Scanner sc;
    private Club start;
    
    public Menu() {
        in = new Scanner(System.in);
        sc = new Scanner(System.in);
        start = new Club();
    }
    
    public void contractEmployee(){
        String name = "", ID = "";
        int salary = 0, yearsEsperience = 0;
        boolean status = false;
        
        System.out.println("¿Que tipo de empleado desea contratar?");
        System.out.println("1. Jugador.\n2.Entrenador principal.\n3.Entrenador secundario.");
        int ind = in.nextInt();
        switch(ind){
            case 1:
                System.out.println("Del jugador digite: ");
                System.out.print("Nombre: ");
                name = sc.nextLine();
                System.out.print("Identificacion: ");
                ID = sc.nextLine();
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.print("Numero de camiseta: ");
                int shirtNumber = in.nextInt();
                System.out.print("Goles que ha marcado: ");
                int goalsNumbers = in.nextInt();
                System.out.print("Calificacion promedio: ");
                double averageMark = in.nextDouble();
                System.out.println("Posicion en el terreno: ");
                System.out.println("1. Portero\n2. Defensor\n3. Volante\n4. Delantero");
                int position = in.nextInt() - 1;
                System.out.println(start.contractEmployee(shirtNumber, goalsNumbers, averageMark, position, name, ID, salary, status));
                break;
                
            case 2:
                System.out.println("Del entrenador principal digite: ");
                System.out.print("Nombre: ");
                name = sc.nextLine();
                System.out.print("Identificacion: ");
                ID = sc.nextLine();
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.print("Equipos que tuvo a cargo: ");
                int teamInCharge = in.nextInt();
                System.out.print("Campeonatos conseguidos: ");
                int numberShampionships = in.nextInt();
                System.out.print("Años de experiencia: ");
                yearsEsperience = in.nextInt();
                System.out.println(start.contractEmployee(teamInCharge, numberShampionships, yearsEsperience, name, ID, salary, status));
                break;
                
            case 3:
                
                System.out.println("Del entrenador asistente digite: ");
                System.out.print("Nombre: ");
                name = sc.nextLine();
                System.out.print("Identificacion: ");
                ID = sc.nextLine();
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.println("Fue jugador profesional: ");
                System.out.println("1. Si\n2. No");
                int was = in.nextInt();
                boolean wasPlayer = (was == 1);
                System.out.println("Experticia: ");
                System.out.println("1. Ofensivo\n2. Posesion\n3. Jugadas de laboratorio");
                int expertise = in.nextInt() - 1;
                System.out.print("Años de experiencia: ");
                yearsEsperience = in.nextInt();
                System.out.println(start.contractEmployee(wasPlayer, expertise, yearsEsperience, name, ID, salary, status));
                break;
        }
    }
    
    public void dismissEmployee(){
        System.out.println("Digite el nombre del empleado: ");
        String name = sc.nextLine();
        System.out.println(start.dismissEmployee(name));
    }
    
    public void addEmployeeToTeam(){
        System.out.println("Del empleado digita: ");
        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.println("Equipo: ");
        System.out.println("1. R.Madrid A\n2. R.Madrid B");
        int team = in.nextInt() - 1;
        System.out.println(start.addEmployeeToTeam(name, team));
    }
	public void showOfficeSector(){
        System.out.println(start.showOfficeSector());
    }
    
    public void showDresingRoomInfo(){
        System.out.println(start.showDresingRoomInfo());
    }
    
    public void showClubInfo(){
        System.out.println(start.showClubInfo());
    }
    
    public void findPlayer(){
        System.out.print("Digite el nombre del jugador: ");
        String name = sc.nextLine();
        
        System.out.println(start.findPlayer(name));
    }
    
    public void findCoach(){
        System.out.println("Digite el nombre del entrenador: ");
        String name = sc.nextLine();
        
        System.out.println(start.findCoach(name));
    }
    
    public void upDateEmployeeInfo(){
        
        int salary = 0, yearsEsperience = 0;
        boolean status = false;
        
        System.out.println("Selecciona el empleado al que deseas actualizar informacion:");
        for(int i = 0; i < start.getEmployees().size(); i++){
            System.out.println((i + 1)+ ". " + start.getEmployees().get(i).getName());
        }
        int employee = in.nextInt()-1;
        
        System.out.println("Seleccion el tipo de empleado que corresponde: ");
        System.out.println("1. Jugador\n2. Entrenador principal\n3.Entrenador secundario");
        int typeEmployee = in.nextInt();
        
        switch(typeEmployee){
            case 1:
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.print("Numero de camiseta: ");
                int shirtNumber = in.nextInt();
                System.out.print("Goles que ha marcado: ");
                int goalsNumbers = in.nextInt();
                System.out.print("Calificacion promedio: ");
                double averageMark = in.nextDouble();
                System.out.println("Posicion en el terreno: ");
                System.out.println("1. Portero\n2. Defensor\n3. Volante\n4. Delantero");
                int position = in.nextInt() - 1;
                start.upDateEmployeeInfo(employee, shirtNumber, goalsNumbers, averageMark, position, salary, status);
                break;
                
            case 2:
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.print("Equipos que tuvo a cargo: ");
                int teamInCharge = in.nextInt();
                System.out.print("Campeonatos conseguidos: ");
                int numberShampionships = in.nextInt();
                System.out.print("Años de experiencia: ");
                yearsEsperience = in.nextInt();
                start.upDateEmployeeInfo(employee, teamInCharge, numberShampionships, yearsEsperience, salary, status);
                break;
                
            case 3:
                System.out.print("Salario: ");
                salary = in.nextInt();
                System.out.println("Estatus: ");
                System.out.println("1.Activo\n2.Inactivo");
                status = (in.nextInt() == 1);
                System.out.println("Fue jugador profesional: ");
                System.out.println("1. Si\n2. No");
                int was = in.nextInt();
                boolean wasPlayer = (was == 1);
                System.out.println("Experticia: ");
                System.out.println("1. Ofensivo\n2. Posesion\n3. Denfesivo \n4. Jugadas de laboratorio");
                int expe = in.nextInt() - 1;
                String expertise = "";
                if(expe == 1){
                    expertise = "Ofensivo";
                } else if(expe == 2){
                    expertise = "Posesion";
                } else if(expe == 3){
                    expertise = "Defensivo";
                } else if(expe == 4){
                    expertise = "Jugada de laboratorio";
                }
                System.out.print("Años de experiencia: ");
                yearsEsperience = in.nextInt();
                start.upDateEmployeeInfo(employee, wasPlayer, expertise, yearsEsperience, salary, status);
                break;
        }
    }
    
    public void showEmployeeInfo(){
    
        System.out.println(start.showEmployeeInfo());
    }
    
    public void showTeamInfo(){
        System.out.println(start.showTeamInfo());
    }
    
    public void addLineUp(){
        System.out.println("digita para la alineacion: ");
        System.out.println("Equipo: ");
        System.out.println("1. R.Madrid A\n2. R.Madrid B");
        int team = in.nextInt() - 1;
        System.out.print("Fecha de creacion: ");
        String date = sc.nextLine();
        System.out.println("Tipo de tactica: ");
        System.out.println("1. Posesion\n2. Contra-ataque\n3. Presion alta\n4. Por defecto");
        int tactic = in.nextInt()-1;
        System.out.println("Formacion en formato N-N-N: ");
        String formation = sc.nextLine();
        System.out.println(start.addLineUp(team, date, tactic, formation));
    }
    
    public void addToOfficeSector(){
        System.out.print("Digita el nombre del entrenador: ");
        String name = sc.nextLine();
        start.addToOfficeSector(name);
    }
    
    public void addToDresingRoom(){
        System.out.println("digita para el jugador: ");
        System.out.println("Equipo: ");
        System.out.println("1.inferiorA\n2. R.Madrid");
        int team = in.nextInt();
        int player = 0;
        System.out.println("Selecciona el jugador: ");
        if(team == 1){
        
            for(int i = 0; i < start.getTeams()[0].getPlayers().length; i++){
                if(start.getTeams()[0].getPlayers()[i] != null){
                    System.out.println((i+1) + ". " + start.getTeams()[0].getPlayers()[i].getName());
                }
                
            }
            player = in.nextInt() - 1;  
            System.out.println(start.addToDressingRoomA(player));
        } else if(team == 2){
        
            for(int i = 0; i < start.getTeams()[1].getPlayers().length; i++){
                if(start.getTeams()[1].getPlayers()[i] != null){
                    System.out.println((i+1) + ". " + start.getTeams()[1].getPlayers()[i].getName());
                }
                
            }
            player = in.nextInt() -1;
            System.out.println(start.addToDressingRoomB(player));
        }
    }
    
    
    
    public void menu(){
        System.out.println("Bienvenido al club "  + start.getName());
        System.out.println("");
        int option = 0;
        while(option < 13){
        System.out.println("1. Contratar empleado\n2. Despedir empleado\n"
                + "3. Agregar empleado a equipo\n4. Actualizar informacion de los empleados\n" 
                + "5. Mostrar informacion de los empleados\n6. Mostrar informacion de los equipos\n"
                + "7. Agregar alineaciones a equipo\n8. Ubicar entrenador en oficina\n9. Ubicar jugador en vestidor\n" 
                + "10. Mostrar informacion del club\n11. Buscar entrenador en oficina\n12. Buscar jugador en vestidor\n" 
                + "13. Salir");
            option = in.nextInt();
        
        
            switch(option){
                case 1:
                    contractEmployee();
                    break;

                case 2:
                    dismissEmployee();
                    break;

                case 3:
                    addEmployeeToTeam();
                    break;

                case 4:
                    upDateEmployeeInfo();
                    break;

                case 5:
                    showEmployeeInfo();
                    break;

                case 6:
                    showTeamInfo();
                    break;

                case 7:
                    addLineUp();
                    break;

                case 8:
                    addToOfficeSector();
                    break;

                case 9:
                    addToDresingRoom();
                    break;

                case 10:
                    showClubInfo();
                    break;

                case 11:
                    findCoach();
                    break;
                    
                case 12:
                    findPlayer();
                    break;
                case 13:
                    System.out.println("Gracias por usar nuestro programa.");
                    break;
                default:
                    System.out.println("Por favor seleccione una de las opciones disponibles.");
                    break;
            }
        }
    }
}
