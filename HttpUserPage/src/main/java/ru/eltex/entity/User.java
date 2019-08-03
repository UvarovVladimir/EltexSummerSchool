package ru.eltex.entity;

import lombok.*;

import javax.persistence.*;
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "User_name")
    private String fio;


    @Getter
    @Setter
    @NonNull
    @Column(name = "User_phone")
    private String phone;

//    @Getter
//    @Setter
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Pass_id_number")
//    private Passport passport;
}