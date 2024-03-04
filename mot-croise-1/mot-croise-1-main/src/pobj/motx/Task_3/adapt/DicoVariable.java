package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme3.GrilleContrainte;
import pobj.motx.tme3.csp.IVariable;

public class DicoVariable implements IVariable {

	private int index;
	private GrilleContrainte gp ;
	
	
	@Override
	public List<String> getDomain() {
		return gp.getMotsPot().get(index).getmots();
	}
	
	public DicoVariable(int index, GrilleContrainte gp) {
		
		this.index=index;
		this.gp=gp;
	}
	
	public String toString() {
		return getDomain().toString() ;		
	}
	
	public int getIndex() {
		return index;
	}
	

}
