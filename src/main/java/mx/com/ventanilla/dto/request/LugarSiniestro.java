package mx.com.ventanilla.dto.request;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class LugarSiniestro {
   private String tipoEntrada;
   private String tipoTramite;
   private String numReclamacion;
   private String coberturaReclamada;
   private String siniestrosAsociadosAsegurado;
   private Domicilio domicilio;
}
