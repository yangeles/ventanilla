package mx.com.ventanilla.dto.request;

import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Beneficiarios {
   private PersonaFisica personaFisica;
   private String formaPago;
   private Long porcentaje;
   private boolean esPreferente;
   private List<Documentos> documentos;
}
