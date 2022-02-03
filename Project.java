import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.JOptionPane;

public class Project{
    // Class attributes
    private String projectName;
    private String buildingType;
    private String projectAddress;
    private String erfNumber;
    private String projectNumber;
    private double projectFee;
    private double amountPaid;
    private String deadline;
    private String completionDate;
    private String projectStatus;
    private Stakeholder architect;
    private Stakeholder contractor;
    private Stakeholder customer;
    
    /**
     * constructor
     * @param projectName
     * @param buildingType
     * @param projectAddress
     * @param erfNumber
     * @param projectNumber
     * @param projectFee
     * @param amountPaid
     * @param deadline
     * @param projectStatus
     * @param completionDate
     * @param architect
     * @param contractor
     * @param customer
     */
    public Project(String projectName, String buildingType, String projectAddress, String erfNumber, String projectNumber,
    		double projectFee, double amountPaid, String deadline, String projectStatus, String completionDate, Stakeholder architect,
    		Stakeholder contractor, Stakeholder customer) {
  
        this.projectName = projectName;
        this.buildingType = buildingType;
        this.projectAddress = projectAddress;
        this.erfNumber = erfNumber;
        this.projectNumber = projectNumber;
        this.projectFee = projectFee;
        this.amountPaid = amountPaid;
        this.deadline = deadline;
        this.projectStatus = projectStatus;
        this.completionDate = completionDate;
        this.architect = architect;
        this.contractor = contractor;
        this.customer = customer;
    }
    
    // setters
    
    /**
     * Assign new value to project name.
     * 
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    
    /**
     * Assign new value to ERF number.
     * 
     * @param numberERF
     */
    public void setERFNumber(String numberERF) {
        this.erfNumber = numberERF;
    }
    
    /**
     * Assign new value to project fee.
     * 
     * @param projectFee
     */
    public void setProjectFee(double projectFee) {
    	this.projectFee = projectFee;
    }

    /**
     * Increment and assign new value to paid amount.
     * 
     * @param amountPaid
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid += amountPaid;
    }

    /**
     * Assign new value to deadline.
     * 
     * @param deadline
     */
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    /**
     * Assign new value to completion date.
     * 
     * @param date
     */
    public void setCompletionDate(String date) {
    	completionDate = date;
    }
    
    /**
     * Assign new value to project status.
     * 
     * @param status
     */
    public void setProjectStatus(String status) {
    	projectStatus = status;
    }
    

    // getters
    /**
     *  This methods will return the value of  class attributes
     * @return projectName
     */
    public String getProjectName() {
        return projectName;
    }
    
    /**
     * 
     * @return buildingType
     */
    public String getBuildingType() {
    	return buildingType;
    }
    
    /**
     * 
     * @return projectAddress
     */
    public String getProjectAddress() {
    	return projectAddress;
    }
    
    /**
     * 
     * @return erfNumber
     */
    public String getERFNumber() {
        return erfNumber;
    }
    
    /**
     * 
     * @return projectNumber
     */
    public String getProjectNumber() {
    	return projectNumber;
    }
    
    /**
     * 
     * @return projectFee
     */
    public double getProjectFee() {
        return projectFee;
    }

    /**
     * 
     * @return amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * 
     * @return deadline
     */
    public String getDeadline() {
        return deadline;
    }
    
    /**
     * 
     * @return completionDate
     */
    public String getCompletionDate() {
    	return completionDate;
    }
    
    /**
     * 
     * @return projectStatus
     */
    public String getProjectStatus() {
    	return projectStatus;
    }


    /**
     *  This method will calculate the amount/balance that needs to be paid by the customer
     * @return it returns balance/difference between projectFee and amountPaid
     */
    public double calculateBalance() {
        return projectFee - amountPaid;
    }
    
    /**
     *  Display method
     *  This method will display the project details for an invoice
     */
    public String toString() {
        String displayInfo = "";

        displayInfo += "Project Name: \t\t" + projectName + "\nProject Number: \t\t" + projectNumber;
        displayInfo += "\nBuilding Type: \t\t" + buildingType + "\nProject Address: \t\t" + projectAddress;
        displayInfo += "\nERF Number: \t\t" + erfNumber + "\nTotal Project Fee: \t\t" + projectFee;
        displayInfo += "\nAmount Paid: \t\t" + amountPaid + "\nProject Deadline: \t\t" + deadline;
        displayInfo += "\nProject Status: \t\t" + projectStatus;
        displayInfo += "\nBalance: R" + calculateBalance();
        displayInfo += "\n-----------------------------\n" + customer.toString();
        return displayInfo;
    }
    
