package test_zona;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_Zona.Zona;
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
	
	Estacionamiento estacionamiento1; //= new EstacionamientoCompraApp("abc123", 12345, fin);
	Estacionamiento estacionamiento2; //= new EstacionamientoCompraApp("cba312", 54321, fin);
	Estacionamiento estacionamiento3;// = new EstacionamientoCompraApp("qwe321", 87645, fin);
	
	ArrayList<Integer> puntosGeograficos;
	
	Inspector inspector;
	
	PuntoDeVenta punto1;
	
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
		
		//Setup datos del Inspectot
		nombre = "Pedro";
		dni = 18237176;
		id = 15;
		
		//Setup estacionamientos
		estacionamiento1 = new EstacionamientoCompraApp(patente1, celular1, horaFin);
		estacionamiento2 = new EstacionamientoCompraApp(patente2, celular2, horaFin);
		estacionamiento3 = new EstacionamientoCompraApp(patente3, celular3, horaFin);
		
		//Setup puntos geograficos
		puntosGeograficos = new ArrayList<>();
		Collections.addAll(puntosGeograficos, 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9, 10, 11);
		zonaCentro.setPuntosGeograficos(puntosGeograficos);
		
		inspector = new Inspector(id,nombre,dni);
		
		punto1 = new PuntoDeVenta();
		
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
}
