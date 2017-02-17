package datamodel;

public class Vehicul {
	
	private int nrAterstat;
	private String dataAtestat;
	private String marca;
	private String model;
	private String an;
	private String serieSasiu;
	private String serieMotor;
	private String culoare;
	private String proprietar;
	private String nrInm;
	
	public Vehicul(int nrAtestat){
		this.nrAterstat = nrAtestat;
	}

	public int getNrAterstat() {
		return nrAterstat;
	}

	public void setNrAterstat(int nrAterstat) {
		this.nrAterstat = nrAterstat;
	}

	public String getDataAtestat() {
		return dataAtestat;
	}

	public void setDataAtestat(String dataAtestat) {
		this.dataAtestat = dataAtestat;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerieSasiu() {
		return serieSasiu;
	}

	public void setSerieSasiu(String serieSasiu) {
		this.serieSasiu = serieSasiu;
	}

	public String getSerieMotor() {
		return serieMotor;
	}

	public void setSerieMotor(String serieMotor) {
		this.serieMotor = serieMotor;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public String getProprietar() {
		return proprietar;
	}

	public void setProprietar(String proprietar) {
		this.proprietar = proprietar;
	}

	public String getNrInm() {
		return nrInm;
	}

	public void setNrInm(String nrInm) {
		this.nrInm = nrInm;
	}

	public String getAn() {
		return an;
	}

	public void setAn(String an) {
		this.an = an;
	}

	@Override
	public String toString() {
		return "Vehicul [nrAterstat=" + nrAterstat + ", dataAtestat=" + dataAtestat + ", marca=" + marca + ", model="
				+ model + ", an=" + an + ", serieSasiu=" + serieSasiu + ", serieMotor=" + serieMotor + ", culoare="
				+ culoare + ", proprietar=" + proprietar + ", nrInm=" + nrInm + "]";
	}
	
	

}
