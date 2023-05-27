package ru.otus.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.otus.config.AppConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Baeva Nastasia
 */
@Service
public class ResourceService {
    private final  Resource resource;
    public ResourceService(AppConfig appConfig) {
        this.resource = new ClassPathResource(appConfig.getPathToQuiz());
    }

    public List<List<String>> getFromCsv(String separator) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            return bufferedReader.lines()
                    .map(x -> Arrays.asList(x.split(separator)))
                    .toList();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
