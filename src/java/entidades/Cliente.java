package entidades;
// Generated Jun 4, 2015 2:33:30 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int id;
     private Usuario usuario;
     private String cpf;
     private String nome;
     private String endereco;
     private Date dataAniversario;
     private Set saidas = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(int id, Usuario usuario, String cpf, String nome, String endereco, Date dataAniversario) {
        this.id = id;
        this.usuario = usuario;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.dataAniversario = dataAniversario;
    }
    public Cliente(int id, Usuario usuario, String cpf, String nome, String endereco, Date dataAniversario, Set saidas) {
       this.id = id;
       this.usuario = usuario;
       this.cpf = cpf;
       this.nome = nome;
       this.endereco = endereco;
       this.dataAniversario = dataAniversario;
       this.saidas = saidas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Date getDataAniversario() {
        return this.dataAniversario;
    }
    
    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
    public Set getSaidas() {
        return this.saidas;
    }
    
    public void setSaidas(Set saidas) {
        this.saidas = saidas;
    }




}

