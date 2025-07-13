package com.data.center.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> {
    private T data;
    private String message;
    private int code;

    public static <T> BaseResponse<T> of(T data, String message, int code) {
        return BaseResponse.<T>builder()
                .data(data)
                .message(message)
                .code(code)
                .build();
    }
}
