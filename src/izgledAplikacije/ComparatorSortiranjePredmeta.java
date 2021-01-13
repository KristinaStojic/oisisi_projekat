package izgledAplikacije;

import java.util.Comparator;
import java.util.regex.Pattern;

public class ComparatorSortiranjePredmeta implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {

	 Pattern pattern = Pattern.compile("[A-Za-z0-9]+");
		
		if(pattern.matcher(s1).matches() && pattern.matcher(s2).matches()) {
			
			
			String brojevi1= s1.replaceAll("[^0-9]", "");
			String brojevi2= s2.replaceAll("[^0-9]", "");
			
			String[] podjela1 = s1.split("[0-9]");
			String[] podjela2 = s2.split("[0-9]");		
			
			String slova1 = podjela1[0];
			String slova2 = podjela2[0];	
			
			if(!slova1.equals(slova2)) {
				return slova1.compareTo(slova2);
				
			}else {
				int ret = Integer.parseInt(brojevi1) - Integer.parseInt(brojevi2);
				return ret;
				
			}
			
		}else{
			return s1.compareTo(s2);
		}
		

	}
	
}

