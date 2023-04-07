package com.example.tooneactivity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Profile {
    @Id
    private Long id;
    private String email;
    private String address;
    @Generated(hash = 1518008755)
    public Profile(Long id, String email, String address) {
        this.id = id;
        this.email = email;
        this.address = address;
    }
    @Generated(hash = 782787822)
    public Profile() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

