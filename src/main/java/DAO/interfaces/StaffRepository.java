package DAO.interfaces;

import models.Staff;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StaffRepository {
    public Staff newStaff (String firstName, String lastName, String email, int mobileNo);
    public Staff updateStaff(int staffId);
    public void removeStaff(int staffId);
    List<Staff> getAllStaffs();
    public Staff getStaffById(int id);
    public Staff getStaffByFirstName(String firstName);
    public Staff getStaffByLastName(String lastName);
}
