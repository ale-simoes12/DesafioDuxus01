import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author unifamedrano
 */
public class conexao {
  Connection conn;

  public Connection getConnection() throws SQLException {
   conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "fei");
   
    return conn;

  }

  public int executaSQl(String sql) {
    try {

      Statement stm = conn.createStatement();
      int res = stm.executeUpdate(sql);
      //conn.close();
        System.out.println("fdibfdifd");
      return res;
     
     
    } catch (Exception e) {
      e.printStackTrace();
      return 0;

    }
  }

  public ResultSet executaBusca(String sql) {
    try {
      Statement stm = conn.createStatement();
      ResultSet rs = stm.executeQuery(sql);
      //conn.close();
      System.out.println("bbbbbb");
      return rs;
      

      
    } catch (Exception e) {
      e.printStackTrace();
        System.out.println("zzzzzzzzzz");
      return null;

    }

  }

}
