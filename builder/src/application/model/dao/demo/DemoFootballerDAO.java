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
        String teamName1 = "Inter"; 
        
        Footballer player1 = new Footballer("Yann", "Sommer", teamName1, 36);
        player1.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player1);
        
        Footballer player2 = new Footballer("Josep", "Martinez", teamName1, 26);
        player2.addRoleAffinity(RoleFootballer.GK, 1.0);
        interPlayers.add(player2);
        
        Footballer player3 = new Footballer("Alessandro", "Bastoni", teamName1, 25);
        player3.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player3);
        
        Footballer player4 = new Footballer("Benjamin", "Pavard", teamName1, 28);
        player4.addRoleAffinity(RoleFootballer.CB, 1.0);
        player4.addRoleAffinity(RoleFootballer.RB, 0.8);
        interPlayers.add(player4);
        
        Footballer player5 = new Footballer("Stefan", "De Vrij", teamName1, 33);
        player5.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player5);
        
        Footballer player6 = new Footballer("Francesco", "Acerbi", teamName1, 37);
        player6.addRoleAffinity(RoleFootballer.CB, 1.0);
        interPlayers.add(player6);
        
        Footballer player7 = new Footballer("Federico", "Di Marco", teamName1, 27);
        player7.addRoleAffinity(RoleFootballer.CB, 0.5);
        player7.addRoleAffinity(RoleFootballer.LB, 0.8);
        player7.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player7);
        
        Footballer player8 = new Footballer("Carlos", "Augusto", teamName1, 26);
        player8.addRoleAffinity(RoleFootballer.CB, 0.5);
        player8.addRoleAffinity(RoleFootballer.LB, 0.8);
        player8.addRoleAffinity(RoleFootballer.LM, 1.0);
        interPlayers.add(player8);
        
        Footballer player9 = new Footballer("Denzel", "Dumfries", teamName1, 28);
        player9.addRoleAffinity(RoleFootballer.RB, 0.8);
        player9.addRoleAffinity(RoleFootballer.RM, 1.0);
        interPlayers.add(player9);
        
        Footballer player10 = new Footballer("Matteo", "Darmian", teamName1, 35);
        player10.addRoleAffinity(RoleFootballer.RB, 1.0);
        player10.addRoleAffinity(RoleFootballer.RM, 1.0);
        player10.addRoleAffinity(RoleFootballer.CB, 0.7);
        interPlayers.add(player10);
        
        Footballer player11 = new Footballer("Hakan", "Calhanoglu", teamName1, 31);
        player11.addRoleAffinity(RoleFootballer.CM, 1.0);
        player11.addRoleAffinity(RoleFootballer.CDM, 1.0);
        interPlayers.add(player11);
        
        Footballer player12 = new Footballer("Nicolo", "Barella", teamName1, 28);
        player12.addRoleAffinity(RoleFootballer.CM, 1.0);
        player12.addRoleAffinity(RoleFootballer.CDM, 0.7);
        interPlayers.add(player12);
        
        Footballer player13 = new Footballer("Davide", "Frattesi", teamName1, 25);
        player13.addRoleAffinity(RoleFootballer.CM, 1.0);
        interPlayers.add(player13);
        
        Footballer player14 = new Footballer("Piotr", "Zielinski", teamName1, 30);
        player14.addRoleAffinity(RoleFootballer.CM, 1.0);
        player14.addRoleAffinity(RoleFootballer.CAM, 0.7);
        interPlayers.add(player14);
        
        Footballer player15 = new Footballer("Lautaro", "Martinez", teamName1, 27);
        player15.addRoleAffinity(RoleFootballer.ST, 1.0);
        interPlayers.add(player15);
        
        Footballer player16 = new Footballer("Marcus", "Thuram", teamName1, 27);
        player16.addRoleAffinity(RoleFootballer.ST, 1.0);
        player16.addRoleAffinity(RoleFootballer.LW, 0.7);
        player16.addRoleAffinity(RoleFootballer.RW, 0.5);
        interPlayers.add(player16);
        
        Footballer player17 = new Footballer("Marko", "Arnautovic", teamName1, 35);
        player17.addRoleAffinity(RoleFootballer.ST, 1.0);
        interPlayers.add(player17);
        
        teamPlayers.put(teamName1, interPlayers);
        
    }
    
    
    
	@Override
    public List<Footballer> getFootballersByTeam(String teamName) {
        // Se non esiste la squadra, restituisce una lista vuota
        return teamPlayers.getOrDefault(teamName, new ArrayList<>());
    }
}
