package it.polito.tdp.model;

public class TestSimulatore {

	public static void main(String[] args) {
		
		Simulatore sim = new Simulatore();
		sim.init();
		sim.run();
		
		System.out.format("Numero clienti totali: %d\n", sim.getNumTotaleClienti());
		System.out.format("Numero clienti soddisfatti: %d\n", sim.getNumClientiSoddisfatti());
		System.out.format("Numero clienti insoddisfatti: %d\n", sim.getNumClientiInsoddisfatti());
		
	}

}
