package com.uber.authservices.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "EM_USER")
public class AuditUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String preferredName;

    private String email;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AuditUser auditUser = (AuditUser) o;
        return Objects.equals(id, auditUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}