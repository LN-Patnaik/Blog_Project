package com.example.BlogComponent.Exception;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorDetail {
    private String errorMSg;
    private String errorCode;
    private Date timeStamp;
}
