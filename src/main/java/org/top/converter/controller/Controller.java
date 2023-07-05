package org.top.converter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.top.converter.records.Records;
import org.top.converter.service.InformationConverter;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final InformationConverter informationConverter;

    @GetMapping("/")
    public Records.Message index() {
        return new Records.StringMessage("Server is running - "+
                LocalDateTime.now());
    }
    @GetMapping("/ping")
    public Records.Message ping() {
        return new Records.StringMessage("ping");
    }
    @PostMapping("/converter")
    public Records.Message converter(@RequestBody Records.ConverterMessage inputData){
        Records.ConverterResultMessage result = informationConverter.converter(inputData);
        return result;
    }
}
