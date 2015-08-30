package br.com.eleitoralweb.entity;

import javax.persistence.*;
import java.util.*;


/**
 * Created by manudominique on 28/08/15.
 */
@Entity
@Table(name="recurso")
public class Recurso {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String url;
    private boolean menu;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="recurso_pai")
    private Recurso recursoPai;
    @OneToMany(mappedBy = "recursoPai", fetch=FetchType.LAZY)
    private List<Recurso> recursosFilhos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recurso getRecursoPai() {
        return recursoPai;
    }

    public void setRecursoPai(Recurso recursoPai) {
        this.recursoPai = recursoPai;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public List<Recurso> getRecursosFilhos() {
        return recursosFilhos;
    }

    public void setRecursosFilhos(List<Recurso> recursosFilhos) {
        this.recursosFilhos = recursosFilhos;
    }
}
