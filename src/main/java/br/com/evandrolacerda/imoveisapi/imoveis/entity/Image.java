package br.com.evandrolacerda.imoveisapi.imoveis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "url" , length = 1000 )
    private String url;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    @JsonIgnore
    private Imovel imovel;

    public Image() {
    }

    public Image(String url, Imovel imovel) {
        this.url = url;
        this.imovel = imovel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }
}
