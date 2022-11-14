package com.mycompany.monitoramento;

import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseMySql {

    private final BasicDataSource dataSourceSql = new BasicDataSource();
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceSql);
    private final SqlCommands sql = new SqlCommands();
// ec2 config
    public DatabaseMySql() throws SQLException  {       
        dataSourceSql.setDriverClassName(
                "com.mysql.cj.jdbc.Driver");
        dataSourceSql.setUrl(
                "jdbc:mysql://nocrash:3306/nocrash");
        dataSourceSql.setUsername("root");
        dataSourceSql.setPassword("urubu100");
    }
        
//local config
//    public DatabaseMySql() throws SQLException {
//        
//        dataSourceSql.setDriverClassName(
//                "com.mysql.cj.jdbc.Driver");
//        dataSourceSql.setUrl(
//                "jdbc:mysql://localhost:3306/nocrash");
//        dataSourceSql.setUsername("root");
//        dataSourceSql.setPassword("sptech");
//    }
    
    public void insertHardware(String token) {
         jdbcTemplate.update(sql.insertHardware(token));
    }
    
    public void updateHardware(String token) {
         jdbcTemplate.update(sql.updateHardware(token));
    }

    public void inserirDados() {
         jdbcTemplate.update(sql.insertDados());
    }
    public void inserirDisco(Integer indice) {
         jdbcTemplate.update(sql.insertDisco(indice));
    }
    public void updateDisco(Integer indice) {
         jdbcTemplate.update(sql.updateDisco(indice));
    }
}
