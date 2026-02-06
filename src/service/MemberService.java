package service;

import model.OfficerMember;
import model.RegularMember;

public class MemberService {
    public OfficerMember createOfficerMember(int id, String name, String email) throws Exception {
        OfficerMember member = new OfficerMember();
        member.setId(id);
        member.setName(name);
        member.setEmail(email);
        return member;
    }
    public RegularMember createRegularMember(int id, String name, String email) throws Exception {
        RegularMember member = new RegularMember();
        member.setId(id);
        member.setName(name);
        member.setEmail(email);
        return member;
    }
}
