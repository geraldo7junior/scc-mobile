package br.com.sccm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	public String Encrypt (final String str, final String model){
		String crypStr = "abc123" + str;  
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(model);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        md.update( crypStr.getBytes() );  
        BigInteger hash = new BigInteger( 1, md.digest() );  
        String strCryp = hash.toString( 16 );
        return strCryp;
	}

}
