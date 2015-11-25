import java.rmi.*;
import java.rmi.server.*;
import java.io.*;


public class Character implements Serializable
{
	private String charName;
	private String charRace;
	private String charClass;
	private String charAllignment;
	private String charStrength;
	private String charDexterity;
	private String charConstitution;
	private String charIntelligence;
	private String charWisdom;
	private String charCharisma;
	
	public Character(String aName, String aRace, String aClass, String aAllignment, String aStrength, String aDexterity,
			 String aConstitution, String aIntelligence, String aWisdom, String aCharisma)
	{
		charName = aName;
		charRace = aRace;
		charClass = aClass;
		charAllignment = aAllignment;
		charStrength = aStrength;
		charDexterity = aDexterity;
		charConstitution = aConstitution;
		charIntelligence = aIntelligence;
		charWisdom = aWisdom;
		charCharisma = aCharisma;
	}
	
	public String getName()
	{
		return charName;
	}
	
	public String getRace()
	{
		return charRace;
	}
	
	public String getCharClass()
	{
		return charClass;
	}
	
	public String getAllignment()
	{
		return charAllignment;
	}
	
	public String getStr()
	{
		return charStrength;
	}
	
	public String getDex()
	{
		return charDexterity;
	}
	
	public String getCon()
	{
		return charConstitution;
	}
	
	public String getInt()
	{
		return charIntelligence;
	}
	
	public String getWis()
	{
		return charWisdom;
	}
	
	public String getCha()
	{
		return charCharisma;
	}
	
	public void printDetails()
	{
		System.out.println("Name: " + charName);
		System.out.println("Race: " + charRace);
		System.out.println("Class: " + charClass);
		System.out.println("Allignment: " + charAllignment);
		System.out.println("Strength: " + charStrength);
		System.out.println("Dexterity: " + charDexterity);
		System.out.println("Constitution: " + charConstitution);
		System.out.println("Intelligence: " + charIntelligence);
		System.out.println("Wisdom: " + charWisdom);
		System.out.println("Charisma: " + charCharisma);
		
	}
}
