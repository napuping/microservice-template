package com.nap.up.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
@Entity
@Table(name = "pd_user", schema = "spring-cloud", catalog = "")
public class PdUser {
    private long id;
    private String userName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdUser pdUser = (PdUser) o;
        return id == pdUser.id &&
                Objects.equals(userName, pdUser.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName);
    }
}
