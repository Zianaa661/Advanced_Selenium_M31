package Generic_Utilities;

import java.util.Random;

public class Java_Utility {
	/**
	 * This Method is used to avoid duplicate values
	 * @return
	 * @author Zeenat
	 */
public int getRandom() {
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	return ranNum;
}
}
