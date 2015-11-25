import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener
{
	private JLabel title = new JLabel("D&D Character Generator");
	String[] rollString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
	String[] columnNames = {"Name", "Race", "Class", "Allignment", "Str", "Dex", "Con", "Int", "Wis", "Cha"};
	private JLabel nameText = new JLabel("Name ");
	private JTextField nameField = new JTextField();
	
	private JLabel raceText = new JLabel("Race ");
	String[] raceString = {"Human", "Elf", "Dwarf", "Halfling", "Half Elf", "Half Orc", "Gnome"};
	private JComboBox raceBox = new JComboBox(raceString);
	private JLabel classText = new JLabel("Class ");
	String[] classString = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard"};
	private JComboBox classBox = new JComboBox(classString);
	private JLabel allignmentText = new JLabel("Allignment ");
	String[] allignmentString = {"Lawful Good", "Neutral Good", "Chaotic Good", "Lawful Neutral", "True Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
	private JComboBox allignmentBox = new JComboBox(allignmentString);
	
	private JLabel strengthText = new JLabel("Strength ");
	private JTextField strengthField = new JTextField("1");
	private JButton strengthRoll = new JButton("Strength Roll");
	private JLabel dexterityText = new JLabel("Dexterity ");
	private JTextField dexterityField = new JTextField("1");
	private JButton dexterityRoll = new JButton("Dexterity Roll");
	private JLabel constitutionText = new JLabel("Constituion ");
	private JTextField constitutionField = new JTextField("1");
	private JButton constitutionRoll = new JButton("Constitution Roll");
	private JLabel intelligenceText = new JLabel("Intelligence ");
	private JTextField intelligenceField = new JTextField("1");
	private JButton intelligenceRoll = new JButton("Intelligence Roll");
	private JLabel wisdomText = new JLabel("Wisdom ");
	private JTextField wisdomField = new JTextField("1");
	private JButton wisdomRoll = new JButton("Wisdom Roll");
	private JLabel charismaText = new JLabel("Charisma ");
	private JTextField charismaField = new JTextField("1");
	private JButton charismaRoll = new JButton("Charisma Roll");
	
	private JButton createButton = new JButton("Create Character");
	private JLabel createText = new JLabel("---------------------------------");
	private JButton resetButton = new JButton("Reset");
	private JButton rollAllButton = new JButton("Roll All");
	private JTextField searchField = new JTextField("Name of Char");
	private JButton searchButton = new JButton("Search");
	private JPanel titlePanel = new JPanel();
	private JPanel charPanel = new JPanel();
	private JPanel rollPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();

	
	private String theURL = "rmi:///";
	private CharInterface theFactory;

	
	public GUI()
	{
	    super("Create Character");
	    try
	    {
		    titlePanel.add(title);
		    charPanel.add(nameText);
		    charPanel.add(nameField);
		    charPanel.add(raceText);
		    charPanel.add(raceBox);
		    charPanel.add(classText);
		    charPanel.add(classBox);
		    charPanel.add(allignmentText);
		    charPanel.add(allignmentBox);
		    //charPanel.add(strengthText);
		    rollPanel.add(strengthField);
		    rollPanel.add(strengthRoll);
		    //charPanel.add(dexterityText);
		    rollPanel.add(dexterityField);
		    rollPanel.add(dexterityRoll);
		    //charPanel.add(constitutionText);
		    rollPanel.add(constitutionField);
		    rollPanel.add(constitutionRoll);
		    //charPanel.add(intelligenceText);
		    rollPanel.add(intelligenceField);
		    rollPanel.add(intelligenceRoll);
		    //charPanel.add(wisdomText);
		    rollPanel.add(wisdomField);
		    rollPanel.add(wisdomRoll);
		    //charPanel.add(charismaText);
		    rollPanel.add(charismaField);
		    rollPanel.add(charismaRoll);
		    rollPanel.add(resetButton);
		    rollPanel.add(rollAllButton);
		    charPanel.add(createText);
		    charPanel.add(createButton);
		    charPanel.add(searchField);
		    charPanel.add(searchButton);
		    
		    charPanel.setLayout(new GridLayout(6,2));
		    rollPanel.setLayout(new GridLayout(7,2));
		    buttonPanel.setLayout(new GridLayout(4,8));
		    
		    getContentPane().add(titlePanel);
		    getContentPane().add(charPanel);
		    getContentPane().add(buttonPanel);
		    getContentPane().add(rollPanel);
		    
		    strengthField.setEditable(false);
		    dexterityField.setEditable(false);
		    constitutionField.setEditable(false);
		    intelligenceField.setEditable(false);
		    wisdomField.setEditable(false);
		    charismaField.setEditable(false);
		    
		    strengthRoll.addActionListener(this);
		    dexterityRoll.addActionListener(this);
		    constitutionRoll.addActionListener(this);
		    intelligenceRoll.addActionListener(this);
		    wisdomRoll.addActionListener(this);
		    charismaRoll.addActionListener(this);
		    createButton.addActionListener(this);
		    resetButton.addActionListener(this);
		    rollAllButton.addActionListener(this);
		    searchButton.addActionListener(this);
		    
		    
		    add(titlePanel,BorderLayout.NORTH);
		    add(rollPanel,BorderLayout.EAST);
		    add(charPanel,BorderLayout.WEST);
		    add(buttonPanel,BorderLayout.SOUTH);
		   
		    theFactory  = (CharInterface)Naming.lookup(theURL+"factory");
	    }
	    catch(Exception aException){
	        aException.printStackTrace();
	      }

	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(strengthRoll))
		{
			try
			{
				Random rand = new Random();
	            strengthField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(dexterityRoll))
		{
			try
			{
				Random rand = new Random();
	            dexterityField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(constitutionRoll))
		{
			try
			{
				Random rand = new Random();
	            constitutionField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(intelligenceRoll))
		{
			try
			{
				Random rand = new Random();
	            intelligenceField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(wisdomRoll))
		{
			try
			{
				Random rand = new Random();
	            wisdomField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(charismaRoll))
		{
			try
			{
				Random rand = new Random();
	            charismaField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(rollAllButton))
		{
			try
			{
				Random rand = new Random();
				strengthField.setText(rollString [rand.nextInt( rollString.length)]);
				dexterityField.setText(rollString [rand.nextInt( rollString.length)]);
				constitutionField.setText(rollString [rand.nextInt( rollString.length)]);
				intelligenceField.setText(rollString [rand.nextInt( rollString.length)]);
				wisdomField.setText(rollString [rand.nextInt( rollString.length)]);
	            charismaField.setText(rollString [rand.nextInt( rollString.length)]);
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(resetButton))
		{
			try
			{
				strengthField.setText("1");
				dexterityField.setText("1");
				constitutionField.setText("1");
				intelligenceField.setText("1");
				wisdomField.setText("1");
	            charismaField.setText("1");
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(createButton))
		{
			try
			{
				String aName = nameField.getText();
				String aRace = (String)raceBox.getSelectedItem();
				String aClass = (String)classBox.getSelectedItem();
				String aAllignment = (String)allignmentBox.getSelectedItem();
				String aStrength = strengthField.getText();
				String aDexterity = dexterityField.getText();
				String aConstitution = constitutionField.getText();
				String aIntelligence = intelligenceField.getText();
				String aWisdom = wisdomField.getText();
				String aCharisma = charismaField.getText();
				int aCharID = theFactory.createCharacter(aName, aRace, aClass, aAllignment, aStrength, aDexterity,
						aConstitution, aIntelligence, aWisdom, aCharisma);
				JOptionPane.showMessageDialog(new JFrame(),"Character "+ aCharID + " created.");
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		else if(e.getSource().equals(searchButton))
		{
			try
			{
				String charSearch = searchField.getText();
				Character aName = theFactory.readName(charSearch);
				JOptionPane.showMessageDialog(new JFrame(),"Character Name: "+ aName.getName());
			}
			catch(Exception aException)
			{
		        aException.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		GUI aGUI = new GUI();
		aGUI.setSize(532,300);
		aGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aGUI.setVisible(true);
	}

}
