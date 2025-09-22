package entidades.traza1;

import lombok.*;
import entidades.SucursalArticulo;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"domicilio", "empresa", "sucursalArticulos"})
@Builder
public class Sucursal {
    private Long id;
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean esCasaMatriz;
    private Domicilio domicilio;
    private Empresa empresa;
    @Builder.Default
    private Set<SucursalArticulo> sucursalArticulos = new HashSet<>();
}
