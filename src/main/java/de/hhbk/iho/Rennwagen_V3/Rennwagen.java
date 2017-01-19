package de.hhbk.iho.Rennwagen_V3;

public class Rennwagen {
	int id;
	String modell;
	String hersteller;
	Double leistung;
	Double hubraum;
	Double maximalerTankinhalt;
	Double aktuellerTankinhalt;
	
	public Rennwagen(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModell() {
		return modell;
	}
	
	public void setModell(String modell) {
		this.modell = modell;
	}
	
	public String getHersteller() {
		return hersteller;
	}
	
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	
	public Double getLeistung() {
		return leistung;
	}
	
	public void setLeistung(Double leistung) {
		this.leistung = leistung;
	}
	
	public Double getHubraum() {
		return hubraum;
	}
	
	public void setHubraum(Double hubraum) {
		this.hubraum = hubraum;
	}
	
	public Double getMaximalerTankinhalt() {
		return maximalerTankinhalt;
	}
	
	public void setMaximalerTankinhalt(Double maximalerTankinhalt) {
		this.maximalerTankinhalt = maximalerTankinhalt;
	}
	
	public Double getAktuellerTankinhalt() {
		return aktuellerTankinhalt;
	}
	
	public void setAktuellerTankinhalt(Double aktuellerTankinhalt) {
		this.aktuellerTankinhalt = aktuellerTankinhalt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RW_");
		builder.append(id).append(',');
		builder.append(modell).append(',');
		builder.append(hersteller).append(',');
		builder.append(leistung).append(',');
		builder.append(hubraum).append(',');
		builder.append(maximalerTankinhalt).append(',');
		builder.append(aktuellerTankinhalt);
		return builder.toString();
	}
}
