package application.timesheets.services;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Member;
import application.timesheets.repositories.IMembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService implements IMembersService{
    @Autowired
    private IMembersRepository membersRepository;
    @Override
    public void AddMember(Member member) {
       Member memberEx =  membersRepository.findByFullName(member.getFullName());
       if(memberEx != null)
       throw new EntityAlreadyExist("Member already exists!");
        membersRepository.save(member);
    }

    @Override
    public Member GetMemberById(int id)
    {
        return membersRepository.findById(id).orElseThrow(() -> new NotFoundException("Member not found!"));
    }
}
