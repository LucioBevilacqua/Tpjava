package entidades;

public class Personaje {

	private int id;
	private String nombre;
	private static int contador ;
	private float energia;
	private int defensa, ataque, evasion, puntosTotales;
	
	
	public void inicializar(){
		contador=0;
	}
	
	public Personaje(String nombre, float energia, int defensa, int ataque, int evasion, int puntosTotales){
		
		this.id= contador++;
		this.energia = energia;
		this.defensa = defensa;
		this.ataque = ataque;
		this.evasion = evasion;
		this.puntosTotales = puntosTotales;
				
	}
	
	public Personaje(){
		
	}
	
	public void recibirAtaque(int energiaAtaque){
		
		ataque= ataque - energiaAtaque;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static int getContador() {
		return contador;
	}

	public float getEnergia() {
		return energia;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getEvasion() {
		return evasion;
	}

	public int getPuntosTotales() {
		return puntosTotales;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static void setContador(int contador) {
		Personaje.contador = contador;
	}

	public void setEnergia(float energia) {
		this.energia = energia;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	
	
}
