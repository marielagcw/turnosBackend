package com.marielagcw.health_center.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {

    // ATTRIBUTES
    private String reason;
    private String message;
    private Integer code;
}