    // Print Invoice
    public String printInvoice() {
    	String invoiceDetails = "Customer Details\n";
    	invoiceDetails += "Customer Contact: " + customer.getTelephoneNumber();
    	invoiceDetails += "\nBalance: R" + calculateBalance();
    	return invoiceDetails;
    }
    
    
    /**
	 * This method will be used capture all the project details
	 */
	public static void captureProjectDetails() {		
	   while(true) {
		   try {
			   // This randomNumber variable will generate a random number for a project
			    Random randomNumber = new Random();
			   	FileWriter file = new FileWriter("ProjectDetails.txt", true);
			   	Formatter writer = new Formatter(file);
			   	
				// This variable will hold project details separated by a comma and save them in a text file
				String projectDetails = "";
				
				String[] stakeholderRoles = {"architect", "contractor", "customer"};
			    String projectName = JOptionPane.showInputDialog(null, "Enter the name of the project");
			    String buildingType = JOptionPane.showInputDialog(null, "Enter a building type");
			    String projectAddress = JOptionPane.showInputDialog(null, "Enter the address of the project");
			    String erfNumber = JOptionPane.showInputDialog(null, "Enter the project ERF number");
			    Long projectFee = Long.parseLong(JOptionPane.showInputDialog(null, "Enter the total project fee"));
			    Long amountPaid = Long.parseLong(JOptionPane.showInputDialog(null, "Enter amount paid"));
			    String deadline = JOptionPane.showInputDialog(null, "Enter the project deadline\n(dd/mm/yyyy)");
			    String projectStatus = "not finalised";
			    String completionDate = "00/00/0000";
			        
			    // Generate random number between 1 and 5000, and concatenate with 'PROJ'
			    String projectNumber = "PROJ" + (randomNumber.nextInt(5000)+1);
			    String customerName = "";
			    
			    // Collect stakeholder details
			    for(int i=0; i<stakeholderRoles.length; i++) {
			    	String name = JOptionPane.showInputDialog(null, "Enter the name of the " + stakeholderRoles[i]);
				    String email = JOptionPane.showInputDialog(null, "Enter the email of the " + stakeholderRoles[i]);
				    String telephoneNumber = JOptionPane.showInputDialog(null, "Enter the telephone number of the " + stakeholderRoles[i]);
				    String physicalAddress = JOptionPane.showInputDialog(null, "Enter the address of the " + stakeholderRoles[i]);
				    String projectRole = stakeholderRoles[i];
				    
				    projectDetails += name +"; "+ email +"; "+ telephoneNumber +"; "+ physicalAddress +"; "+ projectRole +"; ";
				    
				    // Get customer name, to be used to create project name
				    if(stakeholderRoles[i].equals("customer"))
				    	customerName = name;
			    }
			    
			    // Check if project name is project is provided or not.
			    // if true take building type and customer surname and create a project name
			    if (projectName.equals("")){
			        int i = 0;
			        String surname = "";
			       
			        int LIMIT = customerName.length();
			        
			        // While looping if find empty space between take surname using substring
			        while (i < LIMIT) {
			            if (customerName.charAt(i) == ' ') {
			                surname = customerName.substring(i+1, customerName.length());
			                break;
			            }
			            i++;
			        }

			        projectName = buildingType + " " + surname;
			        
			    }
			    
			    // Append project details to the projetDetails variable
			    projectDetails += projectName + "; " + buildingType + "; " + projectAddress + "; " 
			    		+ erfNumber + "; " + projectNumber + "; " + projectFee +"; "  
			    		+ amountPaid + "; " + deadline + "; " + projectStatus + "; " + completionDate;
			    		
			    if(!projectDetails.equals("")) {
			    	// Write project details to a text file
				    writer.format("%s\n", projectDetails);
				    JOptionPane.showMessageDialog(null, "Project details saved successful.");
			    }

			    writer.close();
			    break;
		   } catch(IOException ex) {
			   // Raise exception if user has entered String values instead of a digit
			   JOptionPane.showMessageDialog(null, "Error: Couldn't write project details to a file.");
		   } catch(NumberFormatException ex) {
			   JOptionPane.showMessageDialog(null, "Error: Enter only digits for monetary values.");
		   }
	   }
	}	 
    
