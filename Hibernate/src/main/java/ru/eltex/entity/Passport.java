

package ru.eltex.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "passports")
public class Passport{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "S_N")
    @NonNull
    @Getter
    @Setter
    private String serialNumder;

    @Getter
    @Setter
    @OneToOne(mappedBy = "passport")
    private User user;
}
