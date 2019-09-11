package DAO.implementations;

import DAO.interfaces.StaffRepository;
import models.Staff;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class StaffRepositoryImp implements StaffRepository {

    @PersistenceContext
    EntityManager entity ;

    @Override
    public Staff newStaff(String firstName, String lastName, String email, int mobileNo) {
        Staff staff = new Staff();
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setEmail(email);
        staff.setMobileNo(mobileNo);

        entity.persist(staff);
        return null;
    }

    @Override
    public Staff updateStaff(int staffId) {
        Staff staff = getStaffById(staffId);

        entity.merge(staff);

        return staff;
    }

    @Override
    public void removeStaff(int staffId) {
        entity.remove(getStaffById(staffId));
    }

    @Override
    public List<Staff> getAllStaffs() {
        List<Staff> staffList = entity.createNamedQuery("Staff.getAll").getResultList();
        return staffList;
    }

    @Override
    public Staff getStaffById(int staffId) {
        Staff staff = entity.find(Staff.class, staffId);
        return staff;
    }

    @Override
    public Staff getStaffByFirstName(String firstName) {
        Query query = entity.createNamedQuery("Staff.getByFirstName");
        query.setParameter("firstName", firstName);

        List<Staff> members = query.getResultList();
        Staff staffByfirstName = null;
        if (members.size() != 0){
            staffByfirstName = members.get(0);
        }

        return staffByfirstName;
    }

    @Override
    public Staff getStaffByLastName(String lastName) {
        Query query = entity.createNamedQuery("Staff.getByLastName");
        query.setParameter("lastName", lastName);

        List<Staff> members = query.getResultList();
        Staff staffByLastName = null;
        if (members.size() != 0){
            staffByLastName = members.get(0);
        }

        return staffByLastName;
    }
}
