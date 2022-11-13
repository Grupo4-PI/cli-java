package com.mycompany.monitoramento;

import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseMySql {

    private final BasicDataSource dataSourceSql = new BasicDataSource();
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceSql);
    private final SqlCommands sql = new SqlCommands();
// ec2 config
//    public DatabaseMySql() throws SQLException         
//        dataSourceSql.setDriverClassName(
//                "com.mysql.cj.jdbc.Driver");
//        dataSourceSql.setUrl(
//                "jdbc:mysql://172.17.0.2:3306/nocrash");
//        dataSourceSql.setUsername("root");
//        dataSourceSql.setPassword("urubu100");
//    }

    public DatabaseMySql() throws SQLException {
        
        dataSourceSql.setDriverClassName(
                "com.mysql.cj.jdbc.Driver");
        dataSourceSql.setUrl(
                "jdbc:mysql://localhost:3306/nocrash");
        dataSourceSql.setUsername("root");
        dataSourceSql.setPassword("sptech");
    }
    
    public void inserirDados() {
         jdbcTemplate.update(sql.insertDados());
    }
    public void inserirDiscos(Integer index) {
         jdbcTemplate.update(sql.insertDisco(index));
    }
}
