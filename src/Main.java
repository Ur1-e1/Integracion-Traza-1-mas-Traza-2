//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import entidades.traza1.*;
import entidades.traza2.*;
import entidades.SucursalArticulo;
import repositorios.InMemoryRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();
        InMemoryRepository<Sucursal> sucursalRepository = new InMemoryRepository<>();
        InMemoryRepository<Articulo> articuloRepository = new InMemoryRepository<>();
        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();
        InMemoryRepository<Imagen> imagenRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturadoDetalle> detalleRepository = new InMemoryRepository<>();
        InMemoryRepository<SucursalArticulo> sucursalArticuloRepository = new InMemoryRepository<>();


        System.out.println("--- Creando entidades de la Traza 1 ---");


        Pais argentina = new Pais();
        argentina.setNombre("Argentina");

        Provincia buenosAires = new Provincia();
        buenosAires.setNombre("Buenos Aires");
        buenosAires.setPais(argentina);

        Localidad caba = new Localidad();
        caba.setNombre("Caba");
        caba.setProvincia(buenosAires);

        Localidad laPlata = new Localidad();
        laPlata.setNombre("La Plata");
        laPlata.setProvincia(buenosAires);

        Provincia cordoba = new Provincia();
        cordoba.setNombre("Córdoba");
        cordoba.setPais(argentina);

        Localidad cordobaCapital = new Localidad();
        cordobaCapital.setNombre("Córdoba Capital");
        cordobaCapital.setProvincia(cordoba);

        Localidad villaCarlosPaz = new Localidad();
        villaCarlosPaz.setNombre("Villa Carlos Paz");
        villaCarlosPaz.setProvincia(cordoba);


        Domicilio domicilioCaba = new Domicilio();
        domicilioCaba.setCalle("Calle Falsa");
        domicilioCaba.setNumero(123);
        domicilioCaba.setCp(1000);
        domicilioCaba.setLocalidad(caba);

        Sucursal sucursalCaba = new Sucursal();
        sucursalCaba.setNombre("Sucursal CABA");
        sucursalCaba.setHorarioApertura(LocalTime.of(9, 0));
        sucursalCaba.setHorarioCierre(LocalTime.of(22, 0));
        sucursalCaba.setEsCasaMatriz(true);
        sucursalCaba.setDomicilio(domicilioCaba);
        sucursalRepository.save(sucursalCaba);

        Domicilio domicilioLaPlata = new Domicilio();
        domicilioLaPlata.setCalle("Calle Verdadera");
        domicilioLaPlata.setNumero(456);
        domicilioLaPlata.setCp(1900);
        domicilioLaPlata.setLocalidad(laPlata);

        Sucursal sucursalLaPlata = new Sucursal();
        sucursalLaPlata.setNombre("Sucursal La Plata");
        sucursalLaPlata.setHorarioApertura(LocalTime.of(10, 0));
        sucursalLaPlata.setHorarioCierre(LocalTime.of(23, 0));
        sucursalLaPlata.setEsCasaMatriz(false);
        sucursalLaPlata.setDomicilio(domicilioLaPlata);
        sucursalRepository.save(sucursalLaPlata);

        Domicilio domicilioCordobaCapital = new Domicilio();
        domicilioCordobaCapital.setCalle("Avenida Central");
        domicilioCordobaCapital.setNumero(789);
        domicilioCordobaCapital.setCp(5000);
        domicilioCordobaCapital.setLocalidad(cordobaCapital);

        Sucursal sucursalCordobaCapital = new Sucursal();
        sucursalCordobaCapital.setNombre("Sucursal Córdoba Capital");
        sucursalCordobaCapital.setHorarioApertura(LocalTime.of(9, 30));
        sucursalCordobaCapital.setHorarioCierre(LocalTime.of(22, 30));
        sucursalCordobaCapital.setEsCasaMatriz(true);
        sucursalCordobaCapital.setDomicilio(domicilioCordobaCapital);
        sucursalRepository.save(sucursalCordobaCapital);

        Domicilio domicilioVillaCarlosPaz = new Domicilio();
        domicilioVillaCarlosPaz.setCalle("Calle del Sol");
        domicilioVillaCarlosPaz.setNumero(1011);
        domicilioVillaCarlosPaz.setCp(5152);
        domicilioVillaCarlosPaz.setLocalidad(villaCarlosPaz);

        Sucursal sucursalVillaCarlosPaz = new Sucursal();
        sucursalVillaCarlosPaz.setNombre("Sucursal Villa Carlos Paz");
        sucursalVillaCarlosPaz.setHorarioApertura(LocalTime.of(11, 0));
        sucursalVillaCarlosPaz.setHorarioCierre(LocalTime.of(23, 59));
        sucursalVillaCarlosPaz.setEsCasaMatriz(false);
        sucursalVillaCarlosPaz.setDomicilio(domicilioVillaCarlosPaz);
        sucursalRepository.save(sucursalVillaCarlosPaz);


        Empresa empresa1 = new Empresa();
        empresa1.setNombre("Empresa A");
        empresa1.setRazonSocial("Empresa A S.A.");
        empresa1.setCuit(2012345678);
        empresa1.setLogo("logoA.png");
        empresa1.getSucursales().add(sucursalCaba);
        empresa1.getSucursales().add(sucursalLaPlata);
        sucursalCaba.setEmpresa(empresa1);
        sucursalLaPlata.setEmpresa(empresa1);
        empresaRepository.save(empresa1);

        Empresa empresa2 = new Empresa();
        empresa2.setNombre("Empresa B");
        empresa2.setRazonSocial("Empresa B S.R.L.");
        empresa2.setCuit(308765432);
        empresa2.setLogo("logoB.png");
        empresa2.getSucursales().add(sucursalCordobaCapital);
        empresa2.getSucursales().add(sucursalVillaCarlosPaz);
        sucursalCordobaCapital.setEmpresa(empresa2);
        sucursalVillaCarlosPaz.setEmpresa(empresa2);
        empresaRepository.save(empresa2);

        System.out.println("\n--- Creando entidades de la Traza 2 ---");


        Categoria pizzas = new Categoria();
        pizzas.setDenominacion("Pizzas");
        categoriaRepository.save(pizzas);

        Categoria sandwiches = new Categoria();
        sandwiches.setDenominacion("Sandwich");
        categoriaRepository.save(sandwiches);

        Categoria lomos = new Categoria();
        lomos.setDenominacion("Lomos");
        categoriaRepository.save(lomos);

        Categoria insumos = new Categoria();
        insumos.setDenominacion("Insumos");
        categoriaRepository.save(insumos);


        UnidadMedida kilogramos = new UnidadMedida();
        kilogramos.setDenominacion("Kilogramos");
        unidadMedidaRepository.save(kilogramos);

        UnidadMedida litros = new UnidadMedida();
        litros.setDenominacion("Litros");
        unidadMedidaRepository.save(litros);

        UnidadMedida gramos = new UnidadMedida();
        gramos.setDenominacion("Gramos");
        unidadMedidaRepository.save(gramos);


        ArticuloInsumo sal = new ArticuloInsumo();
        sal.setDenominacion("Sal");
        sal.setPrecioVenta(100.0);
        sal.setPrecioCompra(50.0);
        sal.setStockActual(20);
        sal.setStockMaximo(50);
        sal.setEsParaElaborar(true);
        sal.setCategoria(insumos);
        sal.setUnidadMedida(gramos);
        articuloRepository.save(sal);
        insumos.getArticulos().add(sal);

        ArticuloInsumo aceite = new ArticuloInsumo();
        aceite.setDenominacion("Aceite");
        aceite.setPrecioVenta(500.0);
        aceite.setPrecioCompra(250.0);
        aceite.setStockActual(15);
        aceite.setStockMaximo(30);
        aceite.setEsParaElaborar(true);
        aceite.setCategoria(insumos);
        aceite.setUnidadMedida(litros);
        articuloRepository.save(aceite);
        insumos.getArticulos().add(aceite);

        ArticuloInsumo carne = new ArticuloInsumo();
        carne.setDenominacion("Carne");
        carne.setPrecioVenta(2000.0);
        carne.setPrecioCompra(1500.0);
        carne.setStockActual(10);
        carne.setStockMaximo(20);
        carne.setEsParaElaborar(true);
        carne.setCategoria(insumos);
        carne.setUnidadMedida(kilogramos);
        articuloRepository.save(carne);
        insumos.getArticulos().add(carne);

        ArticuloInsumo harina = new ArticuloInsumo();
        harina.setDenominacion("Harina");
        harina.setPrecioVenta(200.0);
        harina.setPrecioCompra(100.0);
        harina.setStockActual(50);
        harina.setStockMaximo(100);
        harina.setEsParaElaborar(true);
        harina.setCategoria(insumos);
        harina.setUnidadMedida(kilogramos);
        articuloRepository.save(harina);
        insumos.getArticulos().add(harina);


        Imagen imagenHawaina1 = new Imagen();
        imagenHawaina1.setDenominacion("HawainaPizza1.jpg");
        imagenRepository.save(imagenHawaina1);

        Imagen imagenHawaina2 = new Imagen();
        imagenHawaina2.setDenominacion("HawainaPizza2.jpg");
        imagenRepository.save(imagenHawaina2);

        Imagen imagenHawaina3 = new Imagen();
        imagenHawaina3.setDenominacion("HawainaPizza3.jpg");
        imagenRepository.save(imagenHawaina3);

        Imagen imagenLomo1 = new Imagen();
        imagenLomo1.setDenominacion("LomoCompletoLomo1.jpg");
        imagenRepository.save(imagenLomo1);

        Imagen imagenLomo2 = new Imagen();
        imagenLomo2.setDenominacion("LomoCompletoLomo2.jpg");
        imagenRepository.save(imagenLomo2);

        Imagen imagenLomo3 = new Imagen();
        imagenLomo3.setDenominacion("LomoCompletoLomo3.jpg");
        imagenRepository.save(imagenLomo3);


        ArticuloManufacturado pizzaHawaina = new ArticuloManufacturado();
        pizzaHawaina.setDenominacion("Pizza Hawaina");
        pizzaHawaina.setPrecioVenta(800.0);
        pizzaHawaina.setDescripcion("Pizza con jamón y piña.");
        pizzaHawaina.setTiempoEstimadoMinutos(30);
        pizzaHawaina.setPreparacion("Mezclar ingredientes, amasar, hornear.");
        pizzaHawaina.setCategoria(pizzas);
        pizzaHawaina.setUnidadMedida(gramos);
        articuloRepository.save(pizzaHawaina);
        pizzas.getArticulos().add(pizzaHawaina);

        ArticuloManufacturado lomoCompleto = new ArticuloManufacturado();
        lomoCompleto.setDenominacion("Lomo Completo");
        lomoCompleto.setPrecioVenta(1200.0);
        lomoCompleto.setDescripcion("Lomo con jamón, queso, lechuga y tomate.");
        lomoCompleto.setTiempoEstimadoMinutos(20);
        lomoCompleto.setPreparacion("Cocinar carne, armar sandwich.");
        lomoCompleto.setCategoria(lomos);
        lomoCompleto.setUnidadMedida(gramos);
        articuloRepository.save(lomoCompleto);
        lomos.getArticulos().add(lomoCompleto);


        ArticuloManufacturadoDetalle detallePizzaHawaina1 = new ArticuloManufacturadoDetalle();
        detallePizzaHawaina1.setCantidad(1);
        detallePizzaHawaina1.setArticuloInsumo(sal);
        detalleRepository.save(detallePizzaHawaina1);
        pizzaHawaina.getDetalles().add(detallePizzaHawaina1);

        ArticuloManufacturadoDetalle detallePizzaHawaina2 = new ArticuloManufacturadoDetalle();
        detallePizzaHawaina2.setCantidad(2);
        detallePizzaHawaina2.setArticuloInsumo(harina);
        detalleRepository.save(detallePizzaHawaina2);
        pizzaHawaina.getDetalles().add(detallePizzaHawaina2);

        ArticuloManufacturadoDetalle detallePizzaHawaina3 = new ArticuloManufacturadoDetalle();
        detallePizzaHawaina3.setCantidad(1);
        detallePizzaHawaina3.setArticuloInsumo(aceite);
        detalleRepository.save(detallePizzaHawaina3);
        pizzaHawaina.getDetalles().add(detallePizzaHawaina3);

        ArticuloManufacturadoDetalle detalleLomoCompleto1 = new ArticuloManufacturadoDetalle();
        detalleLomoCompleto1.setCantidad(1);
        detalleLomoCompleto1.setArticuloInsumo(sal);
        detalleRepository.save(detalleLomoCompleto1);
        lomoCompleto.getDetalles().add(detalleLomoCompleto1);

        ArticuloManufacturadoDetalle detalleLomoCompleto2 = new ArticuloManufacturadoDetalle();
        detalleLomoCompleto2.setCantidad(1);
        detalleLomoCompleto2.setArticuloInsumo(aceite);
        detalleRepository.save(detalleLomoCompleto2);
        lomoCompleto.getDetalles().add(detalleLomoCompleto2);

        ArticuloManufacturadoDetalle detalleLomoCompleto3 = new ArticuloManufacturadoDetalle();
        detalleLomoCompleto3.setCantidad(1);
        detalleLomoCompleto3.setArticuloInsumo(carne);
        detalleRepository.save(detalleLomoCompleto3);
        lomoCompleto.getDetalles().add(detalleLomoCompleto3);

        System.out.println("\n--- Combinando las trazas ---");


        SucursalArticulo sa1 = new SucursalArticulo();
        sa1.setSucursal(sucursalCaba);
        sa1.setArticulo(pizzaHawaina);
        sucursalArticuloRepository.save(sa1);
        sucursalCaba.getSucursalArticulos().add(sa1);
        pizzaHawaina.getSucursalArticulos().add(sa1);

        SucursalArticulo sa2 = new SucursalArticulo();
        sa2.setSucursal(sucursalLaPlata);
        sa2.setArticulo(lomoCompleto);
        sucursalArticuloRepository.save(sa2);
        sucursalLaPlata.getSucursalArticulos().add(sa2);
        lomoCompleto.getSucursalArticulos().add(sa2);

        System.out.println("\n--- Operaciones requeridas ---");


        System.out.println("\n--- Todas las Categorías ---");
        categoriaRepository.findAll().forEach(System.out::println);


        System.out.println("\n--- Artículos Insumos ---");
        articuloRepository.findAll().stream()
                .filter(a -> a instanceof ArticuloInsumo)
                .forEach(System.out::println);


        System.out.println("\n--- Artículos Manufacturados ---");
        articuloRepository.findAll().stream()
                .filter(a -> a instanceof ArticuloManufacturado)
                .forEach(System.out::println);

        System.out.println("\n--- Buscar Artículo Manufacturado por ID ---");
        Optional<Articulo> foundArticulo = articuloRepository.findById(pizzaHawaina.getId());
        foundArticulo.ifPresent(System.out::println);


        System.out.println("\n--- Actualizar Artículo Manufacturado (Lomo Completo) ---");
        Optional<Articulo> updatedLomoOpt = articuloRepository.findById(lomoCompleto.getId());
        if (updatedLomoOpt.isPresent()) {
            ArticuloManufacturado updatedLomo = (ArticuloManufacturado) updatedLomoOpt.get();
            updatedLomo.setPrecioVenta(1500.0);
            articuloRepository.genericUpdate(updatedLomo.getId(), updatedLomo);
            System.out.println("Lomo actualizado: " + articuloRepository.findById(updatedLomo.getId()).get());
        }


        System.out.println("\n--- Eliminar Artículo Manufacturado (Pizza Hawaina) ---");
        articuloRepository.genericDelete(pizzaHawaina.getId());
        Optional<Articulo> deletedPizza = articuloRepository.findById(pizzaHawaina.getId());
        System.out.println("Pizza Hawaina eliminada: " + (!deletedPizza.isPresent()));


        System.out.println("\n--- Todas las Empresas ---");
        empresaRepository.findAll().forEach(System.out::println);

        System.out.println("\n--- Buscar Empresa por ID ---");
        Optional<Empresa> foundEmpresa = empresaRepository.findById(empresa1.getId());
        foundEmpresa.ifPresent(System.out::println);


        System.out.println("\n--- Buscar Empresa por Nombre (Empresa B) ---");
        List<Empresa> foundEmpresas = empresaRepository.genericFindByField("nombre", "Empresa B");
        foundEmpresas.forEach(System.out::println);


        System.out.println("\n--- Actualizar Empresa por ID (Empresa A) ---");
        Optional<Empresa> updatedEmpresaOpt = empresaRepository.findById(empresa1.getId());
        if (updatedEmpresaOpt.isPresent()) {
            Empresa updatedEmpresa = updatedEmpresaOpt.get();
            updatedEmpresa.setCuit(999999999);
            empresaRepository.genericUpdate(updatedEmpresa.getId(), updatedEmpresa);
            System.out.println("Empresa actualizada: " + empresaRepository.findById(updatedEmpresa.getId()).get());
        }


        System.out.println("\n--- Eliminar Empresa por ID (Empresa B) ---");
        empresaRepository.genericDelete(empresa2.getId());
        Optional<Empresa> deletedEmpresa = empresaRepository.findById(empresa2.getId());
        System.out.println("Empresa B eliminada: " + (!deletedEmpresa.isPresent()));

    }
}