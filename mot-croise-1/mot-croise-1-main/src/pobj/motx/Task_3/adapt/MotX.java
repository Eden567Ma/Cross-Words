package pobj.motx.tme3.adapt;

import pobj.motx.tme3.csp.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme3.*;

public class MotX implements ICSP{
	
	private GrilleContrainte gc;
	private List<IVariable> vars = new ArrayList<>() ;

	
	public MotX(GrilleContrainte gc) {
		this.gc=gc;
		for(int e=0 ; e< gc.getGrilleplaces().getPlaces().size(); e++) {
			if(gc.getGrilleplaces().getPlaces().get(e).hasCaseVide()) {
				vars.add( new DicoVariable(e , gc));
			}
		}
	}

	@Override
	public List<IVariable> getVars() {
		return vars;
	}

	@Override
	public boolean isConsistent() {
		return !gc.isDead() ;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable dc) gc=gc.fixer(dc.getIndex(), val);
		return new MotX(gc);
	}
	
	@Override 
	public String toString() {
		return gc.getGrilleplaces().getGrille().toString();
	}

}
