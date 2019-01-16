package tpVol.model;

public enum TitrePhysique {
	
	M("monsieur"), MME("madame"), MLLE("mademoiselle");

	private String text;

	private TitrePhysique(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
}
