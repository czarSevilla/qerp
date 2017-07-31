package com.qacg.qerp.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_users")
public class SecUser implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Long idSecUser;
    private String secUsername;
    private String secPassword;
    private String name;
    private String email;
    private boolean active;
    private boolean block;
    
    @Id
    @Column(name = "id_sec_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIdSecUser() {
        return idSecUser;
    }
    public void setIdSecUser(Long idSecUser) {
        this.idSecUser = idSecUser;
    }
    @Column(name = "sec_username", nullable = false)
    public String getSecUsername() {
        return secUsername;
    }
    public void setSecUsername(String secUsername) {
        this.secUsername = secUsername;
    }
    @Column(name = "sec_password", nullable = false)
    public String getSecPassword() {
        return secPassword;
    }
    public void setSecPassword(String secPassword) {
        this.secPassword = secPassword;
    }
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    @Column(name = "block", nullable = false)
    public boolean isBlock() {
        return block;
    }
    public void setBlock(boolean block) {
        this.block = block;
    }
    
    

}
