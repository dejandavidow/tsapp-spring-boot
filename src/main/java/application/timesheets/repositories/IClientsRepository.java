package application.timesheets.repositories;

import application.timesheets.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IClientsRepository extends JpaRepository<Client,Integer> {
    List<Client> findByClientNameContaining(String clientName, Pageable pageable);
    List<Client> findByClientNameStartsWith(Character letter,Pageable pageable);
    Client findByClientName(String name);
}
