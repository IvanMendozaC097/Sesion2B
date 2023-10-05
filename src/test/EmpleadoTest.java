package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;

class EmpleadoTest {
		
	private float ventaMes, horasExtras;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");
		ventaMes = 1800;
		horasExtras = 1;
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");
	}

	@Test
	void testCalculoNominaBrutaEncargado() {
		float valorEsperado = 2730;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventaMes, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaVendedor() {
		float valorEsperado = 2230;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Vendedor, ventaMes, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaOtro() {
		float valorEsperado = -1;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Otro, ventaMes, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesNegativa() {
		float valorEsperado = -1;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, -10, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMenor1000() {
		float valorEsperado = 2530;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 200, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesEntre1000Y1500() {
		float valorEsperado = 2630;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1200, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaVentasMesMayor1500() {
		float valorEsperado = 2730;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, 1800, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtrasPositivas() {
		float valorEsperado = -1;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventaMes, -30);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaBrutaHorasExtrasNegativas() {
		float valorEsperado = 2730;
		float valorObtenido = Empleado.calculoNominaBruta(Empleado.TipoEmpleado.Encargado, ventaMes, horasExtras);
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	void testCalculoNominaNetaNegativa() {
		float valorEsperado = -1;
		float valorObtenido = Empleado.calculoNominaNeta(-2000);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaNetaMenor2100() {
		float valorEsperado = 2000;
		float valorObtenido = Empleado.calculoNominaNeta(2000);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaNetaEntre2100y2500() {
		float valorEsperado = 1870;
		float valorObtenido = Empleado.calculoNominaNeta(2200);
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	void testCalculoNominaNetaMayor2500() {
		float valorEsperado = 2214;
		float valorObtenido = Empleado.calculoNominaNeta(2700);
		assertEquals(valorEsperado, valorObtenido);
	}

}
