package encryption;

public class Encrypt {
	/**
	 * This function shifts the characters of the string by subtracting each character
	 * from the value secret key of the string.<p> 
	 * This brings the string in the encrypted form.
	 * 
	 * @param value string that needs to be encrypted.
	 * @param secretKey is the key which will be used to encrypt the string.
	 * @return it returns the encrypted word.
	 */
	public static String encrypt(String value ,int secretKey)
	{
		String encrypted = "";
		char val ; 
		for(int i =0  ; i< value.length() ; i++)
		{
			val = value.charAt(i);
			val = (char) (val + secretKey);
			encrypted = encrypted + val;
		}
		return encrypted;
		
	}
}
