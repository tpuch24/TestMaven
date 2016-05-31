package fr.thierry.testjdbc;
/**
 * Class for unique id number
 * @author Thierry
 *
 */
 public class RefAccountNumber {

	private int id=0; 

	/** L'instance statique */
    private static RefAccountNumber instance;
	
    private RefAccountNumber() {
    }
    
    public static RefAccountNumber getInstance() {
        if (null == instance) { // Premier appel
            instance = new RefAccountNumber();
        }
        return instance;
    }
    
	 public int getNewId(){
		this.id +=1;
		return this.id;
	}
	
	
	 	 
	 
}
