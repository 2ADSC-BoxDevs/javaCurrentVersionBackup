/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author kauan.mendes
 */
public class UsuarioMaquina {
    
    private String nome_usuario_maquina;
    private String identificacao_usuario;
    private Integer id_usuario_maquina;
    private Integer fk_empresa;
    

    public UsuarioMaquina(String nome_usuario_maquina, String identificacao_usuario) {
        this.nome_usuario_maquina = nome_usuario_maquina;
        this.identificacao_usuario = identificacao_usuario;
    }

    public Integer getFk_empresa() {
        return fk_empresa;
    }

    public void setFk_empresa(Integer fk_empresa) {
        this.fk_empresa = fk_empresa;
    }
    
        public UsuarioMaquina() {
      
    }

    public String getNome_usuario_maquina() {
        return nome_usuario_maquina;
    }

    public void setNome_usuario_maquina(String nome_usuario_maquina) {
        this.nome_usuario_maquina = nome_usuario_maquina;
    }

    public String getIdentificacao_usuario() {
        return identificacao_usuario;
    }

    public void setIdentificacao_usuario(String identificacao_usuario) {
        this.identificacao_usuario = identificacao_usuario;
    }

    public Integer getId_usuario_maquina() {
        return id_usuario_maquina;
    }

    public void setId_usuario_maquina(Integer id_usuario_maquina) {
        this.id_usuario_maquina = id_usuario_maquina;
    }
    

    
    
    
    
}
