import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CharInterface extends Remote
{
	public int createCharacter(String aName, String aRace, String aClass, String aAllignment, String aStrength, String aDexterity,
			 String aConstitution, String aIntelligence, String aWisdom, String aCharisma)
	throws RemoteException;
}
