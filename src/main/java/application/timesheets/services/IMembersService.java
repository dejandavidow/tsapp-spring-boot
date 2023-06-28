package application.timesheets.services;

import application.timesheets.models.Member;
import application.timesheets.models.MemberDTO;

public interface IMembersService {
    void AddMember(Member member);
    MemberDTO GetMemberById(int id);
}
