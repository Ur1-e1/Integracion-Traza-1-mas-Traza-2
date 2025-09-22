package entidades.traza2;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;

    private ArticuloInsumo articuloInsumo;
}

