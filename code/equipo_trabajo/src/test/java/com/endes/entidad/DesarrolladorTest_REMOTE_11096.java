package com.endes.entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DesarrolladorTest {
	
	Desarrollador desarrollador;

	@BeforeEach
	void setUp() throws Exception {
		desarrollador=new Desarrollador("11111111H","Juan",1200.0,"Java");
		
	}
	

	@Test
	void testGetDNI() {
		String resultadoEsperado="11111111H";
		String resultadoObtenido=desarrollador.getDni();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	void testGetNombre() {
		String resultadoEsperado="Juan";
		String resultadoObtenido=desarrollador.getNombre();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	@Test
	void testGetSueldoBase() {
		double resultadoEsperado=1200.0;
		double resultadoObtenido=desarrollador.getSueldoBase();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	@DisplayName("Debería lanzar una excepción si el sueldo base es negativo")
	void testSetSueldoBaseNegativo() throws Exception{
		Exception exception = assertThrows(IllegalArgumentException.class, ()->desarrollador.setSueldoBase(-230));
		String mensajeEsperado = "El sueldo base no puede ser negativo.";
		assertEquals(mensajeEsperado, exception.getMessage());
	}

	@Test
	void testGetLenguajePrincipal() {
		String resultadoEsperado="Java";
		String resultadoObtenido=desarrollador.getLenguajePrincipal();
		assertEquals(resultadoEsperado, resultadoObtenido);
	}
	
	@Test
	@DisplayName("Debería lanzar una excepción si el lenguaje principal es null")
	void testSetLenguajePrincipalNull() throws Exception{
		Exception exception = assertThrows(IllegalArgumentException.class, ()->desarrollador.setLenguajePrincipal(null));
		String mensajeEsperado = "El lenguaje principal no puede ser nulo ni vacío.";
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	@Test
	@DisplayName("Debería lanzar una excepción si el lenguaje principal está vacío")
	void testSetLenguajePrincipalEmpty() throws Exception {
		Exception exception = assertThrows(IllegalArgumentException.class, ()->desarrollador.setLenguajePrincipal(" "));
		String mensajeEsperado = "El lenguaje principal no puede ser nulo ni vacío.";
		assertEquals(mensajeEsperado, exception.getMessage());
	}
	@Test
	@DisplayName("Debería calcular la productividad dependiendo del lenguaje principal")
	void testCalcularProductividad() {
		
		if(desarrollador.getLenguajePrincipal().equalsIgnoreCase("Java")||desarrollador.getLenguajePrincipal().equalsIgnoreCase("Python")) {
			double resultadoEsperado=1320;
			double resultadoObtenido=desarrollador.getSueldoBase()*1.10;
			assertEquals(resultadoEsperado, resultadoObtenido);
		}else {
			double resultadoEsperado=1200;
			double resultadoObtenido=desarrollador.getSueldoBase();
			assertEquals(resultadoEsperado, resultadoObtenido);
		}
		
		
	}


}
