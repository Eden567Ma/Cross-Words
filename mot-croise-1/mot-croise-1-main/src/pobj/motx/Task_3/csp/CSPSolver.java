package pobj.motx.tme3.csp;

import java.util.List;

public class CSPSolver implements ICSP, IVariable {

	//private static final CSPSolver vi = null;
	private ICSP problm;

	public ICSP solve(ICSP problem) {
		
		this.problm=problem;
		
		
		System.out.println("Solve : \n" + problem);
		
		
		// Condition terminale : succès
		
		
		if (problem.getVars().isEmpty()) {
			System.out.println("Problème résolu.");			
			return problem;
		}
		
		
		// condition terminale : échec sur cette branche
		
		
		if (!problem.isConsistent()) {
			System.out.println("Problème invalide.");
			return problem;
		} else {
			System.out.println("Problème valide.");
		}
		
		
		// On choisit une variable arbitraire, ici la première
		// On est garantis que ! getVars().isEmpty(), testé au dessus
		
		
		IVariable vi = problem.getVars().get(0);

		ICSP next = null;
		
		
		// On est garantis que toute variable a un domaine non nul
		
		
		for (String val : vi.getDomain()) {
			System.out.println("Fixe var :" + vi + " à " + val);
			next = problem.assign(vi, val);
			next = solve(next);
			if (next.isConsistent()) {
				return next;
			} else {
				System.out.println("Essai valeur suivante.");
			}
		}
		System.out.println("Backtrack sur variable "+ vi);
		return next;
	}

	@Override
	public List<String> getDomain() {
		
		return (List<String>) ((IVariable) problm.getVars()).getDomain();				   
	}

	@Override
	public List<IVariable> getVars() {
		
		return problm.getVars();
	}

	@Override
	public boolean isConsistent() {
		
		return problm.isConsistent();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		return problm.assign(vi, val);
		
	}

}
