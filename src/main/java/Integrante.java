import java.util.List;
import java.util.Objects;


public class Integrante {


  private int id;

  
  private String franquia;

  
  private String nome;

  private String funcao;


  private List<ComposicaoTime> composicaoTime;
 


  public Integrante() {
  }

  public Integrante(int id ,String franquia, String nome, String funcao) {
    this.franquia = franquia;
    this.nome = nome;
    this.funcao = funcao;
    this.id = id;
    //this.composicaoTime = composicaoTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFranquia() {
    return franquia;
  }

  public void setFranquia(String franquia) {
    this.franquia = franquia;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getFuncao() {
    return funcao;
  }

  public void setFuncao(String funcao) {
    this.funcao = funcao;
  }

  public List<ComposicaoTime> getComposicaoTime() {
    return composicaoTime;
  }

  public void setComposicaoTime(List<ComposicaoTime> composicaoTime) {
    this.composicaoTime = composicaoTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Integrante)) return false;
    Integrante that = (Integrante) o;
    return id == that.id && Objects.equals(franquia, that.franquia) && Objects.equals(nome, that.nome) && Objects.equals(funcao, that.funcao);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, franquia, nome, funcao);
  }

  @Override
  public String toString() {
    return "Integrante{" +
        "id=" + id +
        ", franquia='" + franquia + '\'' +
        ", nome='" + nome + '\'' +
        ", funcao='" + funcao + '\'' +
        '}';
  }



  public String inserirDadosIntegrante(){
    
    String sql = "Insert into Integrante(id,franquia,nome,funcao)"+"values('"+getId()+"','"+ getFranquia()+ "'"+",'"+getNome()+"','"+getFuncao()+"')";
    return sql;
    
}
}