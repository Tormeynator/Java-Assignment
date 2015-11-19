import java.rmi.*;
import java.rmi.server.*;


public class charServer 
{
    public static void main(String args[]){
        System.out.println("Character Server Starting");
          try{
              CharFactory aFactory = new CharFactory();
              Naming.rebind("factory", aFactory);
          }
          catch(Exception e){
              e.printStackTrace();
          }
      }

}
