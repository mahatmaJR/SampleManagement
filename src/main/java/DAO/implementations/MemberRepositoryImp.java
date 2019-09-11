package DAO.implementations;

import DAO.interfaces.MemberRepository;
import models.Member;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MemberRepositoryImp implements MemberRepository {

    @PersistenceContext(unitName = "ClubManagement")
    EntityManager entity;

    @Override
    public Member newMember(Member member) {
        Member registeredMember = this.newMember(member.getFirstName(), member.getLastName(), member.getEmail(), member.getMobileNo());
        return registeredMember;
    }

    @Override
    public Member newMember(String firstName, String lastName, String email, int mobileNo) {
        Member member = new Member();
        member.setFirstName(firstName);
        member.setLastName(lastName);
        member.setEmail(email);
        member.setMobileNo(mobileNo);

        entity.persist(member);

        return member;
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members  = entity.createNamedQuery("Member.getAll").getResultList();
        return members;
    }

    @Override
    public Member getMemberById(int id) {
        Member memberById = (Member) entity.find(Member.class, id);
        return memberById;
    }

    @Override
    public Member getMemberByLastName(String lastName) {
        Query query = entity.createNamedQuery("Member.getByLastName");
        query.setParameter("lastName", lastName);

        List<Member> members = query.getResultList();
        Member memberByLastName = null;
        if (members.size() != 0){
            memberByLastName = members.get(0);
        }

        return memberByLastName;
    }

    @Override
    public Member getMemberByFirstName(String firstName) {
        Query query = entity.createNamedQuery("Member.getByFirstName");
        query.setParameter("firstName", firstName);

        List<Member> members = query.getResultList();
        Member memberByFirstName = null;
        if (members.size() != 0){
            memberByFirstName = members.get(0);
        }
        return memberByFirstName;
    }
}
