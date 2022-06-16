package com.goit.javacore5.calc;

import lombok.Data;

@Data
public class CalcResponse {
    private CalcRequest request;

    private int result;
}
