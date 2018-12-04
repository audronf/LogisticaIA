package com.ia.spring;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ia.controller.*;
import com.ia.dto.ClienteDTO;
import com.ia.dto.DireccionDTO;
import com.ia.dto.DistribuidorDTO;
import com.ia.dto.LocalidadDTO;
import com.ia.dto.PedidoDTO;

@Controller
public class SpringController {
 
	@RequestMapping(value = "/altaPedido", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ParsePedidoDTO> altaPedido(@RequestBody String wo) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HHmm:ssZ").create();
        ParsePedidoDTO pedido = gson.fromJson(wo, ParsePedidoDTO.class);

        
      
        ClienteDTO cliente = new ClienteDTO(pedido.getCliente().getCuil_cuit_dni(), pedido.getCliente().getNombreYApellido_RazonSocial(), pedido.getCliente().getEmail());
        LocalidadDTO localidad = new LocalidadDTO(pedido.getDireccion().getLocalidad());
        DireccionDTO direccion = new DireccionDTO("", "", pedido.getDireccion().getProvincia(), localidad, pedido.getDireccion().getCalle(),
        		Integer.parseInt(pedido.getDireccion().getNumero()), Integer.parseInt(pedido.getDireccion().getPiso()), pedido.getDireccion().getUnidad(), pedido.getDireccion().getEntreCalles(),
        		pedido.getDireccion().getCodigoPostal(), false);
        
        String informacion = new String();
        for (ParseItemPedidoDTO items : pedido.getItems()) {
        	informacion.concat(items.getProducto().getDescripcion());
        	informacion.concat(", ");
        }

        com.ia.controller.Controller.getInstance().altaPedido(cliente, direccion, pedido.isFragil(), informacion, pedido.isRequiereLogistica());;
        
		return new ResponseEntity<ParsePedidoDTO>(pedido, HttpStatus.OK);
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
