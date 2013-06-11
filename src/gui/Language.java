package gui;

public enum Language {
	Norwegian, Polski, English, Deutsch;

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
}

