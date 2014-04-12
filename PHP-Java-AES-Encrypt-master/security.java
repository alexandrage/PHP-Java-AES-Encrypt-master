import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class security {
	public static String encrypt(String input, String key){
	  byte[] crypted = null;
	  try{
	    SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, skey);
	      crypted = cipher.doFinal(input.getBytes());
	    }catch(Exception e){
	    	System.out.println(e.toString());
	    }
	    return new String(new sun.misc.BASE64Encoder().encode(crypted));
	}

	public static String decrypt(String input, String key){
	    byte[] output = null;
	    try{
	      SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
	      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	      cipher.init(Cipher.DECRYPT_MODE, skey);
	      output = cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(input));
	    }catch(Exception e){
	      System.out.println(e.toString());
	    }
	    return new String(output);
	}
	
	public static void main(String[] args) {
	  String key = "1234567891234567";
	  String data = "example";
	  System.out.println(Security.decrypt(Security.encrypt(data, key), key));
	  System.out.println(Security.encrypt(data, key));	    
	}	
}
