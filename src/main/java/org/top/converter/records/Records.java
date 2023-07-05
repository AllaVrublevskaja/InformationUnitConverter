package org.top.converter.records;

public class Records {
    public interface Message{ }
    public record StringMessage(String message) implements Message{ }
    public record ErrorMessage (String error) implements Message{ }
    public record ConverterMessage(String from, String to, Double quantity) implements Message { }
    public record ConverterResultMessage(String result) implements Message { }
}
