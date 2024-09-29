import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

    public static void main(String[] args) {

        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3306/test_db";
        try {
            // JDBC 드라이버 로드
            Class.forName(jdbc_driver);

            // 데이터베이스 연결
            Connection con = DriverManager.getConnection(jdbc_url, "root", "0000");

            // Statement 객체 생성
            Statement st = con.createStatement();

            // SQL 쿼리 실행
            String query = "SELECT * FROM students WHERE age >= 30 AND age < 40";
            ResultSet resultSet = st.executeQuery(query);

            // 결과 처리
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                System.out.println(name + " " + age + " " + address);
            }

            // 리소스 정리
            resultSet.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
