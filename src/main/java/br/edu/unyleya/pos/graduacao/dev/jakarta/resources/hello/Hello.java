package br.edu.unyleya.pos.graduacao.dev.jakarta.resources.hello;

public class Hello {

	private String name;
	
	public Hello(String name) {
        this.name = name;
	}

	public String getHello(){
		return name;
	}
}