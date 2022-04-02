package com.icai.practicas;

import com.icai.practicas.controller.ProcessController;
import com.icai.practicas.controller.ProcessController.DataResponse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

// usado como referencia https://github.com/gitt-3-pat/ejemplos-2022/blob/main/tema-8/testing-example/src/test/java/com/example/demo/controller/LoginControllerE2ETest.java

import com.icai.practicas.controller.ProcessController;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestProcessController {
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void given_app_when_login_using_right_credentials_then_ok(){
    //Given
    String direccion="http://localhost:"+port+"/api/v1/process-step1";
    String name="Nacho Hernández";
    String dni="06011771H";
    String tel="917308155";
    ProcessController.DataRequest data=new ProcessController.DataRequest(name,dni,tel);
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data, headers);

   //When
		ResponseEntity<ProcessController.DataResponse> result = this.restTemplate.postForEntity(direccion, request, ProcessController.DataResponse.class);

		//Then
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
  }


  @Test
  public void given_app_when_login_legacy(){
    //Given
    String direccion="http://localhost:"+port+"/api/v1/process-step1-legacy";

    //Ejemplo que no debe dar error
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("fullName", "Nacho Hernández");
    map.add("dni", "06421221R");
    map.add("telefono", "9173642311");
    //Ejemplos que deben dar error
    MultiValueMap<String, String> map1 = new LinkedMultiValueMap<>();
    map.add("fullName", "");
    map.add("dni", "06421221R");
    map.add("telefono", "9173642311");
    MultiValueMap<String, String> map2 = new LinkedMultiValueMap<>();
    map.add("fullName", "Nacho Hernández");
    map.add("dni", "");
    map.add("telefono", "9173642311");
    MultiValueMap<String, String> map3 = new LinkedMultiValueMap<>();
    map.add("fullName", "Nacho Hernández");
    map.add("dni", "06421221R");
    map.add("telefono", "");

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
   
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
    HttpEntity<MultiValueMap<String, String>> request1 = new HttpEntity<>(map1, headers);
    HttpEntity<MultiValueMap<String, String>> request2 = new HttpEntity<>(map1, headers);
    HttpEntity<MultiValueMap<String, String>> request3 = new HttpEntity<>(map1, headers);

    //When
    ResponseEntity<String> result = this.restTemplate.postForEntity(direccion, request, String.class);
    ResponseEntity<String> result1 = this.restTemplate.postForEntity(direccion, request1, String.class);
    ResponseEntity<String> result2 = this.restTemplate.postForEntity(direccion, request2, String.class);
    ResponseEntity<String> result3 = this.restTemplate.postForEntity(direccion, request3, String.class);
    //Then
    then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
    then(result1.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    then(result2.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    then(result3.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
   
  }
  
}
