package utilities;
/**
 * This class generates a random number.
 * @author Muhammad Obaid Ullah, Syed Adil Ehsan, Rao Shahan Naveed
 *
 */
public class RandomNumber {
   /**
    * This function generates a 6 digit random number.
    * @return returns the six digit random number.
    */
	public int randomNumber()
    {
    	int min = 99999;
        int max = 999999;
           
        int random_num = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_num;
    }
}
