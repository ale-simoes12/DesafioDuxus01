// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        

        //DadosParaTesteApiService dt = new DadosParaTesteApiService();
        //ApiService ap = new ApiService();
        
        LocalDate data1995 = LocalDate.of(1995, 1, 1);
        //objeto conexao
        conexao con = new conexao();
        
        //arrays objetos
        
        
       
        
      ArrayList<Integrante> integrantes = new ArrayList<>();
      ArrayList<Time> times = new ArrayList<>();
      ArrayList<ComposicaoTime> componentes = new ArrayList<>();
      
        
      
        //con.getConnection();
        try {
            con.getConnection();
          

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("bbbbb");

        }
        //inserir dados na tabela time
        Time ti = new Time(data1995, 4);
        String insert = ti.inserirDadosTime();
        con.executaSQl(insert);
       //inserir dados na tabela integrante
       Integrante inte = new Integrante(3, "brasileirao", "rony", "atacante");
        String insertInte = inte.inserirDadosIntegrante();
        con.executaSQl(insertInte);
       //inserir dados na tabela composicaoTime
       
        ComposicaoTime composicaoTime = new ComposicaoTime(12,ti,inte);
        String insertCompTime = composicaoTime.inserirDadosComsicaoTime();
        con.executaSQl(insertCompTime);

        

        // puxar os dados do db//
        //Puxar dados tabela time
        String sql2 = "select * from time";

        ResultSet rs2 = con.executaBusca(sql2);

        try {
            while (rs2.next()) {
                int id = rs2.getInt("id");
                java.sql.Date dataSql = rs2.getDate("data");
                
                // Converte java.sql.Date para LocalDate
                LocalDate dataLocalDate = dataSql.toLocalDate();
                
                
                System.out.println(id);
                System.out.println(dataLocalDate);
                
                times.add(new Time(dataLocalDate,id));
                
                

            }
        } catch (Exception e) {
         
            e.printStackTrace();

        }

        //puxar dados da tabela integrante
        String sql = "select * from integrante";
        ResultSet rs = con.executaBusca(sql);

        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String funcao = rs.getString("funcao");
                String franquia = rs.getString("franquia");
                System.out.println(id);
                System.out.println(nome);
                System.out.println(funcao);
                System.out.println(franquia);
                integrantes.add(new Integrante(id,nome, funcao,franquia));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

       //puxar dados da tabela composicaotime
    String sql3 = "select * from ComposicaoTime";

    ResultSet rs3 = con.executaBusca(sql3);

    try {
      while (rs3.next()) {
        int id = rs3.getInt("id");
        int id_time = rs3.getInt("id_time");
        int id_integrante  = rs3.getInt("id_integrante");
          System.out.println(id);
          System.out.println(id_time);
          System.out.println(id_integrante);
          componentes.add(new ComposicaoTime(id,id_time, id_integrante));
          

      }
    } catch (Exception e) {
      e.printStackTrace();

    }
         
    }

}
