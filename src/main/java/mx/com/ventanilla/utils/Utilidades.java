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

    public static String encodingParams(String str){
         if(!Objects.isNull(str) && !str.isEmpty()){
             if(str.contains("{") || str.contains(":") || str.contains("}") || str.contains("\"")){
                str = str.replaceAll("{","%7B");
                str = str.replaceAll(":", "%3A");
                 str = str.replaceAll("}", "%7D");
                 str = str.replaceAll("\"", "%22");
             }
         }
         return str;
    }
    
}
