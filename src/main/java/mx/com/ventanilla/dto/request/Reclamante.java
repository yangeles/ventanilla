package mx.com.ventanilla.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class Reclamante {
   private PersonaFisica personaFisica;
   private List<Documentos> documentos;
}
