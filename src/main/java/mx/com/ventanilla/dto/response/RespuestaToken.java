package mx.com.ventanilla.dto.response;

import lombok.Data;

@Data
public class RespuestaToken {

    private String expiration;
    private CharSequence csrf_token;

}
