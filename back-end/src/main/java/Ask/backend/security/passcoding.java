package Ask.backend.security;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class passcoding {
    String encodingType = "utf-8";
    public String encoding(String password){
        String result=null;
        try {
            result=Base64.getEncoder().encodeToString(password.getBytes(encodingType));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }
    public String decoding(String password){
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        String result = null;
        try {
            result=new String(decodedBytes,encodingType);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return result;
    }
    public boolean passwordCheck(String passCheck,String passdb){
        String temp=decoding(passdb);
        if(passCheck.equals(temp)) return true;
        return false;
    }
}
