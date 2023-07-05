package org.top.converter.service;

import org.springframework.stereotype.Service;
import org.top.converter.records.Records;

@Service
public interface InformationConverter {
    Records.ConverterResultMessage converter(Records.ConverterMessage inputData);
}
