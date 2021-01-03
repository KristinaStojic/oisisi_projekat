package model;

import java.io.Serializable;
import java.util.Date;

public class Ocena implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Student studentPolozio;
	protected Predmet predmet;
	protected int ocena;
	protected Date datumPolaganja;

	
	public Ocena() {
		super();
	}

	public Ocena(Student studentPolozio, Predmet predmet, int ocena, Date datumPolaganja) {
		super();
		this.studentPolozio = studentPolozio;
		this.predmet = predmet;
		this.ocena = ocena;
		this.datumPolaganja = datumPolaganja;
	}

	public Student getStudentPolozio() {
		return studentPolozio;
	}

	public void setStudentPolozio(Student studentPolozio) {
		this.studentPolozio = studentPolozio;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	@Override
	public String toString() {
		return " predmet=" + predmet;
	}
	
	
	
}
