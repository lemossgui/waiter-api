package org.example.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
    @Nullable
    private T params;

    @Nullable
    private String message;
    private String status;

    public ResponseDto(@Nullable T params) {
        this.params = params;
        this.status = StatusResponse.SUCCESS.getValue();
    }

    public ResponseDto(@Nullable String message) {
        this.message = message;
        this.status = StatusResponse.SUCCESS.getValue();
    }

    public ResponseDto(@Nullable T params, @Nullable String message) {
        this.params = params;
        this.message = message;
        this.status = StatusResponse.SUCCESS.getValue();
    }

    public ResponseDto(@Nullable T params, @Nullable String message, String status) {
        this.params = params;
        this.message = message;
        this.status = status;
    }
}
