 package test_puntoDeVenta;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import sem.GestorSem;
import sem.IGestorSem;
import sem_PuntoDeVenta.PuntoDeVenta;
import sem_celular.ISemCelular;
import sem_celular.SemCelular;
import sem_venta.VentaPuntual;

class PuntoDeVentaTest {
	PuntoDeVenta pv;
	int coordenada;
	
	@Mock
	GestorSem gestor;
	ISemCelular celular;
	
	int horas;
	int puntoGeografico;
	int monto;
	int nroCelular;
	String patente;
	

	VentaPuntual ventaPuntual;
	
	@BeforeEach
	void setUp() throws Exception {
		gestor = mock(GestorSem.class);
		celular = mock(SemCelular.class);
		coordenada = 19120;
		
		horas = 4;
		puntoGeografico = 3;
		monto = 2000;
		nroCelular = 12035412;
		patente = "abt231";
		
		
		pv = new PuntoDeVenta(coordenada, gestor, celular);
		
		//ventaPuntual = new VentaPuntual(horas, patente, pv, coordenada);
	}
	
	@Test
	void testVenderHoras() {
		assertTrue(pv.getVentas().isEmpty());
		
		when(gestor.getGestorSem()).thenReturn(gestor);
		
		pv.venderHoras(horas, puntoGeografico, patente);
		assertFalse(pv.getVentas().isEmpty());
	}
	
	@Test 
	void testHacerRecarga() {
		assertTrue(pv.getVentas().isEmpty());
		
		when(gestor.getGestorSem()).thenReturn(gestor);

		pv.hacerRecarga(monto, nroCelular);
		assertFalse(pv.getVentas().isEmpty());
	}
	
	@Test 
	void testGetCoordenada() {
		assertEquals(coordenada,pv.getCoordenada());
	}
	
}
