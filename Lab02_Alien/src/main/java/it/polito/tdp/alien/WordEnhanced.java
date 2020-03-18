package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced{
	private String alienWord;
	private List translation;
	
	
	
	public WordEnhanced(String alienWord, List translation) {
		this.alienWord = alienWord;
		this.translation =new ArrayList <String>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordEnhanced other = (WordEnhanced) obj;
		if (alienWord == null) {
			if (other.alienWord != null)
				return false;
		} else if (!alienWord.equals(other.alienWord))
			return false;
		return true;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public ArrayList<String> getTranslation() {
		return (ArrayList<String>) translation;
	}

	public void setTranslation(ArrayList<String> translation) {
		this.translation = translation;
	}


	
	
	


	
	

}
