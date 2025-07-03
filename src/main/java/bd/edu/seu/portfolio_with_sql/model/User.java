package bd.edu.seu.portfolio_with_sql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    private String name;
    @Id
    private String email;
    private String phone;
    private String message;

    public User() {

    }
    public User(String email, String message, String name, String phone) {
        this.email = email;
        this.message = message;
        this.name = name;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
