package com.SpringBoot2025_W2.advices;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class API_Response<T>
{
    private LocalDateTime timeStamp;
    private T data;
    private APIError error;

    public API_Response()
    {
        this.timeStamp=LocalDateTime.now();
    }

    public API_Response(T data)
    {
        this();
        this.data=data;
    }

    public API_Response(APIError error)
    {
        this();
        this.error=error;
    }

}
