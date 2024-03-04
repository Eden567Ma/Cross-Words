package pobj.motx.tme1;


public class Grille {

	 private Case[][] cases;
	 
	 
	 
	 
	 public Grille(int hauteur, int largeur) {
		 cases = new Case[hauteur][largeur];
		 for (int i=0; i < hauteur;  i++ ) {
			 for (int j=0; j < largeur;  j++) {
				 cases[i][j]=new Case(i,j,' ') ;
				 
			 } 
		 }
	 }
		 
	 public Case getCase(int lig, int col) {
		  return cases[lig][col];
	 }
	  
	 public int nbLig() {
		 return cases.length;
	 }
	 
	 public int nbCol() {
		 return cases[0].length;
	 }
	 
	 @Override
	 public String toString() {
		 StringBuilder c= new StringBuilder();
		 for (int i=0; i < this.nbLig(); i++) {
			 for (int j=0; j < this.nbCol(); j++) {
				 c.append(this.getCase(i, j).getChar());
			 }
			 c.append("\n");
		 }
		 return c.toString();
	 }
	 
	 public Grille copy() {
		 Grille GrilleCopy = new Grille(nbLig(), nbCol());	 		 
		 for (int i = 0; i < nbLig(); i++) {
			 for (int j = 0; j < nbCol(); j++) {
				 GrilleCopy.cases[i][j].setChar(this.cases[i][j].getChar());


			 }

		 }

			return GrilleCopy;
	 }

	 
	 
	 
	 
	
	
	  
} 
