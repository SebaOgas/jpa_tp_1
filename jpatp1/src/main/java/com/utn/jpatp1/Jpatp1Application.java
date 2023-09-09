package com.utn.jpatp1;

import com.utn.jpatp1.entidades.*;
import com.utn.jpatp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Jpatp1Application {

	//Repositorios necesarios para guardar todas las entidades en la base de datos H2

	@Autowired
	ClienteRepo clienteRepository;

	@Autowired
	RubroRepo rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(Jpatp1Application.class, args);
	}

	//Código a ejecutarse al inicio de la aplicación

	@Bean
	CommandLineRunner init(ClienteRepo clienteRepo, RubroRepo rubroRepo) {
		return args -> {
			//Creación del rubro 1

			Producto prod = Producto.builder()
					.tipo("manufacturado")
					.tiempoEstimadoCocina(20)
					.denominacion("Sopa")
					.precioVenta(400)
					.receta("No sé jaja")
					.build();

			Producto prod2 = Producto.builder()
					.tipo("manufacturado")
					.tiempoEstimadoCocina(30)
					.denominacion("Guiso")
					.precioVenta(350)
					.receta("No sé tampoco jaja")
					.build();

			Rubro rubro = Rubro.builder()
					.denominacion("Rubro 1")
					.build();

			rubro.addProducto(prod);
			rubro.addProducto(prod2);

			rubroRepository.save(rubro);


			//Creación del pedido 1

			DetallePedido dp = DetallePedido.builder()
					.cantidad(2)
					.subtotal(549.99)
					.producto(prod)
					.build();

			DetallePedido dp2 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(750)
					.producto(prod2)
					.build();

			Factura factura = new Factura();
			factura.setNumero(10);
			factura.setDescuento(0.3);
			factura.setTotal(99);
			factura.setFecha(new Date());
			factura.setFormaPago("Crédito");

			Pedido p = Pedido.builder()
					.estado("iniciado")
					.fecha(new Date())
					.tipoEnvio("retira")
					.total(1299.99)
					.factura(factura)
					.build();

			p.addDetallePedido(dp);
			p.addDetallePedido(dp2);


			//Creación del pedido 2

			DetallePedido dp3 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(1000)
					.producto(prod)
					.build();

			Factura factura2 = Factura.builder()
					.numero(11)
					.descuento(0.1)
					.total(900)
					.fecha(new Date())
					.formaPago("Efectivo")
					.build();

			Pedido p2 = Pedido.builder()
					.estado("preparacion")
					.fecha(new Date())
					.tipoEnvio("delivery")
					.total(900)
					.factura(factura2)
					.build();

			p2.addDetallePedido(dp3);


			//Creación de los domicilios del Cliente 1

			Domicilio domi = Domicilio.builder()
					.calle("San Martín")
					.numero("553")
					.localidad("Godoy Cruz")
					.build();

			Domicilio domi2 = Domicilio.builder()
					.calle("9 de Julio")
					.numero("230")
					.localidad("Mendoza")
					.build();


			//Creación del Cliente 1

			Cliente cli = Cliente.builder()
					.nombre("Francisco")
					.apellido("Fernandez")
					.email("mailinventado@mail.com")
					.telefono("2612345678")
					.build();

			cli.addPedido(p);
			cli.addPedido(p2);
			cli.addDomicilio(domi);
			cli.addDomicilio(domi2);

			clienteRepository.save(cli);

			Cliente cr = clienteRepository.findById(cli.getId()).orElse(null);
			if (cr != null) {
				System.out.println("\n\nDatos del cliente de id: " + cr.getId());
				System.out.println("\tNombre y apellido: " + cr.getNombre() + " " + cr.getApellido());
				System.out.println("\tE-mail: " + cr.getEmail());
				System.out.println("\tTeléfono: " + cr.getTelefono());

				System.out.println("\n\tDomicilios:");
				for (Domicilio crd : cr.getDomicilios()) {
					System.out.println("\t\tLocalidad: " + crd.getLocalidad());
					System.out.println("\t\tCalle y número: " + crd.getCalle() + " " + crd.getNumero());
					System.out.println("\n");
				}

				System.out.println("\n\tPedidos:");
				for (Pedido crp : cr.getPedidos()) {
					System.out.println("\t\tFecha: " + crp.getFecha());
					System.out.println("\t\tEstado: " + crp.getEstado());
					System.out.println("\t\tTipo de envío: " + crp.getTipoEnvio());

					System.out.println("\n\t\tFactura:");
					Factura crpf = crp.getFactura();
					System.out.println("\t\t\tNúmero: " + crpf.getNumero());
					System.out.println("\t\t\tFecha: " + crpf.getFecha());
					System.out.println("\t\t\tDescuento: " + crpf.getDescuento());
					System.out.println("\t\t\tForma de pago: " + crpf.getFormaPago());
					System.out.println("\t\t\tTotal: " + crpf.getTotal());
					System.out.println("\t\tTotal: " + crp.getTotal());

					System.out.println("\n\t\tDetalles del pedido");
					for (DetallePedido crpdp : crp.getDetallesPedido()) {
						System.out.println("\t\t\tCantidad: " + crpdp.getCantidad());
						System.out.println("\t\t\tSubtotal: " + crpdp.getSubtotal());
						System.out.println("\t\t\tProducto:");
						Producto crpdpp = crpdp.getProducto();
						System.out.println("\t\t\t\tDenominación: " + crpdpp.getDenominacion());
						System.out.println("\t\t\t\tPrecio de venta: " + crpdpp.getPrecioVenta());
						System.out.println("\n");
					}
					System.out.println("\n");

				}
			}

			System.out.println("\n\nRubros:");
			for (Rubro r : rubroRepository.findAll()) {
				System.out.println("\tDenominación: " + r.getDenominacion());
				System.out.println("\tProductos: ");
				for (Producto rp : r.getProductos()) {
					System.out.println("\t\tTipo: " + rp.getTipo());
					System.out.println("\t\tTiempo estimado de cocina: " + rp.getTiempoEstimadoCocina());
					System.out.println("\t\tDenominación: " + rp.getDenominacion());
					System.out.println("\t\tPrecio de venta: " + rp.getPrecioVenta());
					System.out.println("\t\tPrecio de compra: " + rp.getPrecioCompra());
					System.out.println("\t\tStock actual: " + rp.getStockActual());
					System.out.println("\t\tStock mínimo: " + rp.getStockMinimo());
					System.out.println("\t\tUnidad de medida: " + rp.getUnidadMedida());
					System.out.println("\t\tReceta: " + rp.getReceta());
					System.out.println("\n");
				}
				System.out.println("\n");
			}
		};

	}
}
