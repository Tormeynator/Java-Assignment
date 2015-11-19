import java.rmi.*;
import java.rmi.server.*;
import java.io.*;


public class CharFactory extends UnicastRemoteObject implements CharInterface, Serializable
{
	private Character[] listOfChars = new Character[10];
	private int numOfChars = 0;
	
	public CharFactory() throws RemoteException
	{
		System.out.println("Factory created");
	}
	
	public int createCharacter(String aName, String aRace, String aClass, String aAllignment, String aStrength, String aDexterity,
			 String aConstitution, String aIntelligence, String aWisdom, String aCharisma)
	{
		System.out.println("Creating a Character called "+aName);
	    Character aCharacter = new Character(aName, aRace, aClass, aAllignment, aStrength, aDexterity,
				 aConstitution, aIntelligence, aWisdom, aCharisma);
	    listOfChars[numOfChars] = aCharacter;
	    numOfChars++;
	    return numOfChars;
	}

}
