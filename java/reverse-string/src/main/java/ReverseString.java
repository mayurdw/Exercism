import java.lang.StringBuilder;

class ReverseString {

    String reverse(String inputString) {
        StringBuilder sRet = new StringBuilder(inputString).reverse();
        return sRet.toString();
    }
  
}