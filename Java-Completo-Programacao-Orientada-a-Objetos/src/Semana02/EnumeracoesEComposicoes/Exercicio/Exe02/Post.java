package Semana02.EnumeracoesEComposicoes.Exercicio.Exe02;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private String titulo;
    private String conteudo;
    private Integer curtidas;

    private List<Comentario> comentarios = new ArrayList<>();

    public Post(){}

    public Post(Date momento, String titulo, String conteudo, Integer curtidas) {
        this.momento = momento;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.curtidas = curtidas;
    }

    public void adicionarComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public void removerComentario(Comentario comentario){
        comentarios.remove(comentario);
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(Integer curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(titulo + "\n");
        sb.append(curtidas + " Curtidas - " + sdf.format(momento) + "\n");
        sb.append(conteudo + "\n");
        sb.append("Comentários: \n");
        for (Comentario comentario: comentarios){
            sb.append(comentario.getTexto() + "\n");
        }
        return sb.toString();
    }

}
