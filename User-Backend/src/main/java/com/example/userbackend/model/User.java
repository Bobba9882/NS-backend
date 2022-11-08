package com.example.userbackend.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

 @OneToMany(mappedBy = "user")
 private Set<TripLink> savedTripLinks;
}
