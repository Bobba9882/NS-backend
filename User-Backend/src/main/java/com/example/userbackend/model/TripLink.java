package com.example.userbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "trips")
public class TripLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "user", nullable = false)
    private long user;
    @Column(name = "data")
    @JsonProperty("ctxRecon")
    private String data;
}
