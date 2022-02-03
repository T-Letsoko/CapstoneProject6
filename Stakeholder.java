public class Stakeholder {
    // class attributes/fields
    private String name;
    private String email;
    private String telephoneNumber;
    private String physicalAddress;
    private String projectRole;
    
    /**
     *  Constructor 
     *  
     * @param name
     * @param email
     * @param telephoneNumber
     * @param physicalAddress
     * @param projectRole
     */
    public Stakeholder(String name, String email, String telephoneNumber, String physicalAddress, String projectRole) {
    	this.name = name;
    	this.email = email;
    	this.telephoneNumber = telephoneNumber;
    	this.physicalAddress = physicalAddress;
    	this.projectRole = projectRole;
    }
    
    // setters
    /**
     *  This methods will assign new value to stakeholder name.
     *  
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This methods will assign new value to telephone number.
     * 
     * @param telephoneNumber
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    // getters
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return email
     */
    public String getEmail() {
    	return email;
    }
    
    /**
     * 
     * @return telephoneNumber
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }
    
    /**
     * 
     * @return physicalAddress
     */
    public String getPhysicalAddress() {
    	return physicalAddress;
    }

    /**
     * 
     * @return projectRole
     */
    public String getProjectRole() {
        return projectRole;
    }
    
    /**
     * Create a line of stakeholer details
     * 
     * @return string of line
     */
    public String stakeholderDetails() {    	
    	return name +"; "+ email +"; "+ telephoneNumber +"; "+ physicalAddress +"; "+ projectRole +"; ";
    }

    /**
     * This method will display a stakeholder's details
     * 
     * @return stakeholder's details
     */
    public String toString(){

        String displayInfo = "Name: \t\t" + name;
        displayInfo += "\nEmail: \t\t" + email;
        displayInfo += "\nTelephone Number: \t\t" + telephoneNumber;
        displayInfo += "\nAddress: \t\t" + physicalAddress;
        displayInfo += "\nProject Role: \t\t" + projectRole;

        return displayInfo;
    }
    
}