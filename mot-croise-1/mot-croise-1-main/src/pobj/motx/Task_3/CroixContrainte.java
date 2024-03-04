package pobj.motx.tme3;

import pobj.motx.tme2.EnsembleLettre;
import pobj.motx.tme2.GrillePotentiel;

public class CroixContrainte implements IContrainte{
	private int m1, c1, m2, c2;
	
	// Le constructeur qui initialise toutes les attributs listées ci dessus
	
	public CroixContrainte(int val1, int co1, int val2, int co2 ) {
		this.m1=val1;
		this.c1=co1;
		this.m2=val2;
		this.c2=co2;
	}
	
	@Override
	public int reduce(GrillePotentiel grpot) {
		int cp1=0, cp2=0;
		EnsembleLettre l1 = new EnsembleLettre();
		l1 = grpot.getMotsPot().get(m1).getEnsembleLettre(c1);
		EnsembleLettre l2 = new EnsembleLettre();
		l2 = grpot.getMotsPot().get(m2).getEnsembleLettre(c2);
		EnsembleLettre l = new EnsembleLettre();
		l = l1.intersection(l2);
		if (l.Size()< l1.Size()) {
			cp1=grpot.getMotsPot().get(m1).filtrerdic(c1, l);
		}
		if (l.Size()< l2.Size()) {
			cp2=grpot.getMotsPot().get(m2).filtrerdic(c2, l);
		}
		return cp1+cp2; 
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CroixContrainte))
			return false;
		CroixContrainte cx = (CroixContrainte)o;
		return (cx.m1==m1 && cx.m2==m2 && cx.c1==c1 && cx.c2==c2);
	}

}
