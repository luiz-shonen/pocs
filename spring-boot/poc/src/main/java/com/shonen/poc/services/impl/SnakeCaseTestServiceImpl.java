package com.shonen.poc.services.impl;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shonen.poc.resources.responses.ListarFichaResponse;
import com.shonen.poc.services.SnakeCaseTestService;
import com.shonen.poc.utils.Utils;

import lombok.RequiredArgsConstructor;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnakeCaseTestServiceImpl implements SnakeCaseTestService {
    private static final String SNAKE_CASE_TEST_JSON_FILE = "snake-case-test.json";

    private final ObjectMapper objectMapper;

    @Override
    public ListarFichaResponse testJson() {
        final var file = Utils.getFile(SNAKE_CASE_TEST_JSON_FILE);

        try {
            return objectMapper.readValue(file, ListarFichaResponse.class);
        } catch (IOException e) {
            throw new NullPointerException("Não foi possível serializar o arquivo " + SNAKE_CASE_TEST_JSON_FILE);
        }
    }

}
