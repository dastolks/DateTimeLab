
package practice;

/**
 * This class represents a person in the real world.
 * 
 * @author Alec Schindler
 * @version 1.00
 */
public class Person {
    private String firstName;
    private String lastName;

    /** Default Constructor */    
    public Person() {}
    
    /**
     * Convenience constructor.
     * 
     * 
     * @param firstName - not validated
     * @param lastName  - not validated
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    
}
