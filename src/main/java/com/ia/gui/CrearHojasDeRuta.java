package com.ia.gui;

import java.util.Timer;

import com.ia.controller.Controller;
import com.ia.task.TaskAsignarPedidos;

public class CrearHojasDeRuta {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		timer.schedule(new TaskAsignarPedidos(), 0, 5000);
		Controller.getInstance().pedidosDiarios();

	}

}
