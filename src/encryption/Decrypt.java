package encryption;
/**
 * This class is decrypts the information stored in database in enrypted form.
 * @author Muhammad Obaid Ullah , Syed Adil Ehsan , Rao Shahan Naveed
 *
 */
public class Decrypt {
	/**
	 * This function shifts the characters of the string by subtracting the value secret key
	 * from each character of the string.<p> 
	 * This brings the string back with its original characters.
	 * 
	 * @param value string that needs to be decrypted.
	 * @param secretKey is the key which was used to encrypt the string.
	 * @return it returns the decrypted word.
	 */
	public static String decrypt(String value, int secretKey) {
		String decrypted = "";
		char val;
		for (int i = 0; i < value.length(); i++) {
			val = value.charAt(i);
			val = (char) (val - secretKey);
			decrypted = decrypted + val;
		}

		return decrypted;

	}
}
