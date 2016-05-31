package dao;

public class isNumberDAO {

	public static boolean isNumber(String chuoi){
		for(int i=0;i<chuoi.length();i++){
			if(Character.isDigit(chuoi.charAt(i))==false){
				return false;
			}
		}
		return true;
	}
	/*
	public static void main(String[] a){
		System.out.println("ddss"+isNumber("22s33"));
	}
	*/
}
