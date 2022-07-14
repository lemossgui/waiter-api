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
    private T params;

    @Nullable
    private String message;
    private String status;

    public ResponseDto(T params) {
        this.params = params;
        this.status = ResponseStatus.SUCCESS.getValue();
    }

    public ResponseDto(T params, @Nullable String message) {
        this.params = params;
        this.message = message;
        this.status = ResponseStatus.SUCCESS.getValue();
    }

    public ResponseDto(T params, String message, String status) {
        this.params = params;
        this.message = message;
        this.status = status;
    }
}
