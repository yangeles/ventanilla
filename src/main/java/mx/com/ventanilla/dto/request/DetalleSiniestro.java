package mx.com.ventanilla.dto.request;

import lombok.Data;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class DetalleSiniestro {
   private String causaMotivo;
   private String fechaInicioEnfermedad;
   private String lugarFallecimiento;
   private String ocupacionAfechaFallecimiento;
   private String tratamientoMedicoPrevio;
   private String padecimiento;
   private String informeMedico;
   private String datoAdicional1;
   private String datoAdicional2;
   private String datoAdicional3;
   private String datoAdicional4;
   private String datoAdicional5;
   private String numeroSiniestro;
   private List<Medico> medico;
}
