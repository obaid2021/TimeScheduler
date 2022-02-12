package encryption;
/**
 * This class generates a two digit random number.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class SecretKey {
    /**
     * This function generates a two digit random integer number that will be used
     * as secret key.
     * @return two digit random number.
     */
	public int generate_secretkey()
	{
		int min = 0;
        int max = 99;
           
        int random_num = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_num;
	}
}
