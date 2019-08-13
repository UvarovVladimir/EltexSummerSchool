package ru.eltex.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import ru.eltex.interfaces.Json;

import java.io.IOException;

@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements Json {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    @NonNull
    private String fio;


    @Getter
    @Setter
    @NonNull
    private String phone;


    @Override
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userJson =  mapper.writeValueAsString(this);
        return userJson;
    }

    @Override
    public void fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        this.setId(user.getId());
        this.setFio(user.getFio());
        this.setPhone(user.getPhone());

    }



//    @Getter
//    @Setter
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "Pass_id_number")
//    private Passport passport;
}