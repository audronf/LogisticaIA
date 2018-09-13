package com.ia.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.ia.controller.*;

@Controller
public class SpringController {
 
	@GetMapping()
	public void altaPedido(int codigoPedido) {
		/* Convertir el código en un PedidoDTO */
		/* Mandarle el ClienteDTO, DireccionDTO, DistribuidorDTO y los datos al método altaPedido del Controller */
	}
	
	@GetMapping("/consultarPedido")
	public String getEstadoPedido(int codigoPedido) {
		String estado = com.ia.controller.Controller.getInstance().getEstadoPedido(codigoPedido);
		return estado;
	}
}
