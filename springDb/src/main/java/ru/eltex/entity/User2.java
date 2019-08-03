package ru.eltex.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User2 {
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Pass_id_number")
    private Passport passport;
}