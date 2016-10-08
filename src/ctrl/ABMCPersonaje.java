package ctrl;

import java.util.ArrayList;

import data.DataPersonaje;
import entidades.Personaje;

public class ABMCPersonaje {
	
	private DataPersonaje dataPer;
	private Personaje p1,p2;
	private Personaje turno;
	
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
	
	public void atacar (int energiaAtaque){
		float random = (float) (Math.random()*100);
		System.out.println(""+random);
		if(turno.equals(p1)){
			if( random> p2.getEvasion()){
				p2.setAtaque(p2.getAtaque()-energiaAtaque);
				p1.setEnergia(p1.getEnergia()-energiaAtaque);
			}			
		}else{
			if(random > p1.getEvasion()){
				p1.setAtaque(p1.getAtaque()-energiaAtaque);
				p2.setEnergia(p2.getEnergia()-energiaAtaque);
			}
		}
		
	}

	public Personaje getP1(){
		return p1;
	}
	
	public Personaje getP2(){
		return p2;
	}
	
	public Personaje getPersonajeByNom(String nom) {
		// TODO Auto-generated method stub
		return dataPer.getByNom(nom);
	}
	
	public Personaje getTurno(){
		if(turno==null){
			if(100*Math.random()<50){
				turno= p1;
			}else{
				turno =p2;
			}
		}else if(turno.equals(p1)){
			turno = p2;
		}else if(turno.equals(p2)){
			turno = p1;
		}
		return turno;
		 
	}
	
	public void setPersonajes(Personaje p1, Personaje p2){
		
		this.p1=p1;
		this.p2=p2;
	}
	
	public void clearPersonajes(){
		p1=null;
		p2=null;
	}
}
