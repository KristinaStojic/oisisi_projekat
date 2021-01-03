package izgledAplikacije;

import java.util.Comparator;

public class ComparatorSortiranje implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		
			String[] podjela1 = s1.split("-");
			String[] podjela2 = s2.split("-");
			String smjer1 = podjela1[0];
			String smjer2 = podjela2[0];
			String[] podjela12 = podjela1[1].split("/");
			String[] podjela22 = podjela2[1].split("/");
			String broj1 = podjela12[0];
			String broj2 = podjela22[0];
			String godina1 = podjela12[1];
			String godina2 = podjela22[1];

			
			if(!smjer1.equals(smjer2)) {
				return smjer1.compareTo(smjer2);
			}
			if(!godina1.equals(godina2)) {
				return godina1.compareTo(godina2);
			}
			
			return broj1.compareTo(broj2);
	}
	
}
