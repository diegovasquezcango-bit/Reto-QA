package com.nttdata.saucedemo.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.saucedemo.models.ShopData;

import java.io.InputStream;
import java.util.List;

public class JsonReader {

    public static List<ShopData> readShopData(String fileName) {
        String resourcePath = "data/" + fileName;

        try (InputStream inputStream = JsonReader.class
                .getClassLoader()
                .getResourceAsStream(resourcePath)) {

            if (inputStream == null) {
                throw new IllegalArgumentException("No se encontró el archivo JSON: " + resourcePath);
            }

            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.readValue(inputStream, new TypeReference<List<ShopData>>() {});

        } catch (Exception e) {
            throw new RuntimeException("Error al leer el archivo JSON: " + resourcePath, e);
        }
    }
}