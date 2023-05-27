package ru.otus.service.utils;

import org.springframework.stereotype.Component;
import ru.otus.domain.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class Console {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String readLine() throws IOException {
        return reader.readLine();
    }

    public void println(String string) {
        System.out.println(string);
    }

    public void println(Answer answer) {
        System.out.println(answer);
    }
}