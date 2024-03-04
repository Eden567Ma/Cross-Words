package pobj.motx.tme3;
import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.*;


public class GrilleContrainte extends GrillePotentiel{

	private List<IContrainte> contraintes = new ArrayList<IContrainte>();
		
	public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
		super(grille, dicoComplet);
		for (int i=0; i<this.getGrilleplaces().getNbHorizontal(); i++) {
			for (int c1=0; c1< this.getGrilleplaces().getPlaces().get(i).size(); c1++){
				for (int j=this.getGrilleplaces().getNbHorizontal(); j<this.getGrilleplaces().getPlaces().size(); j++) {
					for (int c2=0; c2< this.getGrilleplaces().getPlaces().get(j).size(); c2++){
						if ((this.getGrilleplaces().getPlaces().get(i).getCase(c1).getLig() == this.getGrilleplaces().getPlaces().get(j).getCase(c2).getLig()) && (this.getGrilleplaces().getPlaces().get(i).getCase(c1).getCol() == this.getGrilleplaces().getPlaces().get(j).getCase(c2).getCol())) {
							if (this.getGrilleplaces().getPlaces().get(i).getCase(c1).isVide()) {
								CroixContrainte cx = new CroixContrainte(i, c1, j, c2);
								cx.reduce(this);
								contraintes.add(cx);
							}
						}
					}					
				}
			}
		}
		this.propage();
	}
	
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	public GrilleContrainte fixer( int m, String soluce) {
		 GrilleContrainte gc = new GrilleContrainte( this.getGrilleplaces().fixer(m, soluce),  this.getDic()); 
		 gc.propage();
		 return gc;
	 }
	
	private boolean propage() {
		while(true) {
			int cp=0;
			for (IContrainte c : contraintes) {
				cp=cp+c.reduce(this);
			}
			if(this.isDead()) return false;
			if(cp==0) return true;
		}
	}	
}	

