package bonbon;

public class BonbonHorizontal implements Bonbon{

	private String couleur;
	
	
	public BonbonHorizontal() {
		
	}
	
	public BonbonHorizontal(String couleur) {
		
		
	}
	
	

	
	
	public void explose() {
		
	}



	public String getCouleur() {
		return couleur;
	}



	public void setCouleur(String couleur) {
		if(!lesCouleurs.contains(couleur)) throw new IllegalArgumentException("Couleur incorrecte");
		else this.couleur = couleur;
	}


}
