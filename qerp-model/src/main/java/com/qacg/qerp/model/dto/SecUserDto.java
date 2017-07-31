package com.qacg.qerp.model.dto;

import java.io.Serializable;

public class SecUserDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long idSecUser;
    private String secUsername;
    private String secPassword;
    private String name;
    private String email;
    private boolean active;
    private boolean block;
    
    public Long getIdSecUser() {
        return idSecUser;
    }
    public void setIdSecUser(Long idSecUser) {
        this.idSecUser = idSecUser;
    }
    public String getSecUsername() {
        return secUsername;
    }
    public void setSecUsername(String secUsername) {
        this.secUsername = secUsername;
    }
    public String getSecPassword() {
        return secPassword;
    }
    public void setSecPassword(String secPassword) {
        this.secPassword = secPassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public boolean isBlock() {
        return block;
    }
    public void setBlock(boolean block) {
        this.block = block;
    }
}
