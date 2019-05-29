package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import it.polito.tdp.model.Evento.TipoEvento;

public class Simulatore {
	
	//Code degli eventi
	private Queue<Evento> queue;
	
	//Stato del mondo
	private List<Tavolo> listaTavoli;
	
	//Parametri di simulazione
	private final int N_EVENTI = 2000;
	
	//Variabili interne
	Random rand = new Random();
	
	//Parametri di output
	private int numTotaleClienti;
	private int numClientiSoddisfatti;
	private int numClientiInsoddisfatti;
	
	
	public void init() {
		//Iniziliazziamo i tavoli
		listaTavoli = new ArrayList<Tavolo>();
		for (int i = 1; i <3; i++) {
			Tavolo temp = new Tavolo(i, 10, false);
			listaTavoli.add(temp);
		}
		
		for (int i = 3; i <7; i++) {
			Tavolo temp = new Tavolo(i, 8, false);
			listaTavoli.add(temp);
		}
		
		for (int i = 7; i <11; i++) {
			Tavolo temp = new Tavolo(i, 6, false);
			listaTavoli.add(temp);
		}
			
		for (int i = 11; i <16; i++) {
			Tavolo temp = new Tavolo(i, 4, false);
			listaTavoli.add(temp);
		}
		
		//Inizializziamo la coda degli eventi
		queue = new PriorityQueue<>();
		
		//La popoliamo
		int t = 0;
		queue.add(new Evento(t, TipoEvento.ARRIVO_GRUPPO_CLIENTI, rand.nextInt(10)+1, 
				rand.nextInt(61)+60, rand.nextFloat(), null));
		
		for (int i = 1; i<this.N_EVENTI; i++) {
			t += rand.nextInt(10)+1;
			queue.add(new Evento(t, TipoEvento.ARRIVO_GRUPPO_CLIENTI, rand.nextInt(10)+1, rand.nextInt(61)+60, 
				rand.nextFloat(), null));
		}
		
		numTotaleClienti = 0;
		numClientiSoddisfatti = 0;
		numClientiInsoddisfatti = 0;
	}
	
	public void run() {
		
		while (!queue.isEmpty()) {
			
			Evento ev = queue.poll();
			System.out.println(ev);
			
			switch (ev.getTipo()) {
			
			case ARRIVO_GRUPPO_CLIENTI :
				this.numTotaleClienti += ev.getNumPersone();
				
				Tavolo ottimo = new Tavolo (0, Integer.MAX_VALUE, false);
				for (Tavolo t : listaTavoli) {
					if (ev.getNumPersone() <= t.getNumPosti()) {
					if ( t.getNumPosti() < ottimo.getNumPosti() && ev.getNumPersone() >= t.getNumPosti()/2 &&
						  !t.isOccupato()) {
						ottimo = t;
					}
				}
			}
					if (ottimo.getId() != 0) {
						//Facciamo accomodare i clienti
						ottimo.setOccupato(true);

						//generiamo l'evento di out
						queue.add(new Evento(ev.getMinutoInizioEvento()+ev.getDurata(), TipoEvento.OUT_GRUPPO_CLIENTI, 
								ev.getNumPersone(), 0, 0, ottimo));
					} else {
						
						//Valutiamo la tolleranza
						float probabilità = rand.nextFloat();
						if (ev.getTolleranza() < probabilità) { 
							this.numClientiInsoddisfatti+= ev.getNumPersone();
						} else {
							queue.add(new Evento(ev.getMinutoInizioEvento()+ev.getDurata(), TipoEvento.OUT_GRUPPO_CLIENTI, 
									ev.getNumPersone(), 0, 0, null));
						}
					}
				
				break;
				
			case OUT_GRUPPO_CLIENTI :
				this.numClientiSoddisfatti+= ev.getNumPersone();
				
				if (ev.getTavolo()!= null) //Liberiamo il tavolo
					ev.getTavolo().setOccupato(false);
					
				break;
			}
		}
	}

	public List<Tavolo> getListaTavoli() {
		return listaTavoli;
	}

	public int getNumTotaleClienti() {
		return numTotaleClienti;
	}

	public int getNumClientiSoddisfatti() {
		return numClientiSoddisfatti;
	}

	public int getNumClientiInsoddisfatti() {
		return numClientiInsoddisfatti;
	}
	
	
	
}
