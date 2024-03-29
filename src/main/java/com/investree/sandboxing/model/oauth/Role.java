package com.investree.sandboxing.model.oauth;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(
        name = "oauth_role",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "role_name_and_type",
                        columnNames = {"type", "name"}
                )
        }
)
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    private String type;
    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<RolePath> rolePaths;
    @JsonIgnore
    @ManyToMany(targetEntity = User.class, mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> user;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.name;
    }

    // getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RolePath> getRolePaths() {
        return rolePaths;
    }

    public void setRolePaths(List<RolePath> rolePaths) {
        this.rolePaths = rolePaths;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
