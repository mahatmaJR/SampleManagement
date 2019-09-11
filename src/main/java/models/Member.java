package models;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NamedQueries({
        @NamedQuery(name = "Member.getAll", query = "SELECT m FROM member m"),
        @NamedQuery(name = "Member.getByLastName", query = "SELECT m FROM member m WHERE m.lastName = :lastName"),
        @NamedQuery(name = "Member.getByFirstName", query = "SELECT m FROM member m WHERE m.firstName = :firstName")
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String firstName;
    String lastName;
    String email;
    int mobileNo;

    public Member(String firstName, String lastName, String email, int mobileNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public Member() {
    }

    public Member(String lastName, int mobileNo) {
        this.lastName = lastName;
        this.mobileNo = mobileNo;
    }

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
//
//    @Override
//    public boolean equals(Object o){
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Member member = (Member) o;
//
//        if (id != null ? !id.equals(member.id) : member.id != null) return false;
//        if (!firstName.equals(member.firstName)) return false;
//        if (!lastName.equals(member.lastName)) return false;
//        if (!email.equals(member.email)) return false;
//        return mobileNo == member.mobileNo;
//    }
//
//    @Override
//    public int hashCode(){
//        int result = id != null ? id.hashCode() : 0;
//        result = 14 * result + firstName.hashCode();
//        result = 14 * result + lastName.hashCode();
//        result = 14 * result + email.hashCode();
//        result = 14 * result + mobileNo;
//        return result;
//    }
}
