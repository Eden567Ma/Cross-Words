package pobj.motx.tme3.csp;

import java.util.*;

public interface ICSP {
	
	public List<IVariable> getVars(); // pour accéder aux variables du problème,
	
	public boolean isConsistent(); // pour tester si un problème est encore satisfiable
	
    public ICSP assign(IVariable vi, String val); // pour affecter une des variables du problème.
  
}
