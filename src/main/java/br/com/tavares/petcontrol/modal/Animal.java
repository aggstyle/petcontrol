package br.com.tavares.petcontrol.modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.tavares.petcontrol.enums.EBooleanStr;
import br.com.tavares.petcontrol.enums.EMaturidade;
import br.com.tavares.petcontrol.enums.ESexo;
import br.com.tavares.petcontrol.enums.EStatusAnimal;

@Entity
public class Animal {
	@Id
	@GeneratedValue
	private Integer id;

	private String rfid;

	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	private Cor cor;
	@ManyToOne(fetch = FetchType.EAGER)
	private Raca raca;
	@ManyToOne(fetch = FetchType.EAGER)

	private Especie especie;

	private Date dtNascimento;

	private ESexo sexo;

	private Date dtCadastro;

	private String observacao;

	private EMaturidade maturidade;

	@OneToOne(fetch = FetchType.EAGER)
	private ONG ong;

	private EBooleanStr castrado;
	@OneToOne(fetch = FetchType.EAGER)
	private Animal pai;
	@OneToOne(fetch = FetchType.EAGER)
	private Animal mae;

	@ManyToOne(fetch = FetchType.EAGER)
	private Pessoa dono;

	private EStatusAnimal status = EStatusAnimal.N_ADOTADO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Raca getRaca() {
		return raca;
	}

	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public ESexo getSexo() {
		return sexo;
	}

	public void setSexo(ESexo sexo) {
		this.sexo = sexo;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public EMaturidade getMaturidade() {
		return maturidade;
	}

	public void setMaturidade(EMaturidade maturidade) {
		this.maturidade = maturidade;
	}

	public EBooleanStr getCastrado() {
		return castrado;
	}

	public void setCastrado(EBooleanStr castrado) {
		this.castrado = castrado;
	}

	public Animal getPai() {
		return pai;
	}

	public void setPai(Animal pai) {
		this.pai = pai;
	}

	public Animal getMae() {
		return mae;
	}

	public void setMae(Animal mae) {
		this.mae = mae;
	}

	public Pessoa getDono() {
		return dono;
	}

	public void setDono(Pessoa Dono) {
		dono = Dono;
	}

	public ONG getOng() {
		return ong;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
	}

	public EStatusAnimal getStatus() {
		return status;
	}

	public void setStatus(EStatusAnimal status) {
		this.status = status;
	}

}
