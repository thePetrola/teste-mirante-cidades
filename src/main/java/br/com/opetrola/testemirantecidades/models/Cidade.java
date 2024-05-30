package br.com.opetrola.testemirantecidades.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_cidades")
public class Cidade implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nome;

    @Column(length = 2)
    private String estado;

    @Column(length = 9)
    private String cep;

    @Column(name = "renda_per_capta")
    private double rendaPerCapta;

    @Column
    private long populacao;

    @Column
    private float idh;

    @Column
    private double latitude;

    @Column
    private double longitude;

    public Cidade() {
    }

    public Cidade(Long id,
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
        Cidade cidade = (Cidade) object;
        return Double.compare(rendaPerCapta, cidade.rendaPerCapta) == 0 && populacao == cidade.populacao && Float.compare(idh, cidade.idh) == 0 && Double.compare(latitude, cidade.latitude) == 0 && Double.compare(longitude, cidade.longitude) == 0 && Objects.equals(id, cidade.id) && Objects.equals(nome, cidade.nome) && Objects.equals(estado, cidade.estado) && Objects.equals(cep, cidade.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, estado, cep, rendaPerCapta, populacao, idh, latitude, longitude);
    }
}
