import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	private JLabel title = new JLabel("D&D Character Generator");
	String[] rollString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};  
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
	private JButton strengthRoll = new JButton("Roll");
	private JLabel dexterityText = new JLabel("Dexterity ");
	private JTextField dexterityField = new JTextField("1");
	private JButton dexterityRoll = new JButton("Roll");
	private JLabel constitutionText = new JLabel("Constituion ");
	private JTextField constitutionField = new JTextField("1");
	private JButton constitutionRoll = new JButton("Roll");
	private JLabel intelligenceText = new JLabel("Intelligence ");
	private JTextField intelligenceField = new JTextField("1");
	private JButton intelligenceRoll = new JButton("Roll");
	private JLabel wisdomText = new JLabel("Wisdom ");
	private JTextField wisdomField = new JTextField("1");
	private JButton wisdomRoll = new JButton("Roll");
	private JLabel charismaText = new JLabel("Charisma ");
	private JTextField charismaField = new JTextField("1");
	private JButton charismaRoll = new JButton("Roll");
	
	private JButton createButton = new JButton("Create Character");
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
		    rollPanel.add(strengthText);
		    rollPanel.add(strengthField);
		    rollPanel.add(strengthRoll);
		    rollPanel.add(dexterityText);
		    rollPanel.add(dexterityField);
		    rollPanel.add(dexterityRoll);
		    rollPanel.add(constitutionText);
		    rollPanel.add(constitutionField);
		    rollPanel.add(constitutionRoll);
		    rollPanel.add(intelligenceText);
		    rollPanel.add(intelligenceField);
		    rollPanel.add(intelligenceRoll);
		    rollPanel.add(wisdomText);
		    rollPanel.add(wisdomField);
		    rollPanel.add(wisdomRoll);
		    rollPanel.add(charismaText);
		    rollPanel.add(charismaField);
		    rollPanel.add(charismaRoll);
		    buttonPanel.add(createButton);
		    
		    charPanel.setLayout(new GridLayout(4,2));
		    rollPanel.setLayout(new GridLayout(6,3));
		   
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
		    
		    add(titlePanel,BorderLayout.NORTH);
		    add(charPanel,BorderLayout.EAST);
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
	}
	
	public static void main(String[] args)
	{
		GUI aGUI = new GUI();
		aGUI.setSize(450,300);
		aGUI.setVisible(true);
	}

}
