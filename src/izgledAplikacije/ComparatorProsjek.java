package izgledAplikacije;

import java.util.Comparator;

public class ComparatorProsjek implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		if(Double.parseDouble(o1) < Double.parseDouble(o2)) {
			return -1;
		}else if(Double.parseDouble(o1) > Double.parseDouble(o2)) {
			return 1;
		}else {
			return 0;
		}
	}
}
