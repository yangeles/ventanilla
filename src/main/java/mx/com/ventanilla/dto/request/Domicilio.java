package mx.com.ventanilla.dto.request;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Domicilio {
   private String calle;
   private String numeroExt;
   private String numeroInt;
   private String colonia;
   private String codigoPostal;
   private String delegacion;
   private String municipio;
   private String estado;
   private String pais;
}
