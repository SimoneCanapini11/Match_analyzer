package application.model.dao.demo;

import java.util.HashMap;
import java.util.List;
import java.util.*;

import application.model.bean.Footballer;
import application.model.bean.RoleFootballer;
import application.model.dao.FootballerDAO;

public class DemoFootballerDAO implements FootballerDAO  {
	// Mappa che associa il nome della squadra alla lista dei giocatori
    private Map<String, List<Footballer>> teamPlayers;
    
    public DemoFootballerDAO() {
        teamPlayers = new HashMap<>();
        initializeData();
    }
	
    // Metodo per inizializzare i dati demo
    private void initializeData() {
    	// Inter
        List<Footballer> interPlayers = new ArrayList<>();
        final String TEAM_NAME_INTER = "Inter";
        
        Footballer player1 = new Footballer("Yann", "Sommer", TEAM_NAME_INTER, 36, 87, 100, 75, 1);
        player1.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player1);
        
        Footballer player3 = new Footballer("Alessandro", "Bastoni", TEAM_NAME_INTER, 25, 87, 100, 75, 1);
        player3.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player3);
        
        Footballer player5 = new Footballer("Stefan", "De Vrij", TEAM_NAME_INTER, 33, 83, 100, 75, 1);
        player5.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player5);
        
        Footballer player4 = new Footballer("Benjamin", "Pavard", TEAM_NAME_INTER, 28, 84, 100, 75, 1);
        player4.addRoleAffinity(RoleFootballer.CB, 1.0);
        player4.addRoleAffinity(RoleFootballer.RB, 0.7);
        interPlayers.add(player4);
        
        Footballer player11 = new Footballer("Hakan", "Calhanoglu", TEAM_NAME_INTER, 31, 86, 100, 75, 1);
        player11.addRoleAffinity(RoleFootballer.CM, 0.7);
        player11.addRoleAffinity(RoleFootballer.CDM, 1.0);
        interPlayers.add(player11);
        
        Footballer player14 = new Footballer("Piotr", "Zielinski", TEAM_NAME_INTER, 30, 83, 100, 75, 1);
        player14.addRoleAffinity(RoleFootballer.CM, 1.0);
        player14.addRoleAffinity(RoleFootballer.CAM, 0.7);
        interPlayers.add(player14);
        
        Footballer player12 = new Footballer("Nicolo", "Barella", TEAM_NAME_INTER, 28, 87, 100, 75, 1);
        player12.addRoleAffinity(RoleFootballer.CM, 1.0);
        player12.addRoleAffinity(RoleFootballer.CDM, 0.7);
        interPlayers.add(player12);
        
        Footballer player7 = new Footballer("Federico", "Di Marco", TEAM_NAME_INTER, 27, 84, 100, 75, 1);
        player7.addRoleAffinity(RoleFootballer.CB, 0.5);
        player7.addRoleAffinity(RoleFootballer.LB, 0.8);
        player7.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player7);
        
        Footballer player9 = new Footballer("Denzel", "Dumfries", TEAM_NAME_INTER, 28, 82, 100, 75, 1);
        player9.addRoleAffinity(RoleFootballer.RB, 0.8);
        player9.addRoleAffinity(RoleFootballer.RM, 1.0);
        interPlayers.add(player9);
        
        Footballer player15 = new Footballer("Lautaro", "Martinez", TEAM_NAME_INTER, 27, 89, 100, 75, 1);
        player15.addRoleAffinity(RoleFootballer.ST, 1.0);
        interPlayers.add(player15);
        
        Footballer player16 = new Footballer("Marcus", "Thuram", TEAM_NAME_INTER, 27, 86, 100, 75, 1);
        player16.addRoleAffinity(RoleFootballer.ST, 1.0);
        player16.addRoleAffinity(RoleFootballer.LW, 0.7);
        player16.addRoleAffinity(RoleFootballer.RW, 0.5);
        interPlayers.add(player16);
   
        Footballer player2 = new Footballer("Josep", "Martinez", TEAM_NAME_INTER, 26, 75, 100, 75, 1);
        player2.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player2);
  
        Footballer player6 = new Footballer("Francesco", "Acerbi", TEAM_NAME_INTER, 37, 84, 100, 75, 1);
        player6.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player6);
      
        Footballer player8 = new Footballer("Carlos", "Augusto", TEAM_NAME_INTER, 26, 79, 100, 75, 1);
        player8.addRoleAffinity(RoleFootballer.CB, 0.5);
        player8.addRoleAffinity(RoleFootballer.LB, 0.8);
        player8.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player8);
     
        Footballer player10 = new Footballer("Matteo", "Darmian", TEAM_NAME_INTER, 35, 81, 100, 75, 1);
        player10.addRoleAffinity(RoleFootballer.RB, 1.0);
        player10.addRoleAffinity(RoleFootballer.RM, 0.7);
        player10.addRoleAffinity(RoleFootballer.CB, 0.7);
        interPlayers.add(player10);
       
        Footballer player13 = new Footballer("Davide", "Frattesi", TEAM_NAME_INTER, 25, 81, 100, 75, 1);
        player13.addRoleAffinity(RoleFootballer.CM, 1.0);
        interPlayers.add(player13);
      
        Footballer player17 = new Footballer("Marko", "Arnautovic", TEAM_NAME_INTER, 35, 80, 100, 75, 1);
        player17.addRoleAffinity(RoleFootballer.ST, 1.0);
        interPlayers.add(player17);
        
        teamPlayers.put(TEAM_NAME_INTER, interPlayers);
        
        
        // Juventus
        List<Footballer> juventusPlayers = new ArrayList<>();
        final String TEAM_NAME_JUVE = "Juventus";
        
        Footballer player18 = new Footballer("Michele", "Di Gregorio", TEAM_NAME_JUVE, 27, 80, 100, 75, 1);
        player18.addRoleAffinity(RoleFootballer.GK, 1.0);
        juventusPlayers.add(player18);
        
        Footballer player20 = new Footballer("Andrea", "Cambiaso", TEAM_NAME_JUVE, 25, 77, 100, 75, 1);
        player20.addRoleAffinity(RoleFootballer.RB, 0.7);
        player20.addRoleAffinity(RoleFootballer.RM, 0.7);
        player20.addRoleAffinity(RoleFootballer.LB, 1.0);
        juventusPlayers.add(player20);
        
        Footballer player22 = new Footballer("Gleison", "Bremer", TEAM_NAME_JUVE, 27, 86, 100, 75, 1);
        player22.addRoleAffinity(RoleFootballer.CB, 1.0);
        juventusPlayers.add(player22);
        
        Footballer player23 = new Footballer("Federico", "Gatti", TEAM_NAME_JUVE, 26, 78, 100, 75, 1);
        player23.addRoleAffinity(RoleFootballer.CB, 1.0);
        juventusPlayers.add(player23);
        
        Footballer player26 = new Footballer("Timothy", "Weah", TEAM_NAME_JUVE, 25, 77, 100, 75, 1);
        player26.addRoleAffinity(RoleFootballer.RW, 0.7);
        player26.addRoleAffinity(RoleFootballer.RM, 0.7);
        player26.addRoleAffinity(RoleFootballer.RB, 1.0);
        juventusPlayers.add(player26);
        
        Footballer player28 = new Footballer("Manuel", "Locatelli", TEAM_NAME_JUVE, 27, 83, 100, 75, 1);
        player28.addRoleAffinity(RoleFootballer.CDM, 1.0);
        player28.addRoleAffinity(RoleFootballer.CM, 0.7);
        juventusPlayers.add(player28);
        
        Footballer player29 = new Footballer("Khephren", "Thuram", TEAM_NAME_JUVE, 23, 80, 100, 75, 1);
        player29.addRoleAffinity(RoleFootballer.CM, 1.0);
        player29.addRoleAffinity(RoleFootballer.CDM, 0.7);
        juventusPlayers.add(player29);
        
        Footballer player30 = new Footballer("Teun", "Koopmeiners", TEAM_NAME_JUVE, 27, 83, 100, 75, 1);
        player30.addRoleAffinity(RoleFootballer.CM, 1.0);
        player30.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player30.addRoleAffinity(RoleFootballer.CAM, 0.7);
        juventusPlayers.add(player30);
        
        Footballer player32 = new Footballer("Nico", "Gonzalez", TEAM_NAME_JUVE, 26, 80, 100, 75, 1);
        player32.addRoleAffinity(RoleFootballer.LW, 1.0);
        player32.addRoleAffinity(RoleFootballer.LM, 1.0);
        player32.addRoleAffinity(RoleFootballer.RW, 0.7);
        juventusPlayers.add(player32);
        
        Footballer player31 = new Footballer("Kenan", "Yildiz", TEAM_NAME_JUVE, 19, 79, 100, 75, 1);
        player31.addRoleAffinity(RoleFootballer.RW, 1.0);
        player31.addRoleAffinity(RoleFootballer.RM, 1.0);
        player31.addRoleAffinity(RoleFootballer.CAM, 0.5);
        player31.addRoleAffinity(RoleFootballer.LW, 0.7);
        juventusPlayers.add(player31);
        
        Footballer player34 = new Footballer("Dusan", "Vlahovic", TEAM_NAME_JUVE, 25, 84, 100, 75, 1);
        player34.addRoleAffinity(RoleFootballer.ST, 1.0);
        juventusPlayers.add(player34);
        
        Footballer player19 = new Footballer("Mattia", "Perin", TEAM_NAME_JUVE, 32, 79, 100, 75, 1);
        player19.addRoleAffinity(RoleFootballer.GK, 1.0);
        juventusPlayers.add(player19);
        
        Footballer player21 = new Footballer("Juan", "Cabal", TEAM_NAME_JUVE, 24, 74, 100, 75, 1);
        player21.addRoleAffinity(RoleFootballer.CB, 0.7);
        player21.addRoleAffinity(RoleFootballer.LB, 1.0);
        juventusPlayers.add(player21);
        
        Footballer player24 = new Footballer("Pierre", "Kalulu", TEAM_NAME_JUVE, 24, 79, 100, 75, 1);
        player24.addRoleAffinity(RoleFootballer.CB, 0.7);
        player24.addRoleAffinity(RoleFootballer.RB, 1.0);
        juventusPlayers.add(player24);
        
        Footballer player25 = new Footballer("Lloyd", "Kelly", TEAM_NAME_JUVE, 26, 77, 100, 75, 1);
        player25.addRoleAffinity(RoleFootballer.CB, 1.0);
        player25.addRoleAffinity(RoleFootballer.RB, 0.7);
        juventusPlayers.add(player25);
       
        Footballer player27 = new Footballer("Douglas", "Luiz", TEAM_NAME_JUVE, 26, 82, 100, 75, 1);
        player27.addRoleAffinity(RoleFootballer.CDM, 1.0);
        player27.addRoleAffinity(RoleFootballer.CM, 0.7);
        juventusPlayers.add(player27);
   
        Footballer player33 = new Footballer("Francisco", "Conceicao", TEAM_NAME_JUVE, 22, 75, 100, 75, 1);
        player33.addRoleAffinity(RoleFootballer.LW, 0.7);
        player33.addRoleAffinity(RoleFootballer.RW, 1.0);
        juventusPlayers.add(player33);
     
        Footballer player35 = new Footballer("Randal", "Kolo Muani", TEAM_NAME_JUVE, 26, 82, 100, 75, 1);
        player35.addRoleAffinity(RoleFootballer.ST, 1.0);
        player33.addRoleAffinity(RoleFootballer.LW, 0.7);
        player33.addRoleAffinity(RoleFootballer.RW, 0.7);
        juventusPlayers.add(player35);
        
        teamPlayers.put(TEAM_NAME_JUVE, juventusPlayers);
        
        
        // Milan
        List<Footballer> milanPlayers = new ArrayList<>();
        final String TEAM_NAME_MILAN = "Milan";
        
        Footballer player36 = new Footballer("Mike", "Maignan", TEAM_NAME_MILAN, 29, 87, 100, 75, 1);
        player36.addRoleAffinity(RoleFootballer.GK, 1.0);
        milanPlayers.add(player36);
        
        Footballer player37 = new Footballer("Theo", "Hernandez", TEAM_NAME_MILAN, 27, 87, 100, 75, 1);
        player37.addRoleAffinity(RoleFootballer.LB, 1.0);
        player37.addRoleAffinity(RoleFootballer.LM, 0.7);
        milanPlayers.add(player37);
        
        Footballer player38 = new Footballer("Strahinja", "Pavlovic", TEAM_NAME_MILAN, 23, 77, 100, 75, 1);
        player38.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player38);
        
        Footballer player39 = new Footballer("Matteo", "Gabbia", TEAM_NAME_MILAN, 25, 77, 100, 75, 1);
        player39.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player39);

        Footballer player40 = new Footballer("Kyle", "Walker", TEAM_NAME_MILAN, 34, 84, 100, 75, 1);
        player40.addRoleAffinity(RoleFootballer.CB, 0.5);
        player40.addRoleAffinity(RoleFootballer.RB, 1.0);
        milanPlayers.add(player40);
        
        Footballer player41 = new Footballer("Youssouf", "Fofana", TEAM_NAME_MILAN, 26, 81, 100, 75, 1);
        player41.addRoleAffinity(RoleFootballer.CM, 0.5);
        player41.addRoleAffinity(RoleFootballer.CDM, 1.0);
        milanPlayers.add(player41);
        
        Footballer player42 = new Footballer("Tijjani", "Reijnders", TEAM_NAME_MILAN, 26, 82, 100, 75, 1);
        player42.addRoleAffinity(RoleFootballer.CM, 1.0);
        player42.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player42.addRoleAffinity(RoleFootballer.CAM, 0.7);
        milanPlayers.add(player42);
        
        Footballer player43 = new Footballer("Yunus", "Musah", TEAM_NAME_MILAN, 22, 75, 100, 75, 1);
        player43.addRoleAffinity(RoleFootballer.CM, 1.0);
        milanPlayers.add(player43);
        
        Footballer player44 = new Footballer("Rafael", "Leao", TEAM_NAME_MILAN, 25, 87, 100, 75, 1);
        player44.addRoleAffinity(RoleFootballer.LM, 0.7);
        player44.addRoleAffinity(RoleFootballer.LW, 1.0);
        milanPlayers.add(player44);
        
        Footballer player45 = new Footballer("Christian", "Pulisic", TEAM_NAME_MILAN, 26, 83, 100, 75, 1);
        player45.addRoleAffinity(RoleFootballer.RM, 0.7);
        player45.addRoleAffinity(RoleFootballer.RW, 1.0);
        milanPlayers.add(player45);
        
        Footballer player46 = new Footballer("Santiago", "Gimenez", TEAM_NAME_MILAN, 23, 81, 100, 75, 1);
        player46.addRoleAffinity(RoleFootballer.ST, 1.0);
        milanPlayers.add(player46);
        
        Footballer player47 = new Footballer("Marco", "Sportiello", TEAM_NAME_MILAN, 32, 75, 100, 75, 1);
        player47.addRoleAffinity(RoleFootballer.GK, 1.0);
        milanPlayers.add(player47);
        
        Footballer player48 = new Footballer("Fikayo", "Tomori", TEAM_NAME_MILAN, 27, 83, 100, 75, 1);
        player48.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player48);
        
        Footballer player49 = new Footballer("Emerson", "Royale", TEAM_NAME_MILAN, 26, 76, 100, 75, 1);
        player49.addRoleAffinity(RoleFootballer.LB, 1.0);
        player49.addRoleAffinity(RoleFootballer.LM, 0.7);
        milanPlayers.add(player49);
        
        Footballer player50 = new Footballer("Ruben", "Loftus-Cheek", TEAM_NAME_MILAN, 29, 81, 100, 75, 1);
        player50.addRoleAffinity(RoleFootballer.CM, 1.0);
        player50.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player50.addRoleAffinity(RoleFootballer.CAM, 0.7);
        milanPlayers.add(player50);
        
        Footballer player51 = new Footballer("Joao", "Felix", TEAM_NAME_MILAN, 25, 83, 100, 75, 1);
        player51.addRoleAffinity(RoleFootballer.ST, 0.7);
        player51.addRoleAffinity(RoleFootballer.LW, 0.5);
        player51.addRoleAffinity(RoleFootballer.CAM, 1.0);
        milanPlayers.add(player51);
        
        Footballer player52 = new Footballer("Samuel", "Chukwueze", TEAM_NAME_MILAN, 25, 80, 100, 75, 1);
        player52.addRoleAffinity(RoleFootballer.RW, 1.0);
        player52.addRoleAffinity(RoleFootballer.LW, 0.7);
        player52.addRoleAffinity(RoleFootballer.RM, 0.5);
        player52.addRoleAffinity(RoleFootballer.LM, 0.5);
        milanPlayers.add(player52);
        
        teamPlayers.put(TEAM_NAME_MILAN, milanPlayers);
        
    }
    
    
    
	@Override
    public List<Footballer> getFootballersByTeam(String teamName) {
        // Se non esiste la squadra, restituisce una lista vuota
        return teamPlayers.getOrDefault(teamName, new ArrayList<>());
    }
	
}
