package models;

import javax.persistence.*;

@Entity
@Table(name = "staff")
@NamedQueries({
        @NamedQuery(name = "Staff.getAll", query = "SELECT s FROM staff s"),
        @NamedQuery(name = "Staff.getByLastName", query = "SELECT s FROM staff s WHERE s.lastName = :lastName"),
        @NamedQuery(name = "Staff.getByFirstName", query = "SELECT s FROM staff s WHERE s.firstName = :firstName")
})
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    String email;
    int mobileNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }



    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != null ? !id.equals(staff.id) : staff.id != null) return false;
        if (!firstName.equals(staff.firstName)) return false;
        if (!lastName.equals(staff.lastName)) return false;
        if (!email.equals(staff.email)) return false;
        return mobileNo == staff.mobileNo;
    }

    @Override
    public int hashCode(){
        int result = id != null ? id.hashCode() : 0;
        result = 14 * result + firstName.hashCode();
        result = 14 * result + lastName.hashCode();
        result = 14 * result + email.hashCode();
        result = 14 * result + mobileNo;
        return result;
    }
}
