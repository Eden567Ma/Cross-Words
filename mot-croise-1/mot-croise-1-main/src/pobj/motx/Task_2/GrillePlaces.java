package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;

public class GrillePlaces {
	 private List<Emplacement> places = new ArrayList<Emplacement>() ;
	 private int nbH = 0;
	 private Grille grille;
	 private boolean hori; 

	    
	 public GrillePlaces(Grille grille){
		 	this.grille=grille;
		 	hori = true;
	    	for (int c=0; c< this.grille.nbLig(); c++) {
	    		cherchePlaces(getLig(c));
	    	}
	    	hori = false;
	    	for (int c=0; c< this.grille.nbCol(); c++) {
	    		cherchePlaces(getCol(c));
	    	}
	    	
	    }
	 
	 public List<Emplacement> getPlaces(){
		 return places;
	 }
	 
	 public Grille getGrille() {
		 return grille;
	 }
	    
	 public int getNbHorizontal() {
	    	return nbH;
	    }
	    
	    
	 private List<Case> getLig (int lig){
	    	List<Case> l = new ArrayList<Case>();
	    	for (int c=0; c< grille.nbCol(); c++) {
	    		l.add(grille.getCase(lig, c));
	    	}       	
	    	return l;
	    	}
	    
	    
	 private List<Case> getCol (int col){
	    	List<Case> l = new ArrayList<Case>();
	    	for (int c=0; c< grille.nbLig(); c++) {
	    		l.add(grille.getCase(c, col));
	    	}       	
	    	return l;
	    	}
	    
	 private void cherchePlaces(List<Case> cases) {
    	for (int c = 0; c < cases.size(); c++) {
    		if (!(cases.get(c).isPleine())) {
	    		Emplacement em = new Emplacement();
    	    	for (int d = c; d < cases.size(); d++) {
    	    		if ((cases.get(d).isPleine())) {
    	    			break;
    	    		}	    	    		
    	    		em.add(cases.get(d));
    	    		c++;

    	    	} 
    		
    		if (em.size() >= 2) {
    			places.add(em);
    			if (hori) nbH++;
    			}
    		}
    	}	    	
    }
	 
	 @Override
	 public String toString() {
		 StringBuilder c= new StringBuilder();
		 for(int i=0; i< this.getPlaces().size(); i++) {
			 for(int j=0; j < this.getPlaces().get(i).size(); j++) {
				 c.append(this.getPlaces().get(i).getCase(j).getChar());
			 }
			 c.append("   ");
		 }
		 return c.toString();		 
	 }
	 
	 public GrillePlaces fixer( int m, String soluce) {
		 Grille grillecopy = grille.copy();
		 Emplacement e = this.getPlaces().get(m);
		 for(int i=0; i < e.size(); i++) {
			 grillecopy.getCase(e.getCase(i).getLig(), e.getCase(i).getCol()).setChar(soluce.charAt(i));

		 }	
		 GrillePlaces Copy= new GrillePlaces(grillecopy);	
		 return Copy;
	 }

}
