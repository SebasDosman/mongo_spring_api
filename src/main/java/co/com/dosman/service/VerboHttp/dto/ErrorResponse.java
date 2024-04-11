package co.com.dosman.service.VerboHttp.dto;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ErrorResponse {
    private String error;
}
