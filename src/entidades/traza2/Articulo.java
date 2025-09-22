package entidades.traza2;

import lombok.*;
import lombok.experimental.SuperBuilder;
import entidades.SucursalArticulo;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"imagenes", "unidadMedida", "categoria", "sucursalArticulos"})
@SuperBuilder
public abstract class Articulo {
    private Long id;
    protected String denominacion;
    protected Double precioVenta;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    private UnidadMedida unidadMedida;
    private Categoria categoria;
    @Builder.Default
    private Set<SucursalArticulo> sucursalArticulos = new HashSet<>();
}
