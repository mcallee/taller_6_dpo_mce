package exceptions;

@SuppressWarnings("serial")
public abstract class HamburguesaException extends Exception {
	
	
	HamburguesaException(String msg){
		System.out.print(msg);
	}
	//abstract void message(String msg);

}
	
