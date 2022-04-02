package com.icai.practicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.DNI;

import org.junit.jupiter.api.Test;


public class TestDNI{

  @Test
  public void test(){
    DNI dni_true=new DNI("06012661R");// Se crea un DNI válido
    DNI dni_false=new DNI("12345678");// Se crea un DNI incorrecto
    boolean estado_correcto=dni_true.validar(); // Se ejecta el metodo validar para ambos DNIs |correcto->false,incorrecto->true
    boolean estado_incorrecto=dni_false.validar();
    assertEquals(true, estado_correcto);// Se comprueban lkas salidas esperadas
    assertEquals(false,estado_incorrecto);
  }
}
