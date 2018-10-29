package model;

public class Area implements Comparable<Area>{
	
	private String abre;
	private String nombre;
	private int madurez;
	private int sg;
	
	private boolean g2, g3, s1, s2, s3;
	
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
		if(madurez != a.madurez)
			return madurez-a.madurez;
		return abre.compareTo(a.abre);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return abre;
	}

	public int getCapacidad() {
		int cap = 0;
		boolean g1 = s1;
		if(sg >1) g1 = g1 && s2;
		if(sg >2) g1 = g1 && s3;
		
		if(g1) { 
			cap++;
			if(g2) {
				cap++;
				if(g3) {
					cap++;
				}
			}
		}
		
		return cap;
	}
	public boolean isG2() {
		return g2;
	}
	public void setG2(boolean g2) {
		this.g2 = g2;
	}
	public boolean isG3() {
		return g3;
	}
	public void setG3(boolean g3) {
		this.g3 = g3;
	}
	public boolean isS1() {
		return s1;
	}
	public void setS1(boolean s1) {
		this.s1 = s1;
	}
	public boolean isS2() {
		return s2;
	}
	public void setS2(boolean s2) {
		this.s2 = s2;
	}
	public boolean isS3() {
		return s3;
	}
	public void setS3(boolean s3) {
		this.s3 = s3;
	}
	public int getSg() {
		return sg;
	}
	
	
}
