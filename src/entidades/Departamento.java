package entidades;

public class Departamento {
	
	private String name;
	
	private Departamento(){		
	}

	public Departamento(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
