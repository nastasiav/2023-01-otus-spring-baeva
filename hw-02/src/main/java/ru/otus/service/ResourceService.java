package ru.otus.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Baeva Nastasia
 */
public class ResourceService {
    private final Resource resource;

    public ResourceService(String pathToQuestions) {
        this.resource = new ClassPathResource(pathToQuestions);
    }

    public List<List<String>> getFromCsv(String separator) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.resource.getInputStream()));
            return bufferedReader.lines()
                    .map(x -> Arrays.asList(x.split(separator)))
                    .toList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
