package com.example.jdbc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

public class JsonToXmlConverter {


    private static JsonToXmlConverter instance;


    private JsonToXmlConverter() {}


    public static JsonToXmlConverter getInstance() {
        if (instance == null) {
            instance = new JsonToXmlConverter();
        }
        return instance;
    }

    public String convertJsonToXml(String json) throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();


        Object map = jsonMapper.readValue(json, Object.class);

        return xmlMapper.writeValueAsString(map);
    }

    public String convertXmlToJson(String xml) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper jsonMapper = new ObjectMapper();


        Object map = xmlMapper.readValue(xml, Object.class);

        return jsonMapper.writeValueAsString(map);
    }
}
