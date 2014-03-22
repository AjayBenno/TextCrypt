package hackerjacks.textcrypt;
import java.util.Random;

public class OneTimePad {
       
        public static String encrypt(String message, String key) {
                if (message.length() != key.length()) error("Lengths must be equal");
                int[] im = charArrayToInt(message.toCharArray());
                int[] ik = charArrayToInt(key.toCharArray());
                int[] data = new int[message.length()];
               
                for (int i=0;i<message.length();i++) {
                        data[i] = im[i] + ik[i];
                }
               
                return new String(intArrayToChar(data));
        }
       
        public static String decrypt(String message, String key) {
                if (message.length() != key.length()) error("Lengths must be equal");
                int[] im = charArrayToInt(message.toCharArray());
                int[] ik = charArrayToInt(key.toCharArray());
                int[] data = new int[message.length()];
               
                for (int i=0;i<message.length();i++) {
                        data[i] = im[i] - ik[i];
                }
               
                return new String(intArrayToChar(data));
        }
       
        public static String genKey(int length) {
                Random rand = new Random();
                char[] key = new char[length];
                for (int i=0;i<length;i++) {
                        key[i] = (char) rand.nextInt(132);
                        if ((int) key[i] < 97) key[i] = (char) (key[i] + 72);
                        if ((int) key[i] > 122) key[i] = (char) (key[i] - 72);
                }
               
                return new String(key);
        }
       
        /*public static void main(String[] args){
                OneTimePad otp = new OneTimePad();
                String message = "hello";
                String key = otp.genKey(message.length());
                String enMessage = otp.encrypt(message, key);
                String deMessage = otp.decrypt(enMessage, key);
               
                System.out.println("Message: "+message);
                System.out.println("Key: "+key);
                System.out.println("Encrypted Message: "+enMessage);
                System.out.println("Decrypted Message: "+deMessage);
               
        }*/
       
        private static int chartoInt(char c) {
                return (int) c;
        }
       
        private static char intToChar(int i) {
                return (char) i;
        }
       
        private static int[] charArrayToInt(char[] cc) {
                int[] ii = new int[cc.length];
                for(int i=0;i<cc.length;i++){
                        ii[i] = chartoInt(cc[i]);
                }
                return ii;
        }
       
        private static char[] intArrayToChar(int[] ii) {
                char[] cc = new char[ii.length];
                for(int i=0;i<ii.length;i++){
                        cc[i] = intToChar(ii[i]);
                }
                return cc;
        }
       
        private static void error(String msg) {
                System.out.println(msg);
                System.exit(-1);
        }
}
