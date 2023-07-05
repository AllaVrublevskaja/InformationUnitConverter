package org.top.converter.service;

import org.springframework.stereotype.Service;
import org.top.converter.records.Records;

import java.util.Arrays;
import java.util.List;

@Service
public class InformationUnitConverter  implements InformationConverter{
    @Override
    public Records.ConverterResultMessage converter(Records.ConverterMessage inputData) {
        String result="";
        String from = inputData.from();
        String to = inputData.to();
        Double quantity = inputData.quantity();
        Double outputValue = quantity;
        List<String> nameUnit = Arrays.asList("bits","Byte", "KB", "MB", "GB", "TB", "PB");
        List<Integer> valueUnit = Arrays.asList(0,8,1024,1024,1024,1024,1024);
        if(nameUnit.contains(from) && nameUnit.contains(to) && quantity >= 0){
            int indFrom = nameUnit.indexOf(from);
            int indTo = nameUnit.indexOf(to);
            if (indFrom < indTo)
                for (int i = indFrom+1; i <= indTo; i++)
                    outputValue /= valueUnit.get(i);
             else
                for (int i = indFrom; i > indTo; i--)
                    outputValue *= valueUnit.get(i);

            result = String.valueOf(outputValue);

        }  else
            if (quantity < 0)
                result = "Error: отрицательное количество единиц";
            else {
                String name = "";
                for (String s: nameUnit)
                    name += s+", ";
                result = "Error: проверьте названия единиц измерения на соответствие -  "+
                        name;
            }
        return new Records.ConverterResultMessage(result);
    }
}
