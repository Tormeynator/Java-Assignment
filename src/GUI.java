import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame //implements ActionListener
{
	private JLabel title = new JLabel("D&D Character Generator");
	
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
	
	
	public GUI()
	{
	    super("Create Character");
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
	    //theOKButton.addActionListener(this);
	    
	    strengthField.setEditable(false);
	    dexterityField.setEditable(false);
	    constitutionField.setEditable(false);
	    intelligenceField.setEditable(false);
	    wisdomField.setEditable(false);
	    charismaField.setEditable(false);
	    
	    add(titlePanel,BorderLayout.NORTH);
	    add(charPanel,BorderLayout.EAST);
	    add(charPanel,BorderLayout.WEST);
	    add(buttonPanel,BorderLayout.SOUTH);

	}
	
	public static void main(String[] args)
	{
		GUI aGUI = new GUI();
		aGUI.setSize(450,300);
		aGUI.setVisible(true);
	}

}
