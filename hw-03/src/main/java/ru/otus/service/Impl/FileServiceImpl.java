package ru.otus.service.Impl;

import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.otus.config.QuizProperties;
import ru.otus.service.FileService;

import java.io.*;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    private final String path;

    public FileServiceImpl(MessageSource messageSource, QuizProperties quizProps) {
        this.path = messageSource.getMessage("filePath", null, quizProps.getLocale());
    }
    @Override
    public List<String> getFromCsv() {
        try {
            Resource resource = new ClassPathResource(path);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            return bufferedReader.lines().toList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
