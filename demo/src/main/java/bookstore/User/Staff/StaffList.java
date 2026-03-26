package bookstore.User.Staff;

import java.util.List;

public class StaffList {
    
    private List<User> staffMembers;

    public StaffList(List<User> staffMembers) {
        this.staffMembers = staffMembers;

    }

    public void addStaffMember(User staff) {
        staffMembers.add(staff);
        System.out.println("Staff member added: " + staff.getName());
    }

    public void removeStaffMember(User staff) {
        if(staffMembers.contains(staff) && staff.getRole().equals("Staff")) {
            System.out.println("Staff member removed: " + staff.getName());
        } else {
            System.out.println("Staff member not found: " + staff.getName());
        }

        staffMembers.remove(staff);

    }

    public List<User> getStaffMembers() {
        return staffMembers;
    }
}