
package Model;

public class Produto {

    private int idProduto;
    private int idEmbalagem;
    private String nome;
    private String descricao;
    private String classetox;
    
    public String getClassetox() {
        return classetox;
    }

    public void setClassetox(String classetox) {
        this.classetox = classetox;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdEmbalagem() {
        return idEmbalagem;
    }

    public void setIdEmbalagem(int idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
