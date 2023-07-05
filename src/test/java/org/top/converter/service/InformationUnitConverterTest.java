package org.top.converter.service;

import org.junit.jupiter.api.Test;
import org.top.converter.records.Records;

import static org.assertj.core.api.Assertions.assertThat;

public class InformationUnitConverterTest {
    InformationConverter informationConverter= new InformationUnitConverter();
    @Test
    void converter_shouldBeSuccessful() {

        Records.ConverterMessage inputData =
                new Records.ConverterMessage("KB","MB",1024.0);
        assertThat(informationConverter.converter(inputData))
                .isEqualTo(new Records.ConverterResultMessage("1.0"));

//        Records.ConverterResultMessage result1 = informationConverter.converter(inputData);
//        System.out.println(result1);
//        System.out.println(new Records.ConverterResultMessage("1.0"));

        inputData =
                new Records.ConverterMessage("Byte","bits",1.0);
        assertThat(informationConverter.converter(inputData))
                .isEqualTo(new Records.ConverterResultMessage("8.0"));

        inputData =
                new Records.ConverterMessage("GB","MB",1.0);
        assertThat(informationConverter.converter(inputData))
                .isEqualTo(new Records.ConverterResultMessage("1024.0"));

        inputData =
                new Records.ConverterMessage("KB","MB",-1024.0);
        assertThat(informationConverter.converter(inputData))
                .isEqualTo(new Records.ConverterResultMessage("Error: отрицательное количество единиц"));

        inputData =
                new Records.ConverterMessage("KB","mB",1024.0);
        assertThat(informationConverter.converter(inputData))
                .isEqualTo(new Records.ConverterResultMessage(
                        "Error: проверьте названия единиц измерения на соответствие -  bits, Byte, KB, MB, GB, TB, PB, "
                ));
    }
}
