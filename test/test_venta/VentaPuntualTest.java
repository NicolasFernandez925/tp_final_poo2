package test_venta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem.IGestorSem;
import sem_PuntoDeVenta.PuntoDeVenta;
import sem_celular.ISemCelular;
import sem_celular.SemCelular;
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

	ISemCelular celular;
	IGestorSem gestor;
	
	@BeforeEach
	void setUp() throws Exception{
		idPV = 123455;
		coordenadaPV = 60552;

		hora = LocalTime.now();
		fecha = LocalDate.now();

		
		gestor = mock(GestorSem.class);
		celular = mock(SemCelular.class);
		
		pv = new PuntoDeVenta(idPV, coordenadaPV, gestor, celular);
		patente = "las123";
		horasCompradas = 4;
		
	}
	
	
	@Test
	void testRegistrarVentaPuntual() {
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		assertNotNull(vPuntual);
		
		String VentaPuntualType = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl()).getClass().getName();
		assertEquals(VentaPuntualType , vPuntual.getClass().getName());

	}

	@Test
	void testGetCantidadDeHoras() {
		int horasCompradasTest = 10;
		vPuntual = new VentaPuntual(horasCompradasTest, patente, pv, pv.asignarSiguienteNroDeControl());

		assertEquals(10, vPuntual.getCantidadDeHoras());
	}
	
	@Test
	void testGetFecha() {
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		
		assertNotNull(vPuntual.getFecha());
		assertEquals(fecha, vPuntual.getFecha());

		//modifico la fecha para obtener un resultado diferente
		fecha = fecha.plusDays(2);
		assertNotEquals(fecha, vPuntual.getFecha());		
		
	}
	
	@Test
	void testGetHora() {
		LocalTime horaTest = LocalTime.now();
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		
		assertNotEquals(horaTest, vPuntual.getHora());
		assertNotNull(vPuntual.getHora());
		
	}
	
	@Test
	void testGeneraNumeroDeControl() {
		
		vPuntual = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		assertEquals(1, vPuntual.getNroDeControl());
		
		VentaPuntual vPuntual2 = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		assertEquals(2, vPuntual2.getNroDeControl());
		
		VentaPuntual vPuntual3 = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		assertEquals(3, vPuntual3.getNroDeControl());
		
		VentaPuntual vPuntual4 = new VentaPuntual(horasCompradas, patente, pv, pv.asignarSiguienteNroDeControl());
		assertNotEquals(2, vPuntual4.getNroDeControl());
	}
}
