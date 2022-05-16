package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllAccounts",
        query = "SELECT m FROM Account AS m ORDER BY m.email_address DESC"
    ),
    @NamedQuery(
            name = "checkLoginAddressAndPassword", // ☆ここを増やす
            query = "SELECT a FROM Account AS a WHERE a.email_address = :address AND a.password = :pass"
            )
})
@Table(name="accounts")
public class Account {

    @Id
    @Column(name="email_address", nullable = false)
    private String email_address;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="quit")
    private Boolean quit;

    @Column(name="created_at", nullable = false)
    private Timestamp created_at;

    @Column(name="updated_at", nullable = false)
    private Timestamp updated_at;


    public String getEmail_address() {
        return email_address;
    }
    public void setEmail_address(String email_address) {
        this.email_address=email_address;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public Boolean getQuit() {
        return quit;
    }
    public void setQuit(Boolean quit) {
        this.quit=quit;
    }
    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at=created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at=updated_at;
    }

}
