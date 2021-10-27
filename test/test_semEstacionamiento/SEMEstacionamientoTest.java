package test_semEstacionamiento;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem.SEMEstacionamiento;
import sem_Zona.Zona;
import sem_estacionamiento.Estacionamiento;

class SEMEstacionamientoTest {

	@Test
	void test() {
		//Instancia del SEM
		SEMEstacionamiento system = new SEMEstacionamiento();
		
		//Instancias de varias zonas
		Zona zona1 = new Zona();
		Zona zona2 = new Zona();
		Zona zona3 = new Zona();
		Zona zona4 = new Zona();
		
		// Comprobando que el SEM no tenga zonas
		assertEquals(0,system.cantidadDeZonas());
		
		// Agregando zonas en el SEM
		system.agregarZona(zona1);
		system.agregarZona(zona2);
		system.agregarZona(zona3);
		system.agregarZona(zona4);
		
		//Comprando las zonas agregadas
		assertEquals(4,system.cantidadDeZonas());
		assertNotEquals(3,system.cantidadDeZonas());
		assertNotNull(system.cantidadDeZonas());
		
	}

}
