package kompetencesystem.domæne;

public class Medarbejder {

	private String navn;
	private String email;
	private String afdeling;

	public Medarbejder(String navn, String email, String afdeling) {
		this.navn = new String(navn);
		this.email = new String(email);
		this.afdeling = new String(afdeling);

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAfdeling() {
		return afdeling;
	}

	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}

	@Override
	public String toString() {
		return "Medarbejder [navn=" + navn + ", email=" + email + ", afdeling=" + afdeling + "]";
	}

}
