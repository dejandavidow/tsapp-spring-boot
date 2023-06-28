package application.timesheets.models;

import jakarta.persistence.Column;

public class MemberDTO {
    public MemberDTO(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String fullName;
    private String email;
}
