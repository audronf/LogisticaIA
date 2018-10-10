package com.ia.task;

import java.util.TimerTask;

import com.ia.controller.Controller;

public class TaskAsignarPedidos extends TimerTask {

	@Override
	public void run() {
		Controller.getInstance().pedidosDiarios();
		System.out.println("SE GENERARON LAS HOJAS DE RUTA DEL DÍA");

	}

}
