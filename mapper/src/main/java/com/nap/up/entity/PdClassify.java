package com.nap.up.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @creator napuping
 * @createTime 2020/3/8
 * @description
 */
@Entity
@Table(name = "pd_classify", schema = "spring-cloud", catalog = "")
public class PdClassify {
    private long id;
    private String typeName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PdClassify that = (PdClassify) o;
        return id == that.id &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName);
    }
}
