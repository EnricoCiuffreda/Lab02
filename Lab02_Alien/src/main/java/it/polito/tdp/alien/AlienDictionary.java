package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	private List <WordEnhanced> lista;
	
	
	public AlienDictionary() {
		this.lista = new ArrayList <WordEnhanced>();
	}

	public void addWord(String alienWord, ArrayList<String> translation) {
		WordEnhanced tmp=new WordEnhanced(alienWord,translation);
		if(lista.contains(tmp))
		{
			int numero=lista.indexOf(tmp);
			lista.get(numero).setTranslation(translation);
			return;
		}
		lista.add(tmp);
		lista.get(lista.size()-1).setTranslation(translation);
	}
	
	public ArrayList translateWord(String alienWord) {
		ArrayList <String> risultato=new ArrayList <String>();
		WordEnhanced tmp=new WordEnhanced(alienWord,null);
		if(lista.contains(tmp))
		{
			int numero=lista.indexOf(tmp);
			risultato=lista.get(numero).getTranslation();
		}
		return risultato;
	}
		
	public boolean controllo(String tmp) {
	for(int i=0; i<tmp.length();i++)
	{
		char ctmp= tmp.charAt(i);
		if(!Character.isLetter(ctmp)) {
			return false;	
		}
	}
	return true;
	}
	


	public List<WordEnhanced> getLista() {
		return lista;
	}

	public void setLista(List<WordEnhanced> lista) {
		this.lista = lista;
	}

	public boolean controllostringa(ArrayList<String> traduzione) {
		for(String parola: traduzione)
	for(int i=0; i<parola.length();i++)
	{
		char ctmp= parola.charAt(i);
		if(!Character.isLetter(ctmp)) {
			return false;	
		}
	}
	return true;
	}
	
	
}

