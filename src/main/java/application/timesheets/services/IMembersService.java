package application.timesheets.services;

import application.timesheets.models.Member;

public interface IMembersService {
    void AddMember(Member member);
    Member GetMemberById(int id);
}
