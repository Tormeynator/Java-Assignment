import java.rmi.*;
import java.rmi.server.*;
import java.util.HashMap;


public class CharFactory extends UnicastRemoteObject implements CharInterface
{
	private HashMap<String, Character> listOfChars = new HashMap();
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
	    listOfChars.put(aName, aCharacter);
	    numOfChars++;
	    return numOfChars;
	}
	
	public Character readName(String aName){
		return listOfChars.get(aName);	
	}

}
