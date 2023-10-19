package ru.otus.service.Impl;

import org.springframework.stereotype.Service;
import ru.otus.service.InputOutputStreamService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class InputOutputStreamServiceImpl implements InputOutputStreamService {
    private final PrintStream output;
    private final Scanner input;

    public InputOutputStreamServiceImpl() {
        output = System.out;
        input = new Scanner(System.in);
    }
    @Override
    public void outputPrint(String s) {
        output.println(s);
    }
    @Override
    public int readNextInt() {
        return Integer.parseInt(input.nextLine());
    }
    @Override
    public String readNextString(String prompt) {
        outputPrint(prompt);
        return input.nextLine();
    }
}
