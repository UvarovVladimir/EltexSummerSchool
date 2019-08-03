package ru.eltex.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class Call {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "User_name_A")
    private String fioA;

    @Getter
    @Setter
    @NonNull
    @Column(name = "User_name_B")
    private String fioB;

    @Getter
    @Setter
    @NonNull
    @Column(name = "Duti")
    private Integer time;

    @Getter
    @Setter
  //  @NonNull
    @Column(name = "Date")
    private Calendar date;


}