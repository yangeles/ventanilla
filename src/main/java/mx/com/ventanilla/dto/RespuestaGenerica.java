package mx.com.ventanilla.dto;

import lombok.Data;

@Data
public class RespuestaGenerica {

    private Object datos;
    private boolean resultado;
    private String mensaje;

    public RespuestaGenerica(Object datos, boolean resultado, String mensaje) {
        this.datos = datos;
        this.resultado = resultado;
        this.mensaje = mensaje;
    }

    public RespuestaGenerica() {
    }
        
}
