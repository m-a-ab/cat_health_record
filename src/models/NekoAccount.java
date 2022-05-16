package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllNekoAccount",
        query = "SELECT m FROM NekoAccount AS m ORDER BY m.id DESC"
    ),
    @NamedQuery(
        name = "getNekoAccountByEmailAddress",
        query = "SELECT m FROM NekoAccount AS m WHERE m.email_address = :email_address ORDER BY m.id DESC"
    ),
    @NamedQuery(
            name = "getNekoAccountByPermissions",
            query = "SELECT n FROM NekoAccount n, AccessPermission a WHERE n=a.neko AND a.requestUser=:requestUser or n.email_address = :email_address ORDER BY n.id DESC"
    )
})

@Table(name = "nekoaccount")
public class NekoAccount {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nekoname", nullable = false)
    private String nekoname;

    @Column(name = "image")
    private String image;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "other")
    private String other;

    @Column(name = "email_address")
    private String email_address;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "email_address_otheruser")
    private String email_address_otheruser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNekoname() {
        return nekoname;
    }

    public void setNekoname(String nekoname) {
        this.nekoname = nekoname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getEmail_adress_otheruser() {
        return email_address_otheruser;
    }

    public void setEmail_address_otheruser(String email_address_otheruser) {
        this.email_address_otheruser = email_address_otheruser;
    }
}
