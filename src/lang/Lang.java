package lang;

import java.io.InputStream;
import java.util.Properties;

public class Lang {
	
	private static String defLang = "vn";
	
	private String curLang;
	
	private Properties properties;
	
	public Lang() {
		this(defLang);
	}
	
	public Lang(String lang) {
		curLang = lang;
		properties = new Properties();
	}
	
	public String getMessage(String key) {
		String msg = getMsg(key, curLang, "message");
		if (msg.equals(key)) {
			msg = getMsg(key, defLang, "message");		
		} 
		return msg;
	}
	
	private String getMsg(String key, String lang, String type) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("lang/"+ lang +"."+ type +".properties");
		try {	
			properties.load(input);
			String msg = properties.getProperty(key);
			if(msg!=null) return msg;
			else return key;
		} catch(Exception ex) {
			return key;
		}	
	}
	
	public String getValMsg(String key) {
		String msg = getMsg(key, curLang, "validate");
		if (msg.equals(key)) {
			msg = getMsg(key, defLang, "validate");		
		} 
		return msg;
	}

}
