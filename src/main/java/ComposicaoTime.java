import java.util.Objects;
public class ComposicaoTime {

    

  private int id;
 
  private int id_time;
  private int id_integrante;
  private Time time;
  private Integrante integrante;

  public ComposicaoTime(int id , int id_time ,int id_integrante) {
      this.id = id;
    //this.integrante = integrante;
    this.id_time =id_time;
    this.id_integrante= id_integrante;
    
  }

  public ComposicaoTime(int id , Time time, Integrante integrante ) {
    this.id = id;
    //this.integrante = integrante;
    this.id_time = time.getId();
    this.id_integrante= integrante.getId();
    
    
  }
  
  /**
     * @return the id_time
     */
    public int getId_time() {
        return id_time;
    }

    /**
     * @param id_time the id_time to set
     */
    public void setId_time(int id_time) {
        this.id_time = id_time;
    }

    /**
     * @return the id_integrante
     */
    public int getId_integrante() {
        return id_integrante;
    }

    /**
     * @param id_integrante the id_integrante to set
     */
    public void setId_integrante(int id_integrante) {
        this.id_integrante = id_integrante;
    }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Time getTime() {
    return time;
  }

  public void setTime(Time time) {
    this.time = time;
  }

  public Integrante getIntegrante() {
    return integrante;
  }

  public void setIntegrante(Integrante integrante) {
    this.integrante = integrante;
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ComposicaoTime)) return false;
    ComposicaoTime that = (ComposicaoTime) o;
    return id == that.id && Objects.equals(time, that.time) && Objects.equals(integrante, that.integrante);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(id, time, integrante);
  }

  @Override
  public String toString() {
    return "ComposicaoTime{" +
        "time=" + time +
        ", integrante=" + integrante +
        '}';
  }


  public String inserirDadosComsicaoTime(){

    String sql = "Insert into ComposicaoTime(id,id_time,id_integrante)"+"values('"+getId()+"','"+ getId_time()+ "'"+",'"+getId_integrante()+"')";

    return sql;
    
     }
}
