package com.avalith.challenge.challenge.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "user")
@Table(name = "user")
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userName;
    private String fullName;
    @Column(unique = true)
    private String email;
    private LocalDateTime signupDate;
    private String password;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "to")
    private List<Mail> inbox;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH,mappedBy = "from")
    private List<Mail> outbox;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("userName") String userName,
                @JsonProperty("fullName") String fullName,
                @JsonProperty("email") String email,
                @JsonProperty("signupDate") LocalDateTime signupDate,
                @JsonProperty("password") String password){
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.signupDate = signupDate;
        this.password = password;
    }



}
