package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * The input panel portion of the GUI, located on the left hand side of the main frame
 * 
 * @author Nathan Murnaghan
 *
 */

public class InputPanel extends JPanel {
	
	private JComboBox gamesPlayedCombo;
	private JComboBox positionCombo;
	private JCheckBox goals;
	private JCheckBox assists;
	private JCheckBox plusminus;
	private JCheckBox pims;
	private JCheckBox shots;
	private JCheckBox hits;
	private JCheckBox blocks;
	private JCheckBox takeaways;
	private JCheckBox powerplay;
	private JCheckBox shorthanded;
	private JCheckBox gamewinning;
	private JRadioButton perGameRadio;
	private JRadioButton perTOIRadio;
	private ButtonGroup analysisGroup;
	private JButton runBtn;
	private InputPanelListener inputPanelListener;
	
	public InputPanel() {
		
		// Creates the input panel
		Dimension dim = getPreferredSize();
		dim.width = 270;
		setPreferredSize(dim);
		Border blackline = BorderFactory.createLineBorder(Color.black);
		Border innerBorder = BorderFactory.createTitledBorder(blackline, "Select Preferences");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		// Sets the values for the combo boxes
		Integer[] GamePlayedValues = new Integer[82];
		for(int i=1;i<83;i++){
			GamePlayedValues[i-1] = i;
		}
		String[] positionValues = new String[] {"All","Forwards","C","RW","LW","D"};
		
		// Initializes the components of the input panel
		gamesPlayedCombo = new JComboBox(GamePlayedValues);
		gamesPlayedCombo.setPrototypeDisplayValue("Forwards");
		positionCombo = new JComboBox(positionValues);
		goals = new JCheckBox("Goals");
		assists = new JCheckBox("Assists");
		plusminus = new JCheckBox("Plus/Minus");
		pims = new JCheckBox("PIMs");
		shots = new JCheckBox("Shots");
		hits = new JCheckBox("Hits");
		blocks = new JCheckBox("Blocks");
		takeaways = new JCheckBox("Takeaways");
		powerplay = new JCheckBox("Powerplay Points");
		shorthanded = new JCheckBox("Shorthanded Points");
		gamewinning = new JCheckBox("Game Winning Goals");
		analysisGroup = new ButtonGroup();
		runBtn = new JButton("Run");
		
		//Sets up radio buttons
		perGameRadio = new JRadioButton("Per Game");
		perTOIRadio = new JRadioButton("Per Time on Ice");
		perGameRadio.setActionCommand("Per Game");
		perTOIRadio.setActionCommand("Per TOI");
		perGameRadio.setSelected(true);
		analysisGroup.add(perGameRadio);
		analysisGroup.add(perTOIRadio);		
		
		// Action Listener for the run button
		runBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer minGames = (Integer) gamesPlayedCombo.getSelectedItem();
				Boolean[] selectedStats = new Boolean[]{
						goals.isSelected(),assists.isSelected(),plusminus.isSelected(),
						pims.isSelected(),shots.isSelected(),hits.isSelected(),
						blocks.isSelected(),takeaways.isSelected(),powerplay.isSelected(),
						shorthanded.isSelected(),gamewinning.isSelected()};
				int positionFilter = positionCombo.getSelectedIndex();
				String analysisType = analysisGroup.getSelection().getActionCommand();
				
				InputPanelEvent ipev = new InputPanelEvent(this, minGames, selectedStats, positionFilter,analysisType);
				
				if(inputPanelListener != null) {
					inputPanelListener.inputPanelEventOccured(ipev);
				}
				
			}
		});
		
		// Lays out the components as specified
		layoutComponents();
		
	}
	
	/**
	 * Sets up the layout of the components in the input panel
	 */
	
	public void layoutComponents() {
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		// First Row //
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.gridwidth = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("  Position Filter: "),gc);
		
		gc.gridx = 2;
		gc.gridwidth = 1;
		add(positionCombo, gc);		
		
		// Next Row //
		gc.gridy++;
		gc.gridx = 0;
		gc.gridwidth = 2;
		add(new JLabel("  Minimum Games Played: "),gc);
		
		gc.gridx = 2;
		gc.gridwidth = 1;
		add(gamesPlayedCombo, gc);
		
		// Next Row //
		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 0.2;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel("  Select Categories"), gc);
		
		// Next Row //
		gc.gridy++;
		gc.gridwidth = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(0, 20, 0, 0);
		add(goals,gc);
		
		// Next Row //
		gc.gridy++;
		add(assists,gc);
		
		// Next Row //
		gc.gridy++;
		add(plusminus,gc);
		
		// Next Row //
		gc.gridy++;
		add(pims,gc);
		
		// Next Row //
		gc.gridy++;
		add(shots,gc);
		
		// Next Row //
		gc.gridy++;
		add(hits,gc);
		
		// Next Row //
		gc.gridy++;
		add(blocks,gc);
		
		// Next Row //
		gc.gridy++;
		add(takeaways,gc);
		
		// Next Row //
		gc.gridy++;
		add(powerplay,gc);
		
		// Next Row //
		gc.gridy++;
		add(shorthanded,gc);
		
		// Next Row //
		gc.gridy++;
		add(gamewinning,gc);
		
		// Next Row //
		gc.gridy++;
		gc.gridx = 0;
		gc.weighty = 0.2;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.gridwidth = GridBagConstraints.REMAINDER;
		add(new JLabel("  Select Analysis Type"), gc);
		
		// Next Row //
		gc.gridy++;
		gc.gridwidth = 1;
		gc.weighty = 0.1;
		gc.insets = new Insets(0, 20, 0, 0);
		add(perGameRadio,gc);
		
		// Next Row //
		gc.gridy++;
		add(perTOIRadio,gc);
		
		// Next Row //
		gc.gridy++;
		gc.weighty = 2.0;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.anchor = GridBagConstraints.NORTH;
		gc.insets = new Insets(20, 0, 0, 0);
		add(runBtn,gc);	
	}
	
	public void setInputPanelListener(InputPanelListener listener){
		this.inputPanelListener = listener;
	}

}
