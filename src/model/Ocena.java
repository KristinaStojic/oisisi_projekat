package model;

public class Ocena {
	protected Student studentPolozio;
	protected Predmet predmet;
	protected double ocena;
	protected String datumPolaganja;

	
	public Ocena() {
		super();
	}

	public Ocena(Student studentPolozio, Predmet predmet, double ocena, String datumPolaganja) {
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

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public String getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}
	
	
	
}
