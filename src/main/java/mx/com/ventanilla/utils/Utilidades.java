package mx.com.ventanilla.utils;

import mx.com.ventanilla.dto.RespuestaGenerica;

import java.util.Objects;


public class Utilidades {
    
     private Utilidades() {
        super();
    }
     
      public static RespuestaGenerica respuestaError() {
        RespuestaGenerica response = new RespuestaGenerica();
        response.setResultado(false);
        response.setMensaje(Constantes.ERROR);
        return response;
    }

    public static String encodingParams(String str) {
        if (!Objects.isNull(str) && !str.isEmpty()) {
            if (str.contains("{") || str.contains(":") || str.contains("}") || str.contains("\"") || str.contains(",")) {
                str = str.replace("{", "%7B");
                str = str.replace(":", "%3A");
                str = str.replace("}", "%7D");
                str = str.replace("\"", "%22");
                str = str.replace(",", "%2C");
            }
        }
        return str;
    }
    
}
