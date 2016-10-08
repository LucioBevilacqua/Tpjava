package ctrl;

import java.util.ArrayList;

import data.DataPersonaje;
import entidades.Personaje;

public class ABMCPersonaje {
	
	private DataPersonaje dataPer;
	
	public ABMCPersonaje(){
		dataPer=new DataPersonaje();
	}
	

	public void delete(Personaje p) {
		// TODO Auto-generated method stub
		dataPer.delete(p);
	}

	public void update(Personaje p) {
		// TODO Auto-generated method stub
		dataPer.update(p);
	}

	public void add(Personaje p) {
		// TODO Auto-generated method stub
		dataPer.add(p);
	}

	public Personaje getPersonaje(Personaje p) {
		// TODO Auto-generated method stub
		return dataPer.getById(p);
	}

	
	public boolean verficarNombre(Personaje p){
		return dataPer.verificarNombre(p);
	}
	
	public ArrayList<String> cargarNombres(){
		return dataPer.getPersonajes();
	}


	public Personaje getPersonajeByNom(String nom) {
		// TODO Auto-generated method stub
		return dataPer.getByNom(nom);
	}
}
