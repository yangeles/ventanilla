package mx.com.ventanilla.dto.request;

import lombok.Data;

@Data
public class PersonaFisica {
   private String nombre;
   private String apellidoPaterno;
   private String apellidoMaterno;
   private String genero;
   private String fechaNacimiento;
   private String paisNacimiento;
   private String ciudadNacimiento;
   private String nacionalidad;
   private String rfc;
   private String curp;
   private String parentesco;
   private String ocupacion;
   private String correoElectronico;
   private String telefono;
   private String observaciones;
   private DatosBancarios datosBancarios;
   private Domicilio domicilio;
   
   
   
   
}
