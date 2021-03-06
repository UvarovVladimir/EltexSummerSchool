package ru.eltex.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "User_name")
    private String fio;

    @Getter
    @Setter
    @NonNull
    @Column(name = "Phone")
    private String phone;


}