package com.kh0ma.jackson_array_nulls_fail;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.kh0ma.jackson_array_nulls_fail.pojo.SimpleContainer;

import java.io.IOException;

/**
 * @author Olexander Khomenko
 */
public class Main {
    //https://medium.com/@cowtowncoder/jackson-2-9-features-b2a19029e9ff
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDefaultSetterInfo(JsonSetter.Value.forContentNulls(Nulls.FAIL));
        String testExpectFail = "{\"lol\": [null]}";
        String testFine = "{\"lol\": [{\"name\": \"Yahoo\"}]}";
        ObjectReader objectReader = mapper.readerFor(SimpleContainer.class);
        SimpleContainer parsedFine = objectReader.readValue(testFine);
        SimpleContainer parsedFail = objectReader.readValue(testExpectFail);
        System.out.println(parsedFine);
        System.out.println(parsedFail);
    }
}
