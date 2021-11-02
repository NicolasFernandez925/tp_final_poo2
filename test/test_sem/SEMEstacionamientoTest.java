package test_sem;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.SEMEstacionamiento;
import sem_Zona.Zona;
import sem_estacionamiento.Estacionamiento;

class SEMEstacionamientoTest {
	
	List<Zona> zonas;
	String patente;
	int nroCelular;
	Zona zona1;
	Zona zona2;
	
	Estacionamiento estacionamiento1;
	Estacionamiento estacionamiento2;
	
	SEMEstacionamiento sutEstacionamientoSem;

	@BeforeEach
	void setUp() throws Exception {
		
		zona1 = mock(Zona.class);
		zona2 = mock(Zona.class);
		
		estacionamiento1 = mock(Estacionamiento.class);
		estacionamiento2 = mock(Estacionamiento.class);
		
		patente = "YQT783";
		nroCelular = 17261261;
		
		sutEstacionamientoSem = new SEMEstacionamiento();
		
		sutEstacionamientoSem.agregarZona(zona1);
		sutEstacionamientoSem.agregarZona(zona2);

	}

	@Test
	void testTieneEstacionamientoVigente() {
		when(zona1.tieneEstacionamientoVigente(patente)).thenReturn(true);
		when(zona2.tieneEstacionamientoVigente(patente)).thenReturn(true);
		assertTrue(sutEstacionamientoSem.tieneEstacionamientoVigente(patente));
	}
	
	@Test
	void testCantidadDeZonasEs2() {		
		assertEquals(sutEstacionamientoSem.cantidadDeZonas() , 2);
	}
	
	@Test
	void testElInspectorConsultaSiElEstacionamientoQueTieneAasignadoEstaVigente() {
		int idInspector = 10;
		
		ArrayList<Estacionamiento> estacionamientos = new ArrayList<Estacionamiento>();
		
		estacionamientos.add(estacionamiento1);
		estacionamientos.add(estacionamiento2);
		
		when(zona1.tieneAsignadoElInspector(idInspector)).thenReturn(true);
		when(zona2.tieneAsignadoElInspector(idInspector)).thenReturn(false);
		
		when(zona1.getEstacionamientos()).thenReturn(estacionamientos);
		
		when(estacionamiento1.estacionamientoVigente()).thenReturn(true);
		when(estacionamiento2.estacionamientoVigente()).thenReturn(false);
		
		when(estacionamiento1.getPatente()).thenReturn(patente);
		when(estacionamiento2.getPatente()).thenReturn(patente);
		
		assertTrue(sutEstacionamientoSem.consultarEstacionamiento(patente, idInspector));
	}
	
	@Test
	void testBuscaElUnEstacionamientoVigenteDevolviendoDichoEstacionamientoOK() throws Exception {		
		ArrayList<Estacionamiento> estacionamientosZona1 = new ArrayList<Estacionamiento>();
		ArrayList<Estacionamiento> estacionamientosZona2 = new ArrayList<Estacionamiento>();
		
		estacionamientosZona1.add(estacionamiento1);
		estacionamientosZona2.add(estacionamiento2);
		
		when(zona1.getEstacionamientos()).thenReturn(estacionamientosZona1);
		when(zona2.getEstacionamientos()).thenReturn(estacionamientosZona2);
		
		when(estacionamiento1.estacionamientoVigente()).thenReturn(true);
		when(estacionamiento2.estacionamientoVigente()).thenReturn(false);
		
		when(estacionamiento1.getPatente()).thenReturn(patente);
		when(estacionamiento2.getPatente()).thenReturn(patente);
	
		when(estacionamiento1.sonNumerosIguales(nroCelular)).thenReturn(true);
		when(estacionamiento2.sonNumerosIguales(nroCelular)).thenReturn(false);
			
		assertEquals(sutEstacionamientoSem.buscarEstacionamientoVigente(nroCelular) , estacionamiento1);
	}
	
