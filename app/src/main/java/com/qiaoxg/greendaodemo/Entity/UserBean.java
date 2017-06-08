package com.qiaoxg.greendaodemo.Entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;

/**
 * Created by admin on 2017/6/8.
 */

@Entity
public class UserBean {
    
    String name;
    String address;
    String mobile;

    @Index(unique = true) // 唯一性
    String uuid;

    @Id(autoincrement = true)
    Long id;

    @Generated(hash = 553851655)
    public UserBean(String name, String address, String mobile, String uuid,
            Long id) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.uuid = uuid;
        this.id = id;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
