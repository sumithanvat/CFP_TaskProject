package com.bridgelabz.SpringBootTask.dto;

public class ResponceDTO {
public String message;
public Object data;

    public ResponceDTO(String message, Object data) {
        this.message= message;
        this.data = data;
    }
}
