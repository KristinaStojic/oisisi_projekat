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
			
			
			
			/*String[] n = s1.split(""); //array of strings
		    StringBuffer f = new StringBuffer(); // buffer to store numbers

		    for (int i = 0; i < n.length; i++) {
		        if((n[i].matches("[0-9]+"))) {// validating numbers
		            f.append(n[i]); //appending
		        }  
		    }
			
			
			
			String[] n1 = s2.split(""); //array of strings
		    StringBuffer f1 = new StringBuffer(); // buffer to store numbers
		    try {
		    for (int i = 0; i < n1.length; i++) {
		        if((n1[i].matches("[0-9]+"))) {// validating numbers
		            f1.append(n1[i]); //appending
		        }  
		    }
			}catch(Exception e) {}
			*/
		    
		    
			if(!slova1.equals(slova2)) {
				//System.out.println(slova1 + " " + slova2);
				return slova1.compareTo(slova2);
				
			}else {
				
				System.out.println(brojevi1 + " " + brojevi2);
				System.out.println(brojevi1.compareTo(brojevi2));
				return brojevi1.compareTo(brojevi2);
				
			}
			
		}else{
			return s1.compareTo(s2);
		}
		

	}
	
}

