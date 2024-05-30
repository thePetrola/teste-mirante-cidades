package br.com.opetrola.testemirantecidades.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class CidadeVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;
    private String estado;
    private String cep;

    @JsonProperty("renda_per_capta")
    private double rendaPerCapta;

    private long populacao;
    private float idh;

    private double latitude;
    private double longitude;

    public CidadeVO() {
    }

    public CidadeVO(Long id,
                    String nome,
                    String estado,
                    String cep,
                    double rendaPerCapta,
                    long populacao,
                    float idh,
                    double latitude,
                    double longitude) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.cep = cep;
        this.rendaPerCapta = rendaPerCapta;
        this.populacao = populacao;
        this.idh = idh;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public double getRendaPerCapta() {
        return rendaPerCapta;
    }

    public long getPopulacao() {
        return populacao;
    }

    public float getIdh() {
        return idh;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRendaPerCapta(double rendaPerCapta) {
        this.rendaPerCapta = rendaPerCapta;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public void setIdh(float idh) {
        this.idh = idh;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CidadeVO cidadeVO = (CidadeVO) object;
        return Double.compare(rendaPerCapta, cidadeVO.rendaPerCapta) == 0 && populacao == cidadeVO.populacao && Float.compare(idh, cidadeVO.idh) == 0 && Double.compare(latitude, cidadeVO.latitude) == 0 && Double.compare(longitude, cidadeVO.longitude) == 0 && Objects.equals(id, cidadeVO.id) && Objects.equals(nome, cidadeVO.nome) && Objects.equals(estado, cidadeVO.estado) && Objects.equals(cep, cidadeVO.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado, cep, rendaPerCapta, populacao, idh, latitude, longitude);
    }
}
