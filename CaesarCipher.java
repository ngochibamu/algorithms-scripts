public class CaesarCipher {
	private char[] encoder = new char[26];
	private char[] decoder = new char[26];

	public CaesarCipher(int rotation){
		for(int k=0; k < encoder.length; k++){
			encoder[k] = (char) ('A' + (k +rotation) % 26);
			decoder[k] = (char) ('A' + (k - rotation + 26) % 26);	
		}
	}

	public String encrypt(String message){
		return transform(message, encoder);
	}

	public String decrypt(String message){
		return transform(message, decoder);
	}

	private String transform(String original, char[] code){
		char[] msg = original.toCharArray();
		for(int k = 0; k < msg.length; k++){
			if(Character.isUpperCase(msg[k])){
				int j = msg[k] - 'A';
				msg[k] = code[j];
			}
		}
		return new String(msg);
	}

	public static void main(String args[]){
		CaesarCipher cipher = new CaesarCipher(11);
		
		System.out.println("Encryption code = "+new String(cipher.encoder));
		System.out.println("Decryption code = "+new String(cipher.decoder));

		String message = "KILLER LAID";
		String secret = cipher.encrypt(message);
		System.out.println("Secret war code="+secret);
		String original = cipher.decrypt(secret);
		System.out.println("original message="+original);
	}
}