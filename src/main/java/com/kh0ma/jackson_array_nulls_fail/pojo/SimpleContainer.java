package com.kh0ma.jackson_array_nulls_fail.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Olexander Khomenko
 */

@Data
public class SimpleContainer {
    private List<Simple> lol;
}
