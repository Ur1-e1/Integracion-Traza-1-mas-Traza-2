package entidades.traza1;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"pais"})
@Builder
public class Provincia {
    private Long id;
    private String nombre;
    private Pais pais;

}

