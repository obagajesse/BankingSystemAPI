package com.obagajesse.BankingSystemAPI.ExceptionHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomErrorResponse {

    private int status;
    private String message;

}
