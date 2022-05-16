package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getUnApprovePermissions",
        query = "SELECT a FROM AccessPermission a WHERE a.permission = false AND a.neko=:neko ORDER BY a.id DESC"
    ),
    @NamedQuery(
            name = "getUnApprovePermissionCount",
            query = "SELECT COUNT(a) FROM AccessPermission a WHERE a.neko=:neko AND a.requestUser=:requestUser ORDER BY a.id DESC"
    )
})
@Table(name= "access_permission")
public class AccessPermission {
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@ManyToOne
@JoinColumn(name ="neko_id", nullable = false)
private NekoAccount neko;

@ManyToOne
@JoinColumn(name="request_user", nullable = false)
private Account requestUser;

@Column(name="permission")
private Boolean permission;

public NekoAccount getNeko() {
    return neko;
}

public Integer getId() {
    return id;
}

public Account getRequestUser() {
    return requestUser;
}

public Boolean getPermission() {
    return permission;
}

public void setNeko(NekoAccount neko) {
    this.neko = neko;
}

public void setId(Integer id) {
    this.id = id;
}

public void setRequestUser(Account requestUser) {
    this.requestUser = requestUser;
}

public void setPermission(Boolean permission) {
    this.permission = permission;
}



}
