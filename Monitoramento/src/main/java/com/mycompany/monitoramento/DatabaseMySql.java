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
                "jdbc:mysql://172.17.0.1:3306/nocrash");
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

    public void inserirDados(String token) {
         jdbcTemplate.update(sql.insertDados(token));
    }
    public void inserirDisco(Integer indice, String token) {
         jdbcTemplate.update(sql.insertDisco(indice, token));
    }
    public void updateDisco(Integer indice, String token) {
         jdbcTemplate.update(sql.updateDisco(indice, token));
    }
}
