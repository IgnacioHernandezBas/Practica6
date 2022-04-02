package com.icai.practicas;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.icai.practicas.model.Telefono;

import org.junit.jupiter.api.Test;

public class TestTEL {
  
  @Test
  public void test(){
    //Al igual que con el caso anterior se va a a proceder a probar si el método validar de la clase teléfono funciona correctamente
    Telefono tel=new Telefono("917354771");
    Telefono tel_prefijo=new Telefono("+34609383571");

    boolean estado_f=tel.validar();
    boolean estado_p=tel_prefijo.validar();

    assertEquals(true, estado_f);
    assertEquals(true, estado_p);

    //Se insertan teléfonos erróneo
    Telefono tel_error=new Telefono("917345771000");  
    boolean estado_f_error=tel_error.validar();
    Telefono tel_error_prefijo=new Telefono("+34917345771000");
    boolean estado_p_error=tel_error_prefijo.validar();

    assertEquals(false, estado_f_error);
    assertEquals(false, estado_p_error);
 
  }
}
