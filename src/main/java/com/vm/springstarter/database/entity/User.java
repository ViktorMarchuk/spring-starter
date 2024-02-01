package com.vm.springstarter.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")

public class User implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "birth_date")
    private LocalDate birthDay;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;


    @Builder.Default
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UserChat> userChats = new ArrayList<>();

}
