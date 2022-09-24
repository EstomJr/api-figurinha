package dto;

import java.io.Serializable;

import models.Figurinha;

public class FigurinhaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomeJogador;
	private String selecaoJogador;
	private Long idDono;
	
	public FigurinhaDTO() {
		
	}
	
	public FigurinhaDTO(Figurinha entity) {
		//this.id = entity();
		this.nomeJogador = entity.getNomeJogador();
		this.selecaoJogador = entity.getSelecaoJogador();
		this.idDono = entity.getIdDono();
	}
	
	public FigurinhaDTO(Long id, 
			String nomeJogador, 
			String selecaoJogador, 
			Long idDono) {
		super();
		this.id = id;
		this.nomeJogador = nomeJogador;
		this.selecaoJogador = selecaoJogador;
		this.idDono = idDono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public String getSelecaoJogador() {
		return selecaoJogador;
	}

	public void setSelecaoJogador(String selecaoJogador) {
		this.selecaoJogador = selecaoJogador;
	}

	public Long getIdDono() {
		return idDono;
	}

	public void setIdDono(Long idDono) {
		this.idDono = idDono;
	}

	@Override
	public String toString() {
		return "FigurinhaDTO [id=" + id + ", nomeJogador=" + nomeJogador + ", selecaoJogador=" + selecaoJogador
				+ ", idDono=" + idDono + "]";
	}
	
	
}
