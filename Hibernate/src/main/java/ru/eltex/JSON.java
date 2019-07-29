package ru.eltex;

import java.io.IOException;

public interface JSON {
    String toJson();
    void fromJson(String dir)  throws IOException;
}
