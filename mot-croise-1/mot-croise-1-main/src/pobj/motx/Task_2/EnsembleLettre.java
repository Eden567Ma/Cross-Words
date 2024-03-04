package pobj.motx.tme2;


import java.util.ArrayList;
import java.util.List;

	public class EnsembleLettre 
	{
		List<Character> lettre;

		public EnsembleLettre()
		{
			this.lettre = new ArrayList<Character>();
		}

		public int Size()
		{
			return lettre.size();
		}
		 
		
		public void add(Character c)
		{
			if(!lettre.contains(c))
			{
				this.lettre.add(c);
			}
		}
		 
		
		public boolean contains(Character c)
		{
			return this.lettre.contains(c);
		}
		
		public EnsembleLettre intersection(EnsembleLettre l2)
		{
			EnsembleLettre l = new EnsembleLettre();
			
			for(Character c : this.lettre)
			{
				if(l2.contains(c))
				{
					l.add(c);
				}
			}
			
			return l;
		}
		
	}

