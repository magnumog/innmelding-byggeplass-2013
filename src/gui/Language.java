package gui;

/*
 * Author Magnus Settemsli Mogstad
 * mail @ magnumog@stud.ntnu.no
 * Rotete kode men forståelig
 * Owner Veidekke ASA
 */


import java.util.HashMap;
import java.util.Map;

public enum Language {
	Norwegian, Polski, English, Deutsch;
	
	private static Map<String, Language> StringMap = new HashMap<String, Language>();

	public String toString() {
		if(this==Language.Norwegian){
			return "Norwegian";
		} else if(this==Language.Polski) {
			return "Polski";
		} else if(this==Language.English) {
			return "English";
		} else {
			return "Deutsch";
		}
	}
	public static Language getLannguage(String key) {
		return 	StringMap.get(key);
	}
}

