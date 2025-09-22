package entidades.traza2;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"articulos"})
public class Categoria {
    private Long id;
    private String denominacion;

    private Set<Articulo> articulos = new HashSet<>();
}
