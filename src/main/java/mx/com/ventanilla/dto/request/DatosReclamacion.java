package mx.com.ventanilla.dto.request;

import lombok.Data;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class DatosReclamacion {
   private String fechaReporteSiniestro;
   private String cobertura;
   private String tipoSiniestro;
   private String causaSiniestro;
   private String fechaPrescripcion;
   private String descripcionAccidenteOEnfermedad;
   private String descripcionEstudiosLaboratorio;
   private String fechaOcurrido;
   private String fechaIngresoModulo;
   private DetalleSiniestro detalleSiniestro;
   private LugarSiniestro lugarSiniestro;
   private List<Documentos> documentos;
   private Hospitalizacion hospitalizacion;
}
