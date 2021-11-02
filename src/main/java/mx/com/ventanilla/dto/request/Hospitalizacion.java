package mx.com.ventanilla.dto.request;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Hospitalizacion {
   private String fechaHospitalizacion;
   private String padecimiento;
   private Domicilio domicilio;
}
