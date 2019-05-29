package it.polito.tdp.model;

import java.time.LocalTime;

public class Evento implements Comparable<Evento> {
	
	public enum TipoEvento {
		ARRIVO_GRUPPO_CLIENTI,
		OUT_GRUPPO_CLIENTI,
		}
	
	private int minutoInizioEvento;
	private TipoEvento tipo;
	private int numPersone;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;
	
	
	public Evento(int minutoArrivo, TipoEvento tipo, int numPersone, int durata, float tolleranza, Tavolo tavolo) {
		this.minutoInizioEvento = minutoArrivo;
		this.tipo = tipo;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.tavolo = tavolo;
	}


	public int getMinutoInizioEvento() {
		return minutoInizioEvento;
	}


	public void setMinutoInizioEvento(int minutoArrivo) {
		this.minutoInizioEvento = minutoArrivo;
	}


	public TipoEvento getTipo() {
		return tipo;
	}


	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}


	public int getNumPersone() {
		return numPersone;
	}


	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}


	public int getDurata() {
		return durata;
	}


	public void setDurata(int durata) {
		this.durata = durata;
	}


	public float getTolleranza() {
		return tolleranza;
	}


	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	

	public Tavolo getTavolo() {
		return tavolo;
	}


	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}


	@Override
	public int compareTo(Evento o) {
		return this.minutoInizioEvento-o.minutoInizioEvento;
	}


	@Override
	public String toString() {
		return "Evento [minutoInizioEvento=" + minutoInizioEvento + ", tipo=" + tipo + ", numPersone=" + numPersone
				+ ", durata=" + durata + ", tolleranza=" + tolleranza + ", tavolo=" + tavolo + "]";
	}
	
	
	
	
}
