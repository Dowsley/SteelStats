package g5.dashboard.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity // This tells Hibernate to make a table out of this class
public class Perda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomLocal;
    private String desLocal;
    private Integer oidFalha;
    private String desTipoFalha;
    private String desAtributoFalha;
    private String desDisfuncaoProcesso;
    private String desFalha;
    private String idcDetalhesFalha;
    private Timestamp dthInicalRealizado;
    private Timestamp dthFinalRealizado;

    public String getNomLocal() {
        return nomLocal;
    }

    public Timestamp getDthFinalRealizado() {
        return dthFinalRealizado;
    }

    public void setDthFinalRealizado(Timestamp dthFinalRealizado) {
        this.dthFinalRealizado = dthFinalRealizado;
    }

    public Timestamp getDthInicalRealizado() {
        return dthInicalRealizado;
    }

    public void setDthInicalRealizado(Timestamp dthInicalRealizado) {
        this.dthInicalRealizado = dthInicalRealizado;
    }

    public String getIdcDetalhesFalha() {
        return idcDetalhesFalha;
    }

    public void setIdcDetalhesFalha(String idcDetalhesFalha) {
        this.idcDetalhesFalha = idcDetalhesFalha;
    }

    public String getDesFalha() {
        return desFalha;
    }

    public void setDesFalha(String desFalha) {
        this.desFalha = desFalha;
    }

    public String getDesDisfuncaoProcesso() {
        return desDisfuncaoProcesso;
    }

    public void setDesDisfuncaoProcesso(String desDisfuncaoProcesso) {
        this.desDisfuncaoProcesso = desDisfuncaoProcesso;
    }

    public String getDesAtributoFalha() {
        return desAtributoFalha;
    }

    public void setDesAtributoFalha(String desAtributoFalha) {
        this.desAtributoFalha = desAtributoFalha;
    }

    public String getDesTipoFalha() {
        return desTipoFalha;
    }

    public void setDesTipoFalha(String desTipoFalha) {
        this.desTipoFalha = desTipoFalha;
    }

    public Integer getOidFalha() {
        return oidFalha;
    }

    public void setOidFalha(Integer oidFalha) {
        this.oidFalha = oidFalha;
    }

    public String getDesLocal() {
        return desLocal;
    }

    public void setDesLocal(String desLocal) {
        this.desLocal = desLocal;
    }

    public void setNomLocal(String nomLocal) {
        this.nomLocal = nomLocal;
    }
}


    
    
