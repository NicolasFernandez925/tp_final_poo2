package test_zona;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.GestorSem;
import sem.IGestorSem;
import sem_Zona.Zona;
import sem_celular.ISemCelular;
import sem_celular.SemCelular;
import sem_estacionamiento.*;
import sem_Inspector.*;
import sem_PuntoDeVenta.PuntoDeVenta;

class ZonaTest {
	
	Zona zonaCentro; 
	
	LocalTime horaFin; 
	
	String patente1;
	String patente2;
	String patente3;
	
	int celular1;
	int celular2;
	int celular3;
	
	String nombre;
	int dni;
	int id;
	
	int idPV;
	int coordenadaPV;
	
	Estacionamiento estacionamiento1;
	Estacionamiento estacionamiento2;
	Estacionamiento estacionamiento3;
	
	ArrayList<Integer> puntosGeograficos;
	
	Inspector inspector;
	
	PuntoDeVenta punto1;
	
	int coordenadaEstacionamiento;
	int coordenada;
	
	ISemCelular celular;
	IGestorSem gestor;
	
	@BeforeEach
	void setUp() throws Exception {
		zonaCentro = new Zona();
		
		//Setup datos generales
		horaFin = LocalTime.now().plusHours(5);
		celular1 = 12345;
		celular2 = 54321;
		celular3 = 97854;
		patente1 = "abc123";
		patente2 = "cba321";
		patente3 = "ewq321";
		
		//Setup datos del Inspector
		nombre = "Pedro";
		dni = 18237176;
		id = 15;
		
		//Setup punto de venta
		idPV = 1;
		coordenadaPV = 504;
		
		//Setup estacionamientos
		coordenadaEstacionamiento = 7;
		estacionamiento1 = new EstacionamientoCompraApp(patente1, horaFin,coordenadaEstacionamiento, celular1);
		estacionamiento2 = new EstacionamientoCompraApp(patente2, horaFin,coordenadaEstacionamiento, celular2);
		estacionamiento3 = new EstacionamientoCompraApp(patente3, horaFin,coordenadaEstacionamiento, celular3);
		
		//Setup puntos geograficos
		puntosGeograficos = new ArrayList<>();
		Collections.addAll(puntosGeograficos, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9, 10, 11);
		zonaCentro.setPuntosGeograficos(puntosGeograficos);
		
		inspector = new Inspector(id,nombre,dni);
		
		gestor = mock(GestorSem.class);
		celular = mock(SemCelular.class);
		
		punto1 = new PuntoDeVenta(idPV, coordenadaPV, gestor, celular);
		
		coordenada = 6;
	}
	
	@Test
	void testRegistrarEstacionamiento() {
		zonaCentro.registrarEstacionamiento(estacionamiento1);
		
		assertEquals(1, zonaCentro.cantidadDeEstacionamientos());
		assertNotEquals(0, zonaCentro.cantidadDeEstacionamientos());
		assertNotEquals(2, zonaCentro.cantidadDeEstacionamientos());
		
		zonaCentro.registrarEstacionamiento(estacionamiento2);
		zonaCentro.registrarEstacionamiento(estacionamiento3);
		
		assertEquals(3, zonaCentro.cantidadDeEstacionamientos());
	}
	
	@Test
	void testRegistrarInspector() {
		String inspector_type = new Inspector(id,nombre,dni).getClass().getName();
		zonaCentro.registrarInspector(inspector);
		assertNotNull(zonaCentro.getInspector());
		assertEquals(inspector_type, zonaCentro.getInspector().getClass().getName());
	}
	
	@Test
	void testRegistrarPuntoDeVenta() {
		zonaCentro.registrarPuntoDeVenta(punto1);
		assertNotNull(zonaCentro.getPuntosDeVenta());
		assertTrue(zonaCentro.getPuntosDeVenta().contains(punto1));
	}

	@Test
	void testSetPuntosGeograficos() {
		ArrayList<Integer> nuevosPuntosGeograficos = new ArrayList<>();
		Collections.addAll(nuevosPuntosGeograficos, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9, 10, 11);
		zonaCentro.setPuntosGeograficos(nuevosPuntosGeograficos);
		assertEquals(nuevosPuntosGeograficos, zonaCentro.getPuntosGeograficos());
	}
	
	@Test 
	void testTienePuntosGeograficos() {
		assertTrue(zonaCentro.contienePuntoGeografico(2));
	}
	
	@Test
	void testTieneEstacionamientoVigente() {
		zonaCentro.registrarEstacionamiento(estacionamiento1);
		zonaCentro.registrarEstacionamiento(estacionamiento2);
		zonaCentro.registrarEstacionamiento(estacionamiento3);
		assertTrue(zonaCentro.tieneEstacionamientoVigente(patente2));
		String patente4 = "oiu543";
		assertFalse(zonaCentro.tieneEstacionamientoVigente(patente4));
	}
	
	@Test
	void registrarPuntoGeografico() {
		zonaCentro.registrarPuntoGeografico(coordenada);
	}
}
