package ru.eltex;

import org.springframework.data.repository.CrudRepository;
import ru.eltex.entity.Call;
import ru.eltex.entity.User;
import java.util.List;

public interface UserRepository extends CrudRepository<Call, Integer> {
        List<Call> findByFio(String fioA);
    }
