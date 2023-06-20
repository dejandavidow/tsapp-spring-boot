package application.timesheets.api;

import application.timesheets.models.Client;
import application.timesheets.models.Member;
import application.timesheets.services.IClientsService;
import application.timesheets.services.IMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Members")
public class MembersController {
    @Autowired
    private IMembersService membersService;
    @PostMapping
    public void AddMember(@RequestBody Member member)
    {
        membersService.AddMember(member);
    }
    @GetMapping("{id}")
    public Member GetMemberById(@PathVariable int id)
    {
        return membersService.GetMemberById(id);
    }

}
