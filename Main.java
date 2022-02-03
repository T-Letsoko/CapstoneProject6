/**
 * This project is created to record project details and edit some detals
 * <p>
 * 
 * @author Tebogo Letsoko
 * @version 1.2
 */
import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {                
        // user response to select menu option
        String response;        
        String menuOptions = "\n1 - Record Project \n2 - Search Project \n3 - Update Project "
        		+ "\n4 - Generate Invoice \n5 - Show Incomplete Projects "
        		+ "\n6 - Show Overdue Projects \n7 - Exit Program"; 
    
        boolean isProgramRunning = true;
        
        // run the program until the user exit the program
        while (isProgramRunning) {
        	try {
	        	// Request user to enter an option 
	            response = JOptionPane.showInputDialog(null, "What would you like to do?\nEnter an option number.\n" + menuOptions);
	 
	        	switch(response) {
		        	case "1":
		        		//Project project;
		        		while(true) {
		        			//project = new Project();
		        			Project.captureProjectDetails();
		        			
		        			// Ask user to capture another project
		        			if(JOptionPane.showInputDialog(null, "Capture another project?\nY - Yes or N - No").equalsIgnoreCase("n")) {
		        				break;
		        			}
		        		}
		        		break;
		        	case "2":
		        		// Search for project
		        		Project.searchProject();
		        		break;		                
		        	case "3":
		        		// Update project details
		        		Project.updateProjectDetails();
		        		break;
		        	case "4":
		        		// Generate Invoice
		        		Project.displayInvoice();
		        		break;
		        	case "5":
		        		// Show Incomplete Projects
		        		Project.showIncompleteProjects();
		        		break;
		        	case "6":
		         		// Show Overdue Projects
		        		Project.showOverdueProjects();
		        		break;
		        	case "7":
		        		// Close the system
		        		isProgramRunning = false;
		        		break;
		        	default:
		        		JOptionPane.showMessageDialog(null, "Please enter a correct option number!");
		        		break;        
	        	}
        	} catch(NullPointerException ex) {
        		// Raise exception if user press escape button or click cancel button
        		JOptionPane.showMessageDialog(null, "Enter an option number.");
        	}
       }
  
    }

	
}