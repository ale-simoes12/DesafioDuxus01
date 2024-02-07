import java.time.LocalDate;
import java.util.List;
import java.util.Objects;



public class Time {
  
   private int id;
   private List<ComposicaoTime> composicaoTime;
  
  
   private LocalDate data;

  public Time() {
    
  }
 
	public Time(LocalDate  data, int id ) {
		this.data = data;
                this.id = id;
                //this.composicaoTime = composicaoTime;
    
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate   data) {
		this.data = data;
	}




	@Override
	public String toString() {
		return "Time{" +
				"id=" + id +
				", data=" + data +
				'}';
	}


  public String inserirDadosTime(){

    String sql = "Insert into Time(id,data)"+"values('"+getId()+"','"+ getData()+"')";
    return sql;
  
}
}