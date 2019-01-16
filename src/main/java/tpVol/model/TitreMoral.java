package tpVol.model;

public enum TitreMoral {
	
	SA("Societe Anonyme"),SARL("Societe Anonyme a responsabilite limite");
	
	private String texte;

	private TitreMoral(String texte) {
		this.texte = texte;
	}

	public String getTexte() {
		return texte;
	}

}
