package ru.eltex.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface JSON {
    String toJson() throws JsonProcessingException;

    void fromJson(String dir) throws IOException;
}
