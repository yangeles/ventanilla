package mx.com.ventanilla.dto.request;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class DatosBancarios {
   private String banco;
   private String tipoCuenta;
   private String codigoBanco;
   private String plaza;
   private String sucursal;
   private String numeroClabeInterbancaria;
   private String numeroCuenta;
}
