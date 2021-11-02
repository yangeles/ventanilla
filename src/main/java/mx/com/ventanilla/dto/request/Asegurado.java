package mx.com.ventanilla.dto.request;

import java.util.List;

@lombok.Getter
@lombok.Setter
public class Asegurado {
   private PersonaFisica personaFisica;
   private Sucursal sucursal;
   private List<Documentos> documentos;
}
