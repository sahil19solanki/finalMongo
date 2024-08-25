package com.mongo.finalMongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import com.mongo.finalMongo.dto.ApiResponse;


@Data
@Builder
@AllArgsConstructor
public class ApiResponse <T> {
    private boolean result;
    private String errorCode;
    private String errorDesc;
    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .result(true)
                .data(data)
                .build();
    }
    public static <T> ApiResponse<T> failure(String errorCode,String errorDesc) {
        return ApiResponse.<T>builder()
                .result(false)
                .errorCode(errorCode)
                .errorDesc(errorDesc)
                .build();
    }
}