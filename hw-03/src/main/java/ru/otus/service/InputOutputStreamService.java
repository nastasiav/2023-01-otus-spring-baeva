package ru.otus.service;

public interface InputOutputStreamService {
    void outputPrint(String s);
    int readNextInt();
    String readNextString(String prompt);
}
