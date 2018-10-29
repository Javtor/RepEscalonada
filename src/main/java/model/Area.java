package model;

public class Area implements Comparable<Area>{
	
	private String abre;
	private String nombre;
	private int madurez;
	private int sg;
	public Area(String abre, String nombre, int madurez, int sg) {
		super();
		this.abre = abre;
		this.nombre = nombre;
		this.madurez = madurez;
		this.sg = sg;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getMadurez() {
		return madurez;
	}
	public void setMadurez(int madurez) {
		this.madurez = madurez;
	}
	@Override
	public int compareTo(Area a) {
		return madurez-a.madurez;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return abre;
	}

	public int getCapacidad(boolean g2, boolean g3, boolean s1, boolean s2, boolean s3) {
		return 0;
		
	}
}
