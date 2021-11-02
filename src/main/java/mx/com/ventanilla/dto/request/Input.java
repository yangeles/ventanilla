package mx.com.ventanilla.dto.request;

import lombok.Data;
import java.util.List;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class Input {
   private List<ObjetoInput> input;
}
