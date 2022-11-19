/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author kauan.mendes
 */
public class Maquina {

    private Integer id_maquina;
    private Integer fk_usuario_maquina;
    private String codigo_patrimonio;

    public Maquina() {

    }

    public Integer getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(Integer id_maquina) {
        this.id_maquina = id_maquina;
    }

    public Integer getFk_usuario_maquina() {
        return fk_usuario_maquina;
    }

    public void setFk_usuario_maquina(Integer fk_usuario_maquina) {
        this.fk_usuario_maquina = fk_usuario_maquina;
    }

    public String getCodigo_patrimonio() {
        return codigo_patrimonio;
    }

    public void setCodigo_patrimonio(String codigo_patrimonio) {
        this.codigo_patrimonio = codigo_patrimonio;
    }

    @Override
    public String toString() {
        return "Maquina{" + "id_maquina=" + id_maquina + ", fk_usuario_maquina=" + fk_usuario_maquina + '}';
    }

}
