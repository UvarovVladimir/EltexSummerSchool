package ru.eltex;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            User user1 = new User(1, "Ivan", "900", "uvvvf@mail.ru");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("user.json"), user1);
            String JSON = mapper.writeValueAsString(user1);

            User user2 = mapper.readValue(new File("user.json"), User.class);
        }
        catch (IOException error){
            System.err.print(error.getMessage());
        }

    }
}