	@Test
	void testBuscaElUnEstacionamientoVigenteConErrorPorNoTenerNingunoAsociadoAlNroCelular() throws Exception {	
		
		ArrayList<Estacionamiento> estacionamientosZona1 = new ArrayList<Estacionamiento>();
		ArrayList<Estacionamiento> estacionamientosZona2 = new ArrayList<Estacionamiento>();
		
		estacionamientosZona1.add(estacionamiento1);
		estacionamientosZona2.add(estacionamiento2);
		
		when(zona1.getEstacionamientos()).thenReturn(estacionamientosZona1);
		when(zona2.getEstacionamientos()).thenReturn(estacionamientosZona2);
		
		when(estacionamiento1.estacionamientoVigente()).thenReturn(true);
		when(estacionamiento2.estacionamientoVigente()).thenReturn(false);
		
		when(estacionamiento1.getPatente()).thenReturn(patente);
		when(estacionamiento2.getPatente()).thenReturn(patente);
	
		when(estacionamiento1.sonNumerosIguales(nroCelular)).thenReturn(false);
		when(estacionamiento2.sonNumerosIguales(nroCelular)).thenReturn(false);
		
		assertThrows(Exception.class, 
            	() -> sutEstacionamientoSem.buscarEstacionamientoVigente(nroCelular));		
	}
	
	@Test
	void testCantidadDeEstacionamientosEnLasZonas() {	
		
		ArrayList<Estacionamiento> estacionamientosZona1 = new ArrayList<Estacionamiento>();
		ArrayList<Estacionamiento> estacionamientosZona2 = new ArrayList<Estacionamiento>();
		
		estacionamientosZona1.add(estacionamiento1);
		estacionamientosZona2.add(estacionamiento2);
		
		when(zona1.cantidadDeEstacionamientos()).thenReturn(1);
		when(zona2.cantidadDeEstacionamientos()).thenReturn(1);
		
		assertEquals(sutEstacionamientoSem.cantidadDeEstacionamientos() , 2);
	}
	
	@Test
	void testGetZonas(){	
		List<Zona> zonasEsperadas = new ArrayList<Zona>();
		
		zonasEsperadas.add(zona1);
		zonasEsperadas.add(zona2);

		assertEquals(sutEstacionamientoSem.getZonas() , zonasEsperadas);
	}
	
	@Test
	void testFinalizarTodosLosEstacionamientosDeLasZonasSoloFinalizaElEstacionamiento1PorEstarVigente(){	
		LocalTime horaFinJornada = LocalTime.of(20, 00);
		
		ArrayList<Estacionamiento> estacionamientosZona1 = new ArrayList<Estacionamiento>();
		ArrayList<Estacionamiento> estacionamientosZona2 = new ArrayList<Estacionamiento>();
		
		estacionamientosZona1.add(estacionamiento1);
		estacionamientosZona2.add(estacionamiento2);
		
		when(zona1.getEstacionamientos()).thenReturn(estacionamientosZona1);
		when(zona2.getEstacionamientos()).thenReturn(estacionamientosZona2);
		
		when(estacionamiento1.estacionamientoVigente()).thenReturn(true);
		when(estacionamiento2.estacionamientoVigente()).thenReturn(false);
		
		sutEstacionamientoSem.finalizarTodosLosEstacionamientos(horaFinJornada);
		verify(estacionamiento1).finalizar(horaFinJornada);
	}
	
	@Test
	void testEstaDentroDeUnaZonaConLaCoordenada(){	
		int coordenada = 100;
		when(zona1.contienePuntoGeografico(coordenada)).thenReturn(true);
		assertTrue(sutEstacionamientoSem.estaDentroDeUnaZonaConLaCoordenada(coordenada));
	}
	
	@Test
	void testEstEnElMismoPuntoGeograficoDeDondeInicioElEstacionamiento(){	
		int coordenada = 100;
		when(zona1.coincidePuntoGeografico(coordenada, patente)).thenReturn(true);
		assertTrue(sutEstacionamientoSem.estaEnElMismoPuntoGeograficoDeInicioEstaciomiento(coordenada, patente));
	}
	
	
	// En este caso registra el estacionamiento en la primer zona de la lista de zonas (zona1)
	// Debe haber almenos 1 zona para poder registrarla
	@Test
	void testRegistrarEstacionamientoEnUnaZonaRandom(){	
		sutEstacionamientoSem.registrarEstacionamiento(estacionamiento1);
		verify(zona1).registrarEstacionamiento(estacionamiento1);
	}



}
