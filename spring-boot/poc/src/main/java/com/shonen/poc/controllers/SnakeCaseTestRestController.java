package com.shonen.poc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shonen.poc.resources.responses.ListarFichaResponse;
import com.shonen.poc.services.SnakeCaseTestService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("snake-case/test")
@RequiredArgsConstructor
public class SnakeCaseTestRestController {

    private final SnakeCaseTestService snakeCaseTestService;

    @GetMapping
    public ListarFichaResponse testJsonSnakeCase() {
        return snakeCaseTestService.testJson();
    }

}