	/**
	 *  This method will read a text file and create a list of project objects
	 *  
	 * @return project it returns an array of objects(Project)
	 */
	public static ArrayList<Project> readProjectDetails(){
		ArrayList<Project> projects = new ArrayList<>();
		Stakeholder architect;
		Stakeholder contractor;
		Stakeholder customer;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("ProjectDetails.txt"));
			
			// line variable will hold each line of text from a ProjectDetails.txt file
			String line;
			
			// values variable will store array items created using a split method.
			String values[];
			
			while((line = reader.readLine()) != null) {
				
				// Split line by semi-colon and assign array elements to values variable
				values = line.split("; ");
				
				// This variable will store stakeholder details taken from a line of text
				String[] stakeHolValues = Arrays.copyOfRange(values, 0, 15);
				
				// Add stakeholder details
				architect = new Stakeholder(stakeHolValues[0], stakeHolValues[1], stakeHolValues[2], stakeHolValues[3], stakeHolValues[4]);
				contractor = new Stakeholder(stakeHolValues[5], stakeHolValues[6], stakeHolValues[7], stakeHolValues[8], stakeHolValues[9]);
				customer = new Stakeholder(stakeHolValues[10], stakeHolValues[11], stakeHolValues[12], stakeHolValues[13], stakeHolValues[14]);
				
				// Add project object to the projects ArrayList
				projects.add(new Project(values[15], values[16], values[17], values[18], values[19],
						Double.parseDouble(values[20]), Double.parseDouble(values[21]), values[22], values[23], 
						values[24], architect, contractor, customer));
			}
			reader.close();
		} catch(FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error: File not found.");
		} catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Error: Unable to read file.");
		}
		
		return projects;
	}
	
	/**
	 *  This method will update project details
	 */
    public static void updateProjectDetails() {
    	// call readProjectDetails to read a text file and assign the value to projects ArrayList
    	ArrayList<Project> projects = readProjectDetails();
    	boolean found = false;
    	
    	// Menu options
    	String menuOptions = "\n 1 - Project Name\n 2 - Total Fee"
    			+ "\n 3 - Amount Paid\n 4 - Deadline"
    			+ "\n 5 - Contractor Number\n 6 - Finalise Project";
    	int response = 0;
    	while(true) {
    		try {
    			// Request user response for options
            	response = Integer.parseInt(JOptionPane.showInputDialog(null, "What would you like to update?\nEnter an option number.\n" + menuOptions));
            	if(response > 0 && response < 7) 
            		break;
            	else
            		JOptionPane.showMessageDialog(null, "Enter a correct option");
    		} catch(NumberFormatException ex) {
    			JOptionPane.showMessageDialog(null, "Error: Enter numbers only.");
    		}
    	}
    	

    	// Get project name from the user
    	String searchTerm = JOptionPane.showInputDialog(null, "Enter project name or project number");
    	String name;
    	String projectNumber;
    	
    	// Check if there any projects
    	if(projects.size() > 0) {
	    	// Iterate through a list of projects 
	    	for (int index = 0; index < projects.size(); index++) {
	    		
	    		// get Project name, number and assign to name, projectNumber variables every each iteration
	    		name = projects.get(index).getProjectName();
	    		projectNumber = projects.get(index).getProjectNumber();
	    		
	    		// Check name or number is equal to projectName entered by the user
	    		if (name.equalsIgnoreCase(searchTerm) || projectNumber.equalsIgnoreCase(searchTerm)) {
	    			
	    			// Call method to update project details
	    			updateProjectMethods(response, index, projects);
	    			found = true;
	    			return;
	    		} 
	    	}
	    	
    	} else {
    		JOptionPane.showMessageDialog(null, "Theres are no projects captured.");
    	}
    	
    	// Check if found is false then display message to let know the user they entered incorrect info
    	if(!found)
    		JOptionPane.showMessageDialog(null, "Enter correct project name or project number.");
    	
    	// Update text ProjectDetails.txt file
    	updateProjectDetailsFile(projects);
    }
    
    /**
     *  This method will accept index of an array element and user response as parameters. 
     *  Then it will update project details according to their setter methods.
     *  
     * @param response user input text
     * @param index array element index
     * @param projects a list of projects created from details in a text file
     */
    private static void updateProjectMethods(int response, int index, ArrayList<Project> projects) {    	
    	String info = "";
		switch(response) {
			case 1:
				info = JOptionPane.showInputDialog(null, "Enter a new project name");
				projects.get(index).setProjectName(info);
				displaySuccessMessage();
				break;
			case 2:
				info = JOptionPane.showInputDialog(null, "Enter a new total fee");
				long fee = Long.parseLong(info);
				projects.get(index).setProjectFee(fee);
				displaySuccessMessage();
				break;
			case 3:
				info = JOptionPane.showInputDialog(null, "Enter a new amount paid");
				long amountPaid = Long.parseLong(info);
				projects.get(index).setAmountPaid(amountPaid);
				displaySuccessMessage();
				break;
			case 4:
				info = JOptionPane.showInputDialog(null, "Enter a new project deadline\n(dd/mm/yyyy/)");
				projects.get(index).setDeadline(info);
				displaySuccessMessage();
				break;
			case 5:
				info = JOptionPane.showInputDialog(null, "Enter contractor's new contact details");
				projects.get(index).customer.setTelephoneNumber(info);
				displaySuccessMessage();
				break;
			case 6:
				info = JOptionPane.showInputDialog(null, "Enter completion date\n(dd/mm/yyyy)");
				projects.get(index).setProjectStatus("finalised");
				projects.get(index).setCompletionDate(info);
				displaySuccessMessage();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Enter a correct option");
				break;
		} 
    }
    
    /**
     *  This method will display a success message after updating some details
     */
    private static void displaySuccessMessage() {
    	JOptionPane.showMessageDialog(null, "Details updated successful.");
    }
    
    /**
     * This method will update project details in text file
     * @param projectList a list of projects that were taken from a text file
     *  */
    public static void updateProjectDetailsFile(ArrayList<Project> projectList) {
    	try {
    		Formatter writer = new Formatter("ProjectDetails.txt");
    		Formatter writer2 = new Formatter("Completed_project.txt");
    		
    		// Iterate through the list to get project details
      		for(Project project : projectList) {
    			String line = "";
    			
    			// Append project details to line variable
    			line += project.architect.stakeholderDetails() + project.contractor.stakeholderDetails() + project.customer.stakeholderDetails()
    			+ project.getProjectName() +"; "+ project.getBuildingType() +"; "+ project.getProjectAddress() +"; "+ project.getERFNumber()
    			+"; "+ project.getProjectNumber() +"; " + project.getProjectFee() +"; "+ project.getAmountPaid() +"; "+ project.getDeadline() +"; "
    			+ project.getProjectStatus() +"; "+ project.getCompletionDate();
    			
    			// Check first if project status is finalise then save at a different file
    			if(project.getProjectStatus().equalsIgnoreCase("finalised")) {
 
    				// Write project details into a text file
    				writer2.format("%s\n", line);
    			} 
    			
    			// Write project details into a text file
    		
    			writer.format("%s\n", line);
      		}
    		writer.close();
    		writer2.close();
    	} catch(FileNotFoundException ex) {
    		JOptionPane.showMessageDialog(null, "Error: File not found.");
    	} 
    }
    
    
    /** 
     * This method will search for a project
     */
    public static void searchProject() {
    	ArrayList<Project> projects = readProjectDetails();
    	String searchTerm = JOptionPane.showInputDialog(null, "Enter a project name or number.");
    	String projectName = ""; 
    	String projectNumber = "";
    	
    	// Check if there are projects
    	if(projects.size() > 0) {
        	// Iterate through the project list
        	for (int index = 0; index < projects.size(); index++) {
        		projectName = projects.get(index).getProjectName();
        		projectNumber = projects.get(index).getProjectNumber();
        		
        		// Check if search term matches the project name, then show project details
        		if (searchTerm.equalsIgnoreCase(projectName) || searchTerm.equalsIgnoreCase(projectNumber)) {
        			JOptionPane.showMessageDialog(null, projects.get(index));
        			break;
        		}
        	}
    	}else {
    		JOptionPane.showMessageDialog(null, "Theres are no projects captured.");
    	}
    	
    }
    
	 /**
	  * This method will print an invoice for a customer
	  */
    public static void displayInvoice() {
    	ArrayList<Project> projects = readProjectDetails();
    	try {
    		String projectName = JOptionPane.showInputDialog(null, "Enter a project name");
        	
        	// This variable will temporarily hold a project name every iteration
        	String tempName;
        	double balance;
        	
        	if(projects.size() > 0) {
            	for(int i=0; i<projects.size(); i++) {
            		
            		balance = projects.get(i).calculateBalance();
            		tempName = projects.get(i).getProjectName();
            		
            		
            		// check if name entered by the user is matches the project name
            		if (tempName.equalsIgnoreCase(projectName)) {
            			
            			// check if balance is greater than 0 the print invoice
            			if (balance > 0) {
            				JOptionPane.showMessageDialog(null, projects.get(i).printInvoice());
            			} else {
            				JOptionPane.showMessageDialog(null, "Customer has paid in full.");
            			}
            		}
            	
            	}
        		
        	} else {
        		JOptionPane.showMessageDialog(null, "There are no projects captured.");
        	}

    	}catch(NullPointerException ex) {
    		JOptionPane.showMessageDialog(null, ex);
    	}
    }
    
    
    /**
     * This method will display projects which are not finalised
     */
    public static void showIncompleteProjects() {
    	
    	ArrayList<Project> projects = readProjectDetails();
    	// This variable will store status of a project
    	String status = "";
    	String output = "";
    	
    	// iterate thought a list of projects
    	for(int i=0; i < projects.size(); i++) {
    		status = projects.get(i).getProjectStatus();
    		
    		// Check if project has a status of "not finalise"
    		if (status.equals("not finalised")) {
    			
    			// append information to the output variable
    			output += projects.get(i).getProjectName() + " -- " + 
    					projects.get(i).getDeadline() + " -- " + projects.get(i).getProjectStatus() + "\n";
    		}
    	}
    	
    	if (output.equals("")) {
    		JOptionPane.showMessageDialog(null, "All projects have been finalise");
    	} else {
    		String info = "Project Name -- Deadline -- Status";
    	  	// Display the projects
        	JOptionPane.showMessageDialog(null, "Project that needs to be completed\n" + info + "\n\n" + output);
        	
    	}
    }
    
    /** 
     * This method will display projects which have passed their due date
     * @throws ParseException
     */
    public static void showOverdueProjects() throws ParseException {
    	ArrayList<Project> projects = readProjectDetails();
    	String deadline = "";
    	String completionDate = ""; 
    	String output = "";
    	LocalDate currentDate = LocalDate.now();
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Convert date to this format: 12/12/2021
    	String newCurrentDate = dateFormatter.format(currentDate);
    	Date objDeadline;
    	Date objComDate;
  
    	if(projects.size() > 0) {
        	// iterate thought a list of projects
        	for(int i=0; i < projects.size(); i++) {
        		deadline = projects.get(i).getDeadline();
        		completionDate = projects.get(i).getCompletionDate();
        		
        		// convert dates from string to Date object
        		objDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadline);
        		
        		if(completionDate.equals("00/00/0000"))
        			objComDate = new SimpleDateFormat("dd/MM/yyyy").parse(newCurrentDate);
        		else
        			objComDate = new SimpleDateFormat("dd/MM/yyyy").parse(completionDate);

        		if (objComDate.after(objDeadline)) {
	    			output += projects.get(i).getProjectName() + " -- " + 
	    					projects.get(i).getDeadline() + " -- " + projects.get(i).getProjectStatus() + "\n";
	    		}
        	}
    	} else {
    		JOptionPane.showMessageDialog(null, "There are no projects captured.");
    	}
    	String headingInfo = "Project Name -- Deadline -- Status";
	  	// Display the projects
    	JOptionPane.showMessageDialog(null, "Project that have passed the due date\n" + headingInfo + "\n\n" + output);
    
    }
}