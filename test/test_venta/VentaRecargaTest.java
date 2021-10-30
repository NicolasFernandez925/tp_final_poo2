package test_venta;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sem_PuntoDeVenta.PuntoDeVenta;
import sem_venta.VentaPuntual;
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
	
	//Atributos de ventaPuntual
	String patente;
	int horasCompradas;
	
	VentaPuntual vPuntual;
	VentaRecarga vRecarga;
	
	
	@BeforeEach
	void setUp() throws Exception{
		idPV = 123455;
		coordenadaPV = 60552;
		
		hora = LocalTime.now();
		fecha = LocalDate.now();
		LocalDate fec = LocalDate.now()
		
		
		
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
