package hackerjacks.textcrypt;
import java.util.Random;

public class OtherEncrypt {
       
	public static String encrypt (String message){ //104,101,108,108,111
		  if (message.length()==0)
		      return "";
		    int [] y_vals = new int [message.length()];
		    for (int i = 0; i < message.length(); i++){
		      char temp =  message.charAt(i);
		      y_vals[i] = temp;
		    }
		    double [] ret = new double [y_vals.length];
		    for (int i = 0; i<y_vals.length; i++){
		      int random = (int) (101* Math.random());
		      ret[i]= (Math.asin(  ((y_vals[i]-64)/64.0)))/10000.0 + (random* ( (2*Math.PI) /10000.0) );
		      ret[i]=Math.log(ret[i]);
		    }
		    for (int i=0;i<ret.length;i++){
		      ret[i]=Math.round(ret[i]*100000.0)/100000.0;
		    }
		    String temp="";
		    for (int i=0;i<ret.length;i++){
		      temp+=ret[i]+" ";
		    }
		    return temp;
	  }
	  
	  
	  public static String decrypt (String a){
		  if (a.length()==0)
		      return "";
		    String [] encrypted=a.split(" ");
		    double [] x_vals=new double[encrypted.length];
		    for (int i=0;i<encrypted.length;i++){
		      x_vals[i] = Double.parseDouble(encrypted[i]);
		      x_vals[i] = Math.pow(Math.E,x_vals[i]);
		    }
		    String temp = "";
		    for (int i = 0; i< x_vals.length; i++){
		      System.out.print(x_vals[i] + "   ");
		      float y_valtemp = (float)(64.0 * (Math.sin(10000.0*x_vals[i])) + 64.0);
		      int x=(int)Math.round(y_valtemp);
		      System.out.println(x);
		      temp += (char)(x);
		    }
		    return temp;
	  }
}
