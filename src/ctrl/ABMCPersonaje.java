package ctrl;

import java.util.ArrayList;

import data.DataPersonaje;
import entidades.Personaje;

public class ABMCPersonaje {
	
	private DataPersonaje dataPer;
	private Personaje p1,p2;
	private int max1, max2;
	private int vida1, vida2;
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
				p2.recibirAtaque(energiaAtaque);
				p1.setEnergia(p1.getEnergia()-energiaAtaque);
			}else{
				p1.setEnergia(p1.getEnergia()-energiaAtaque);
			}
		}else{
			if(random > p1.getEvasion()){
				p1.recibirAtaque(energiaAtaque);
				p2.setEnergia(p2.getEnergia()-energiaAtaque);
			}else{
				p2.setEnergia(p2.getEnergia()-energiaAtaque);
			}
		}
		
	}
	
	public void defender(){
		
		if(turno.equals(p1)&&max1>p1.getEnergia()){
			p1.setEnergia(p1.getEnergia()+max1*p1.getDefensa()/100);
		}else if (turno.equals(p2)&&max2>p2.getEnergia()){
			p2.setEnergia(p2.getEnergia()+max2*p2.getDefensa()/100);
		}
		
		if(turno.equals(p1)&&vida1>p1.getAtaque()){
			if(p1.getAtaque()+vida1*p1.getDefensa()/250<=vida1){
			p1.setAtaque(p1.getAtaque()+vida1*p1.getDefensa()/250);
			}else{
				p1.setAtaque(vida1);
			}
			
		}else if (turno.equals(p2)&&vida2>p2.getAtaque()){
			if(p2.getAtaque()+vida2*p2.getDefensa()/250<=vida2){
				p2.setAtaque(p2.getAtaque()+vida2*p2.getDefensa()/250);
			}else{
				p2.setAtaque(vida2);
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
		max1=(int) p1.getEnergia();
		max2=(int) p2.getEnergia();
		vida1= p1.getAtaque();
		vida2=p2.getAtaque();
	}
	
	public void clearPersonajes(){
		p1=null;
		p2=null;
		turno=null;
	}


	public void acreditarPuntos(Personaje p12) {
		dataPer.acreditarPuntos(p12);
	}
}
