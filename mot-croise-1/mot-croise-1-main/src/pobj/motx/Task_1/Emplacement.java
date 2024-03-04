package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	
	private List<Case> mot;
	
	public Emplacement() {
		mot = new ArrayList<Case>();
	}
	
	public void add(Case e) {
		mot.add(e);
	}
	
	public int size() {
		return mot.size();
	}
	
	public Case getCase(int i) {
		return mot.get(i);
	}
	
	@Override
	public String toString() {
		return "Le mot est" + mot.toString();
	}
	
	public boolean hasCaseVide() {
		for (Case m:mot) {
			if(m.isVide()) return true;
		}
		return false;
	}

}



