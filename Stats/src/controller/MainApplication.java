package controller;

import gui.InputPanelEvent;
import gui.MainFrame;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.SwingUtilities;

import data.DataHandling;
import data.HockeyPlayer;
import data.Statistics;


public class MainApplication {
	
	static ArrayList<HockeyPlayer> masterList = new ArrayList<HockeyPlayer>();
	static ArrayList<HockeyPlayer> filteredList = new ArrayList<HockeyPlayer>();

	public static void main(String[] args) {

		// Loads in database of player statistics
		masterList = DataHandling.loadPlayers();
		
		// Launches GUI
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}
		});		

	}
	
	//Passes player list to output table
	public ArrayList<HockeyPlayer> getPlayers() {
		return masterList;
	}
	
	//Passes filtered player list to output table
	public ArrayList<HockeyPlayer> getfilteredPlayers() {
		return filteredList;
	}
	
	public void runBtnClick(InputPanelEvent ev) {
		
		Integer minGames = ev.getMinGames();
		Boolean[] selectedStats = ev.getSelectedStats();
		
		// Filters out players by users specifications
		filteredList = DataHandling.playerFiltering(masterList, minGames);
		
		// Calculates league averages and standard deviations with filtered list
		Statistics leagueStats = DataHandling.calcLeagueStats(filteredList);
		
		// Calculates player ranking
		HockeyPlayer.calculateRanking(filteredList, leagueStats, selectedStats);
		
		// Sorts arraylist by ranking
		Collections.sort(filteredList);
		
	}

}
