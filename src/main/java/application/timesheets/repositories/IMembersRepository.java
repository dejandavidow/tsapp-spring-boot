package application.timesheets.repositories;

import application.timesheets.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMembersRepository extends JpaRepository<Member,Integer> {
    Member findByEmail(String email);
}
