package com.musicstore.themusicstoreapp.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musicstore.themusicstoreapp.models.Price;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new Converter<String, Price>() {
            public Price convert(MappingContext<String, Price> context) {
                return convertJsonToPrice(context.getSource());
            }
        });

        modelMapper.addConverter(new Converter<Price, String>() {
            public String convert(MappingContext<Price, String> context) {
                return convertPriceToJson(context.getSource());
            }
        });

        modelMapper.addConverter(new Converter<String[], UUID[]>() {
            public UUID[] convert(MappingContext<String[], UUID[]> context) {
                if (context.getSource() == null) return null;
                return Arrays.stream(context.getSource())
                    .map(UUID::fromString)
                    .toArray(UUID[]::new);
            }
        });

        modelMapper.addConverter(new Converter<UUID[], String[]>() {
            public String[] convert(MappingContext<UUID[], String[]> context) {
                if (context.getSource() == null) return null;
                return Arrays.stream(context.getSource())
                    .map(UUID::toString)
                    .toArray(String[]::new);
            }
        });

        modelMapper.addConverter(new Converter<String, LocalDate>() {
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                if (context.getSource() == null) return null;
                return LocalDate.parse(context.getSource());
            }
        });

        modelMapper.addConverter(new Converter<LocalDate, String>() {
            public String convert(MappingContext<LocalDate, String> context) {
                if (context.getSource() == null) return null;
                return context.getSource().toString();
            }
        });

        return modelMapper;
    }
    
    // Convert JSON string to Address object
    private Price convertJsonToPrice(String json) {
        try {
            if (json == null)
                return null;
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, Price.class); // Deserialize JSON to Price object
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert JSON to Price: " + e.getMessage(), e);
        }
    }

    // Convert Price object to JSON string
    private String convertPriceToJson(Price price) {
        if (price == null) {
            return null;
        }
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(price);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert Price to JSON: " + e.getMessage(), e);
        }
    }    
}
