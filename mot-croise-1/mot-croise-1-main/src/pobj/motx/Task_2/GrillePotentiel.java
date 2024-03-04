package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;

public class GrillePotentiel {
	private GrillePlaces gp;
	private Dictionnaire dic;
	private List<Dictionnaire> motsPot; 
	
	
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	
	public GrillePlaces getGrilleplaces() {
		return gp;
	}
	
	public Dictionnaire getDic() {
		return dic;
	}
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		motsPot = new ArrayList<Dictionnaire>();
		gp = grille;
		dic = dicoComplet;
		for (Emplacement em : gp.getPlaces()) {
			Dictionnaire copydic=dic.copy();
			copydic.filtreLongueur(em.size());
			for (int i = 0; i<em.size(); i++)
			{
				if ((!(em.getCase(i).isPleine())) && (!(em.getCase(i).isVide()))){
					copydic.filtreParLettre(em.getCase(i).getChar(), i);
				}
			}
			motsPot.add(copydic);
		}		
	}
	
	public boolean isDead() {
		for (int i =0; i<this.getGrilleplaces().getPlaces().size(); i++) {
			if (this.getMotsPot().get(i).size()==0) {
				return true;
			}
		}
		return false;
	}
	
	public GrillePotentiel fixer( int m, String soluce) {
		 GrillePotentiel gpt = new GrillePotentiel( gp.fixer(m, soluce),  dic); 
		 return gpt;
	}


}
