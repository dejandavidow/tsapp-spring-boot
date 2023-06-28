package application.timesheets.services;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Member;
import application.timesheets.models.MemberDTO;
import application.timesheets.repositories.IMembersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersService implements IMembersService{
    @Autowired
    private IMembersRepository membersRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public void AddMember(Member member) {
       Member memberEx =  membersRepository.findByEmail(member.getEmail());
       if(memberEx != null)
       throw new EntityAlreadyExist("Member already exists!");
        membersRepository.save(member);
    }

    @Override
    public MemberDTO GetMemberById(int id)
    {
        Member member = membersRepository.findById(id).orElseThrow(() -> new NotFoundException("Member not found!"));
        return mapper.map(member,MemberDTO.class);
    }
}
