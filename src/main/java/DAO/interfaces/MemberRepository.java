package DAO.interfaces;

import models.Member;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MemberRepository {
     public Member newMember(Member member);
     public Member newMember(String firstName, String lastName, String email, int mobileNo);
     List<Member> getAllMembers();
     public Member getMemberById(int id);
     public Member getMemberByFirstName(String firstName);
     public Member getMemberByLastName(String lastName);
}
