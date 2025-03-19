package application.model.dao.demo;

import java.util.HashMap;

import java.util.List;
import java.util.*;
import java.time.LocalDate;
import application.model.bean.Footballer;
import application.model.bean.FootballerAttributes;
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
        
        FootballerAttributes attributes1 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player1 = new Footballer("Yann", "Sommer", TEAM_NAME_INTER, LocalDate.of(1988, 12, 17), attributes1);
        player1.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player1);
        
        FootballerAttributes attributes2 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player3 = new Footballer("Alessandro", "Bastoni", TEAM_NAME_INTER, LocalDate.of(1999, 4, 13), attributes2);
        player3.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player3);
        
        FootballerAttributes attributes3 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player5 = new Footballer("Stefan", "De Vrij", TEAM_NAME_INTER, LocalDate.of(1992, 2, 5), attributes3);
        player5.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player5);  
        
        FootballerAttributes attributes4 = new FootballerAttributes(84, 100, 75, 1);
        Footballer player4 = new Footballer("Benjamin", "Pavard", TEAM_NAME_INTER, LocalDate.of(1996, 3, 28), attributes4);
        player4.addRoleAffinity(RoleFootballer.CB, 1.0);
        player4.addRoleAffinity(RoleFootballer.RB, 0.7);
        interPlayers.add(player4);
        
        FootballerAttributes attributes5 = new FootballerAttributes(86, 100, 75, 1);
        Footballer player11 = new Footballer("Hakan", "Calhanoglu", TEAM_NAME_INTER, LocalDate.of(1994, 2, 8), attributes5);
        player11.addRoleAffinity(RoleFootballer.CM, 0.7);
        player11.addRoleAffinity(RoleFootballer.CDM, 1.0);
        interPlayers.add(player11);
        
        FootballerAttributes attributes6 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player14 = new Footballer("Piotr", "Zielinski", TEAM_NAME_INTER, LocalDate.of(1994, 5, 20), attributes6);
        player14.addRoleAffinity(RoleFootballer.CM, 1.0);
        player14.addRoleAffinity(RoleFootballer.CAM, 0.7);
        interPlayers.add(player14);
        
        FootballerAttributes attributes7 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player12 = new Footballer("Nicolo", "Barella", TEAM_NAME_INTER, LocalDate.of(1997, 2, 7), attributes7);
        player12.addRoleAffinity(RoleFootballer.CM, 1.0);
        player12.addRoleAffinity(RoleFootballer.CDM, 0.7);
        interPlayers.add(player12);
        
        FootballerAttributes attributes8 = new FootballerAttributes(84, 100, 75, 1);
        Footballer player7 = new Footballer("Federico", "Di Marco", TEAM_NAME_INTER, LocalDate.of(1997, 11, 10), attributes8);
        player7.addRoleAffinity(RoleFootballer.CB, 0.5);
        player7.addRoleAffinity(RoleFootballer.LB, 0.8);
        player7.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player7);
        
        FootballerAttributes attributes9 = new FootballerAttributes(82, 100, 75, 1);
        Footballer player9 = new Footballer("Denzel", "Dumfries", TEAM_NAME_INTER, LocalDate.of(1996, 4, 18), attributes9);
        player9.addRoleAffinity(RoleFootballer.RB, 0.8);
        player9.addRoleAffinity(RoleFootballer.RM, 1.0);
        interPlayers.add(player9);
        
        FootballerAttributes attributes10 = new FootballerAttributes(89, 100, 75, 1);
        Footballer player15 = new Footballer("Lautaro", "Martinez", TEAM_NAME_INTER, LocalDate.of(1997, 8, 22), attributes10);
        player15.addRoleAffinity(RoleFootballer.ST, 1.0);
        player15.addRoleAffinity(RoleFootballer.LW, 0.4);
        player15.addRoleAffinity(RoleFootballer.RW, 0.3);
        interPlayers.add(player15);
        
        FootballerAttributes attributes11 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player16 = new Footballer("Marcus", "Thuram", TEAM_NAME_INTER, LocalDate.of(1997, 8, 6), attributes11);
        player16.addRoleAffinity(RoleFootballer.ST, 1.0);
        player16.addRoleAffinity(RoleFootballer.LW, 0.7);
        player16.addRoleAffinity(RoleFootballer.RW, 0.5);
        interPlayers.add(player16);
   
        FootballerAttributes attributes12 = new FootballerAttributes(75, 100, 75, 1);
        Footballer player2 = new Footballer("Josep", "Martinez", TEAM_NAME_INTER, LocalDate.of(1998, 5, 27), attributes12);
        player2.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player2);
  
        FootballerAttributes attributes13 = new FootballerAttributes(84, 100, 75, 1);
        Footballer player6 = new Footballer("Francesco", "Acerbi", TEAM_NAME_INTER, LocalDate.of(1988, 02, 10), attributes13);
        player6.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player6);
      
        FootballerAttributes attributes14 = new FootballerAttributes(79, 100, 75, 1);
        Footballer player8 = new Footballer("Carlos", "Augusto", TEAM_NAME_INTER, LocalDate.of(1999, 1, 7), attributes14);
        player8.addRoleAffinity(RoleFootballer.CB, 0.5);
        player8.addRoleAffinity(RoleFootballer.LB, 0.8);
        player8.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player8);
     
        FootballerAttributes attributes15 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player10 = new Footballer("Matteo", "Darmian", TEAM_NAME_INTER, LocalDate.of(1989, 12, 2), attributes15);
        player10.addRoleAffinity(RoleFootballer.RB, 1.0);
        player10.addRoleAffinity(RoleFootballer.RM, 0.5);
        player10.addRoleAffinity(RoleFootballer.CB, 0.7);
        interPlayers.add(player10);
       
        FootballerAttributes attributes16 = new FootballerAttributes(81, 100, 75, 1);
        Footballer player13 = new Footballer("Davide", "Frattesi", TEAM_NAME_INTER, LocalDate.of(1999, 9, 22), attributes16);
        player13.addRoleAffinity(RoleFootballer.CM, 1.0);
        interPlayers.add(player13);
      
        FootballerAttributes attributes17 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player17 = new Footballer("Marko", "Arnautovic", TEAM_NAME_INTER, LocalDate.of(1989, 4, 19), attributes17);
        player17.addRoleAffinity(RoleFootballer.ST, 1.0);
        player17.addRoleAffinity(RoleFootballer.LW, 0.4);
        player17.addRoleAffinity(RoleFootballer.RW, 0.3);
        interPlayers.add(player17);
        
        teamPlayers.put(TEAM_NAME_INTER, interPlayers);
        
        
        // Juventus
        List<Footballer> juventusPlayers = new ArrayList<>();
        final String TEAM_NAME_JUVE = "Juventus";
        
        FootballerAttributes attributes18 = new FootballerAttributes(80, 100, 75, 1);
        Footballer player18 = new Footballer("Michele", "Di Gregorio", TEAM_NAME_JUVE, LocalDate.of(1997, 7, 27), attributes18);
        player18.addRoleAffinity(RoleFootballer.GK, 1.0);
        juventusPlayers.add(player18);
        
        FootballerAttributes attributes19 = new FootballerAttributes(79, 100, 75, 1);
        Footballer player20 = new Footballer("Andrea", "Cambiaso", TEAM_NAME_JUVE, LocalDate.of(2000, 2, 20), attributes19);
        player20.addRoleAffinity(RoleFootballer.RB, 0.7);
        player20.addRoleAffinity(RoleFootballer.RM, 0.8);
        player20.addRoleAffinity(RoleFootballer.LB, 1.0);
        juventusPlayers.add(player20);
        
        FootballerAttributes attributes20 = new FootballerAttributes(86, 100, 75, 1);
        Footballer player22 = new Footballer("Gleison", "Bremer", TEAM_NAME_JUVE, LocalDate.of(1997, 3, 18), attributes20);
        player22.addRoleAffinity(RoleFootballer.CB, 1.0);
        juventusPlayers.add(player22);
        
        FootballerAttributes attributes21 = new FootballerAttributes(78, 100, 75, 1);
        Footballer player23 = new Footballer("Federico", "Gatti", TEAM_NAME_JUVE, LocalDate.of(1998, 6, 24), attributes21);
        player23.addRoleAffinity(RoleFootballer.CB, 1.0);
        juventusPlayers.add(player23);
        
        FootballerAttributes attributes22 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player26 = new Footballer("Timothy", "Weah", TEAM_NAME_JUVE, LocalDate.of(2000, 2, 22), attributes22);
        player26.addRoleAffinity(RoleFootballer.RW, 0.5);
        player26.addRoleAffinity(RoleFootballer.RM, 0.7);
        player26.addRoleAffinity(RoleFootballer.RB, 1.0);
        juventusPlayers.add(player26);
        
        FootballerAttributes attributes23 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player28 = new Footballer("Manuel", "Locatelli", TEAM_NAME_JUVE, LocalDate.of(1998, 1, 8), attributes23);
        player28.addRoleAffinity(RoleFootballer.CDM, 1.0);
        player28.addRoleAffinity(RoleFootballer.CM, 0.7);
        juventusPlayers.add(player28);
        
        FootballerAttributes attributes24 = new FootballerAttributes(80, 100, 75, 1);
        Footballer player29 = new Footballer("Khephren", "Thuram", TEAM_NAME_JUVE, LocalDate.of(2001, 3, 26), attributes24);
        player29.addRoleAffinity(RoleFootballer.CM, 1.0);
        player29.addRoleAffinity(RoleFootballer.CDM, 0.7);
        juventusPlayers.add(player29);
        
        FootballerAttributes attributes25 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player30 = new Footballer("Teun", "Koopmeiners", TEAM_NAME_JUVE, LocalDate.of(1998, 2, 28), attributes25);
        player30.addRoleAffinity(RoleFootballer.CM, 1.0);
        player30.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player30.addRoleAffinity(RoleFootballer.CAM, 0.7);
        juventusPlayers.add(player30);
        
        FootballerAttributes attributes26 = new FootballerAttributes(80, 100, 75, 1);
        Footballer player32 = new Footballer("Nico", "Gonzalez", TEAM_NAME_JUVE, LocalDate.of(1998, 4, 6), attributes26);
        player32.addRoleAffinity(RoleFootballer.LW, 1.0);
        player32.addRoleAffinity(RoleFootballer.LM, 0.9);
        player32.addRoleAffinity(RoleFootballer.RW, 0.7);
        juventusPlayers.add(player32);
        
        FootballerAttributes attributes27 = new FootballerAttributes(80, 100, 75, 1);
        Footballer player31 = new Footballer("Kenan", "Yildiz", TEAM_NAME_JUVE, LocalDate.of(2005, 5, 4), attributes27);
        player31.addRoleAffinity(RoleFootballer.RW, 1.0);
        player31.addRoleAffinity(RoleFootballer.RM, 0.9);
        player31.addRoleAffinity(RoleFootballer.CAM, 0.5);
        player31.addRoleAffinity(RoleFootballer.LW, 0.7);
        juventusPlayers.add(player31);
        
        FootballerAttributes attributes28 = new FootballerAttributes(84, 100, 75, 1);
        Footballer player34 = new Footballer("Dusan", "Vlahovic", TEAM_NAME_JUVE, LocalDate.of(2000, 1, 28), attributes28);
        player34.addRoleAffinity(RoleFootballer.ST, 1.0);
        juventusPlayers.add(player34);
        
        FootballerAttributes attributes29 = new FootballerAttributes(79, 100, 75, 1);
        Footballer player19 = new Footballer("Mattia", "Perin", TEAM_NAME_JUVE, LocalDate.of(1992, 11, 10), attributes29);
        player19.addRoleAffinity(RoleFootballer.GK, 1.0);
        juventusPlayers.add(player19);
        
        FootballerAttributes attributes30 = new FootballerAttributes(74, 100, 75, 1);
        Footballer player21 = new Footballer("Juan", "Cabal", TEAM_NAME_JUVE, LocalDate.of(2001, 1, 8), attributes30);
        player21.addRoleAffinity(RoleFootballer.CB, 0.7);
        player21.addRoleAffinity(RoleFootballer.LB, 1.0);
        juventusPlayers.add(player21);
        
        FootballerAttributes attributes31 = new FootballerAttributes(79, 100, 75, 1);
        Footballer player24 = new Footballer("Pierre", "Kalulu", TEAM_NAME_JUVE, LocalDate.of(2000, 6, 5), attributes31);
        player24.addRoleAffinity(RoleFootballer.CB, 0.7);
        player24.addRoleAffinity(RoleFootballer.RB, 1.0);
        juventusPlayers.add(player24);
        
        FootballerAttributes attributes32 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player25 = new Footballer("Lloyd", "Kelly", TEAM_NAME_JUVE, LocalDate.of(1998, 10, 6), attributes32);
        player25.addRoleAffinity(RoleFootballer.CB, 1.0);
        player25.addRoleAffinity(RoleFootballer.RB, 0.7);
        juventusPlayers.add(player25);
       
        FootballerAttributes attributes33 = new FootballerAttributes(82, 100, 75, 1);
        Footballer player27 = new Footballer("Douglas", "Luiz", TEAM_NAME_JUVE, LocalDate.of(1998, 5, 9), attributes33);
        player27.addRoleAffinity(RoleFootballer.CDM, 1.0);
        player27.addRoleAffinity(RoleFootballer.CM, 0.7);
        juventusPlayers.add(player27);
   
        FootballerAttributes attributes34 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player33 = new Footballer("Francisco", "Conceicao", TEAM_NAME_JUVE, LocalDate.of(2002, 12, 14), attributes34);
        player33.addRoleAffinity(RoleFootballer.LW, 0.7);
        player33.addRoleAffinity(RoleFootballer.RW, 1.0);
        juventusPlayers.add(player33);
     
        FootballerAttributes attributes35 = new FootballerAttributes(82, 100, 75, 1);
        Footballer player35 = new Footballer("Randal", "Kolo Muani", TEAM_NAME_JUVE, LocalDate.of(1998, 12, 5), attributes35);
        player35.addRoleAffinity(RoleFootballer.ST, 1.0);
        player33.addRoleAffinity(RoleFootballer.LW, 0.7);
        player33.addRoleAffinity(RoleFootballer.RW, 0.5);
        juventusPlayers.add(player35);
        
        teamPlayers.put(TEAM_NAME_JUVE, juventusPlayers);
        
        
        // Milan
        List<Footballer> milanPlayers = new ArrayList<>();
        final String TEAM_NAME_MILAN = "Milan";
        
        FootballerAttributes attributes36 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player36 = new Footballer("Mike", "Maignan", TEAM_NAME_MILAN, LocalDate.of(1995, 7, 3), attributes36);
        player36.addRoleAffinity(RoleFootballer.GK, 1.0);
        milanPlayers.add(player36);
        
        FootballerAttributes attributes37 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player37 = new Footballer("Theo", "Hernandez", TEAM_NAME_MILAN, LocalDate.of(1997, 10, 6), attributes37);
        player37.addRoleAffinity(RoleFootballer.LB, 1.0);
        player37.addRoleAffinity(RoleFootballer.LM, 0.7);
        milanPlayers.add(player37);
        
        FootballerAttributes attributes38 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player38 = new Footballer("Strahinja", "Pavlovic", TEAM_NAME_MILAN, LocalDate.of(2001, 5, 24), attributes38);
        player38.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player38);
        
        FootballerAttributes attributes39 = new FootballerAttributes(77, 100, 75, 1);
        Footballer player39 = new Footballer("Matteo", "Gabbia", TEAM_NAME_MILAN, LocalDate.of(1999, 10, 21), attributes39);
        player39.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player39);

        FootballerAttributes attributes40 = new FootballerAttributes(84, 100, 75, 1);
        Footballer player40 = new Footballer("Kyle", "Walker", TEAM_NAME_MILAN, LocalDate.of(1990, 5, 28), attributes40);
        player40.addRoleAffinity(RoleFootballer.CB, 0.5);
        player40.addRoleAffinity(RoleFootballer.RB, 1.0);
        milanPlayers.add(player40);
        
        FootballerAttributes attributes41 = new FootballerAttributes(81, 100, 75, 1);
        Footballer player41 = new Footballer("Youssouf", "Fofana", TEAM_NAME_MILAN, LocalDate.of(1999, 1, 10), attributes41);
        player41.addRoleAffinity(RoleFootballer.CM, 0.5);
        player41.addRoleAffinity(RoleFootballer.CDM, 1.0);
        milanPlayers.add(player41);
        
        FootballerAttributes attributes42 = new FootballerAttributes(82, 100, 75, 1);
        Footballer player42 = new Footballer("Tijjani", "Reijnders", TEAM_NAME_MILAN, LocalDate.of(1998, 7, 29), attributes42);
        player42.addRoleAffinity(RoleFootballer.CM, 1.0);
        player42.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player42.addRoleAffinity(RoleFootballer.CAM, 0.7);
        milanPlayers.add(player42);
        
        FootballerAttributes attributes43 = new FootballerAttributes(75, 100, 75, 1);
        Footballer player43 = new Footballer("Yunus", "Musah", TEAM_NAME_MILAN, LocalDate.of(2002, 11, 29), attributes43);
        player43.addRoleAffinity(RoleFootballer.CM, 1.0);
        milanPlayers.add(player43);
        
        FootballerAttributes attributes44 = new FootballerAttributes(87, 100, 75, 1);
        Footballer player44 = new Footballer("Rafael", "Leao", TEAM_NAME_MILAN, LocalDate.of(1999, 6, 10), attributes44);
        player44.addRoleAffinity(RoleFootballer.LM, 0.7);
        player44.addRoleAffinity(RoleFootballer.LW, 1.0);
        milanPlayers.add(player44);
        
        FootballerAttributes attributes45 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player45 = new Footballer("Christian", "Pulisic", TEAM_NAME_MILAN, LocalDate.of(1998, 9, 18), attributes45);
        player45.addRoleAffinity(RoleFootballer.RM, 0.7);
        player45.addRoleAffinity(RoleFootballer.RW, 1.0);
        milanPlayers.add(player45);
        
        FootballerAttributes attributes46 = new FootballerAttributes(81, 100, 75, 1);
        Footballer player46 = new Footballer("Santiago", "Gimenez", TEAM_NAME_MILAN, LocalDate.of(2001, 4, 18), attributes46);
        player46.addRoleAffinity(RoleFootballer.ST, 1.0);
        milanPlayers.add(player46);
        
        FootballerAttributes attributes47 = new FootballerAttributes(75, 100, 75, 1);
        Footballer player47 = new Footballer("Marco", "Sportiello", TEAM_NAME_MILAN, LocalDate.of(1992, 5, 10), attributes47);
        player47.addRoleAffinity(RoleFootballer.GK, 1.0);
        milanPlayers.add(player47);
        
        FootballerAttributes attributes48 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player48 = new Footballer("Fikayo", "Tomori", TEAM_NAME_MILAN, LocalDate.of(1997, 12, 19), attributes48);
        player48.addRoleAffinity(RoleFootballer.CB, 1.0);
        milanPlayers.add(player48);
        
        FootballerAttributes attributes49 = new FootballerAttributes(76, 100, 75, 1);
        Footballer player49 = new Footballer("Emerson", "Royale", TEAM_NAME_MILAN, LocalDate.of(1999, 1, 14), attributes49);
        player49.addRoleAffinity(RoleFootballer.LB, 1.0);
        player49.addRoleAffinity(RoleFootballer.LM, 0.7);
        milanPlayers.add(player49);
        
        FootballerAttributes attributes50 = new FootballerAttributes(81, 100, 75, 1);
        Footballer player50 = new Footballer("Ruben", "Loftus-Cheek", TEAM_NAME_MILAN, LocalDate.of(1996, 1, 23), attributes50);
        player50.addRoleAffinity(RoleFootballer.CM, 1.0);
        player50.addRoleAffinity(RoleFootballer.CDM, 0.5);
        player50.addRoleAffinity(RoleFootballer.CAM, 0.7);
        milanPlayers.add(player50);
        
        FootballerAttributes attributes51 = new FootballerAttributes(83, 100, 75, 1);
        Footballer player51 = new Footballer("Joao", "Felix", TEAM_NAME_MILAN, LocalDate.of(1999, 11, 10), attributes51);
        player51.addRoleAffinity(RoleFootballer.ST, 0.7);
        player51.addRoleAffinity(RoleFootballer.LW, 0.5);
        player51.addRoleAffinity(RoleFootballer.CAM, 1.0);
        milanPlayers.add(player51);
        
        FootballerAttributes attributes52 = new FootballerAttributes(80, 100, 75, 1);
        Footballer player52 = new Footballer("Samuel", "Chukwueze", TEAM_NAME_MILAN, LocalDate.of(1999, 5, 22), attributes52);
        player52.addRoleAffinity(RoleFootballer.RW, 1.0);
        player52.addRoleAffinity(RoleFootballer.LW, 0.7);
        player52.addRoleAffinity(RoleFootballer.RM, 0.5);
        player52.addRoleAffinity(RoleFootballer.LM, 0.4);
        milanPlayers.add(player52);
        
        teamPlayers.put(TEAM_NAME_MILAN, milanPlayers);
        
    }
    
    
    
	@Override
    public List<Footballer> getFootballersByTeam(String teamName) {
        return teamPlayers.getOrDefault(teamName, new ArrayList<>());
    }
	
}
