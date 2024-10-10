import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class test {

    @Test
    public void getConnection() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\JavaLearning\\JavaLesson\\Demo\\Demo04_SportsMeeting\\Demo04_SportsMeeting\\dao-demo\\src\\druid.properties"));
        DataSource dataSource= DruidDataSourceFactory.createDataSource(prop);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    public void closeConnection(Connection conn) throws Exception {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
