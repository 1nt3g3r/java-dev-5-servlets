package com.goit.javacore5.calc;

import lombok.Data;

@Data
public class CalcRequest {
    private String operation;
    private int param1;
    private int param2;
}
