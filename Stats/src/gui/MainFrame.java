package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import controller.MainApplication;

/**
 * The main frame of the application
 * 
 * @author Nathan Murnaghan
 *
 */

public class MainFrame extends JFrame {
	
	private InputPanel inputPanel;
	private TablePanel tablePanel;
	private MainApplication mainapplication;
	
	public MainFrame() {
		super("Hockey Player Statistics Analyzer");
		
		setLayout(new BorderLayout());
		
		// Initialization of the components
		inputPanel = new InputPanel();
		tablePanel = new TablePanel();
		mainapplication = new MainApplication();
		tablePanel.setData(mainapplication.getPlayers());
		
		// Runs after the run button on the input panel is clicked
		inputPanel.setInputPanelListener(new InputPanelListener() {
			public void inputPanelEventOccured(InputPanelEvent e) {
				mainapplication.runBtnClick(e);
				tablePanel.refresh(mainapplication.getfilteredPlayers());
			}
		});		
		
		//Main Frame configuration
		add(inputPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
		setMinimumSize(new Dimension(960, 540));
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
