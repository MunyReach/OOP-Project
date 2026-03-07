
package bookstore.User.Staff.AddRemoveDisplay;

import bookstore.User.Staff.User;
import bookstore.User.Staff.Staff;
import bookstore.User.Staff.StaffList;

public class AddRemoveStaff {
    
    private StaffList staffList;
    
    public AddRemoveStaff(StaffList staffList) {
        this.staffList = staffList;
    }

    public void addStaff(String name, String email, String password) {
        // In a real application, you would save this to a database
        Staff newStaff = new Staff(name, email, password);

        staffList.addStaffMember(newStaff);
        System.out.println("Added new staff: " + newStaff.getName());
        
    }

    public void removeStaff(String name) {
        User staffToRemove = null;
        for (User staff : staffList.getStaffMembers()) {
            if (staff.getName().equals(name)) {
                staffToRemove = staff;
                break;
            }
        }

        if (staffToRemove != null) {
            staffList.removeStaffMember(staffToRemove);
            System.out.println("Removed staff: " + staffToRemove.getName());
        } else {
            System.out.println("Staff not found with name: " + name);
        }
    }

    public void displayStaff() {
        if(staffList.getStaffMembers().isEmpty()) {
            System.out.println("No staff members found.");
        } else {
            System.out.println("\n=== Staff List ===");
            for (User staff : staffList.getStaffMembers()) {
                System.out.println("- " + staff.getName() + " (" + staff.getEmail() + ")");
            }
            System.out.println("==================\n");
        }
    }

}