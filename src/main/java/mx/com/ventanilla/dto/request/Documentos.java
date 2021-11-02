package mx.com.ventanilla.dto.request;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Documentos {
   private String idDocumento;
   private String nombreDocumento;
   private String estatus;
   private String idCliente;
   private String fechaCreacion;
   private String urlDocumento;
}
