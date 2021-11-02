package mx.com.ventanilla.dto.request;

import lombok.Data;

@Data
public class Poliza {
   private String numeroPoliza;
   private String numeroCertificado;
   private String producto;
   private String subproducto;
   private String estatusPoliza;
   private String estatusPagoPoliza;
   private String fechaInicioVigencia;
   private String fechaFinVigencia;
}
