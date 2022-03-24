package com.dl.MoneyApi.models.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@NoArgsConstructor
public class ResponsePadrao {

    private String timestamp = "";
    private Integer status;
    private String error;
    private String path;
    private Object content;

    public ResponsePadrao(Integer statusCode, String mensagem, String caminho) {

        DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date date = new Date();

        this.timestamp = timestamp.format(date);
        this.status = statusCode;
        this.error = mensagem;
        this.path = caminho;
    }

    public ResponsePadrao(Integer statusCode, String mensagem, String caminho, Object object) {

        DateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date date = new Date();

        this.timestamp = timestamp.format(date);
        this.status = statusCode;
        this.error = mensagem;
        this.path = caminho;
        this.content = object;
    }
}