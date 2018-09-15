package com.ia.spring;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ia.controller.*;
import com.ia.dto.PedidoDTO;

@Controller
public class SpringController {
 
	@GetMapping()
	public void altaPedido(int codigoPedido) {
		/* Convertir el código en un PedidoDTO */
		/* Mandarle el ClienteDTO, DireccionDTO, DistribuidorDTO y los datos al método altaPedido del Controller */
	}
	
	@RequestMapping(value = "/consultarPedido/{codigoPedido}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity<PedidoDTO> getPedido(@PathVariable int codigoPedido){
		PedidoDTO pedido = com.ia.controller.Controller.getInstance().getPedido(codigoPedido);
		return new ResponseEntity<PedidoDTO>(pedido,HttpStatus.OK);
	}
}
