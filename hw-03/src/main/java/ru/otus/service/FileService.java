package ru.otus.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileService {
    List<String> getFromCsv() throws FileNotFoundException;
}
