package ru.otus.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.service.FileService;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest()
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.yml")
public class FileServiceTest {
    @Autowired
    private FileService fileService;

    @Test
    public void shouldGetAllLinesFromFileWithOk() throws FileNotFoundException {
        List<String> questions = fileService.getFromCsv();
        assertEquals(5, questions.size());
    }

}
