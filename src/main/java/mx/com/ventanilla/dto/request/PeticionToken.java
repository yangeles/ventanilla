package mx.com.ventanilla.dto.request;

import lombok.Data;

@Data
public class PeticionToken {
    
   private boolean refresh_groups;
   private Long requested_lifetime;
}
