package application.timesheets.models;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String projectName;
    private String description;
    private String archive;
    private String status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client Client;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public application.timesheets.models.Client getClient() {
        return Client;
    }

    public void setClient(application.timesheets.models.Client client) {
        Client = client;
    }
    public User getMember() {
        return user;
    }

    public void setMember(User member) {
        this.user = member;
    }
}
