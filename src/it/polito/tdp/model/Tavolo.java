package it.polito.tdp.model;

public class Tavolo {
	private int id;
	private int numPosti;
	private boolean occupato;
	
	public Tavolo(int id, int numPosti, boolean occupato) {
		this.id = id;
		this.numPosti = numPosti;
		this.occupato = occupato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numPosti;
		result = prime * result + (occupato ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tavolo other = (Tavolo) obj;
		if (id != other.id)
			return false;
		if (numPosti != other.numPosti)
			return false;
		if (occupato != other.occupato)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tavolo [id=" + id + ", numPosti=" + numPosti + ", occupato=" + occupato + "]";
	}
	
	
	
}
