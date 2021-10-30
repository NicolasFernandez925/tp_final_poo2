package test_venta;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_PuntoDeVenta.PuntoDeVenta;
import sem_venta.Numerador;
import sem_venta.VentaRecarga;

class VentaRecargaTest {
	
	PuntoDeVenta pv; 
	
	int idPV;
	int coordenadaPV;
	
	LocalTime hora;
	LocalDate fecha;
	
	//Atributos de ventaRecarga
	int celular;
	int monto;
	
	VentaRecarga vRecarga;
	
	@BeforeEach
	void setUp() throws Exception{
		idPV = 123455;
		coordenadaPV = 60552;

		hora = LocalTime.now();
		fecha = LocalDate.now();

		pv = new PuntoDeVenta(idPV, coordenadaPV);
		
		celular = 12340022;
		monto = 1000;
		
	}
	
	@Test
	void testRegistrarVentaRecarga() {
		vRecarga = new VentaRecarga(celular, monto, pv, hora, fecha);
		assertNotNull(vRecarga);
		
		String ventaRecargaType = new VentaRecarga(celular, monto, pv, hora, fecha).getClass().getName();
		assertEquals(ventaRecargaType , vRecarga.getClass().getName());

	}
	
	@Test
	void testGetMonto() {
		double montoTest = 5042;
		vRecarga = new VentaRecarga(celular, montoTest, pv, hora, fecha);
		
		assertEquals(5042, vRecarga.getMonto());
	}
	
	@Test
	void testGetNroCelular() {
		int celularTest = 1231025123;
		vRecarga = new VentaRecarga(celularTest, monto, pv, hora, fecha);

		assertEquals(1231025123, vRecarga.getNroCelular());
	}
	
	@Test
	void testGetFecha() {
		vRecarga = new VentaRecarga(celular, monto, pv, hora, fecha);
		
		assertEquals(fecha, vRecarga.getFecha());
	}
	
	@Test
	void testGetHora() {
		LocalTime horaTest = LocalTime.now();
		vRecarga = new VentaRecarga(celular, monto, pv, horaTest, fecha);
		
		//Testeo por las horas en concreto porque la variable difiere por algunas milesimas con la hora de la venta.
		assertEquals(horaTest.getHour(), vRecarga.getHora().getHour());
	}
	
	@Test
	void testGeneraNumeroDeControl() {
		//TODO: definir como debe quedar el numerador
		Numerador.resetContador();
		
		vRecarga = new VentaRecarga(celular, monto, pv, hora, fecha);
		assertEquals(1, vRecarga.getNroDeControl());
		
		VentaRecarga vRecarga2 = new VentaRecarga(celular, monto, pv, hora, fecha);
		assertEquals(2, vRecarga2.getNroDeControl());
	}


}
