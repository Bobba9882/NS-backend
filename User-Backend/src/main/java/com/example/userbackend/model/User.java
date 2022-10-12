package com.example.userbackend.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(name = "first_name", nullable = false)
 private String firstName;

 @Column(name = "last_name")
 private String lastName;

 @Column(name = "password", nullable = false)
 private String password;

 @Column(name = "email", nullable = false)
 private String email;
}
