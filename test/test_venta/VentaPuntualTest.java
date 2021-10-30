package test_venta;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_PuntoDeVenta.PuntoDeVenta;
import sem_venta.Numerador;
import sem_venta.VentaPuntual;


class VentaPuntualTest {

	PuntoDeVenta pv; 
	
	int idPV;
	int coordenadaPV;
	
	LocalTime hora;
	LocalDate fecha;
	
	//Atributos de ventaPuntual
	String patente;
	int horasCompradas;
	
	VentaPuntual vPuntual;

	@BeforeEach
	void setUp() throws Exception{
		idPV = 123455;
		coordenadaPV = 60552;

		hora = LocalTime.now();
		fecha = LocalDate.now();

		pv = new PuntoDeVenta(idPV, coordenadaPV);
		patente = "las123";
		horasCompradas = 4;
		
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, hora, fecha);
	}
	
	
	@Test
	void testRegistrarVentaPuntual() {
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, hora, fecha);
		assertNotNull(vPuntual);
		
		String VentaPuntualType = new VentaPuntual(horasCompradas, patente, pv, hora, fecha).getClass().getName();
		assertEquals(VentaPuntualType , vPuntual.getClass().getName());

	}

	@Test
	void testGetCantidadDeHoras() {
		int horasCompradasTest = 10;
		vPuntual = new VentaPuntual(horasCompradasTest, patente, pv, hora, fecha);

		assertEquals(10, vPuntual.getCantidadDeHoras());
	}
	
	@Test
	void testGetFecha() {
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, hora, fecha);
		
		assertEquals(fecha, vPuntual.getFecha());
	}
	
	@Test
	void testGetHora() {
		LocalTime horaTest = LocalTime.now();
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, horaTest, fecha);
		
		//Testeo por las horas en concreto porque la variable difiere por algunas milesimas con la hora de la venta.
		assertEquals(horaTest.getHour(), vPuntual.getHora().getHour());
	}
	
	@Test
	void testGeneraNumeroDeControl() {
		//TODO: definir como debe quedar el numerador
		Numerador.resetContador();
		
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, hora, fecha);
		assertEquals(1, vPuntual.getNroDeControl());
		
		VentaPuntual vPuntual2 = new VentaPuntual(horasCompradas, patente, pv, hora, fecha);
		assertEquals(2, vPuntual2.getNroDeControl());
	}
}
