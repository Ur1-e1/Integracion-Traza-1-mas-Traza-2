package entidades;

import lombok.*;
import entidades.traza1.Sucursal;
import entidades.traza2.Articulo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"sucursal", "articulo"})
public class SucursalArticulo {
    private Long id;
    private Sucursal sucursal;
    private Articulo articulo;
}
