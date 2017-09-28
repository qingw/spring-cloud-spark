package org.sselab.feignapi;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by xd031 on 2017/9/27.
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * spring.datasource.password=password
 * spring.datasource.url=jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8
 * spring.datasource.username=username
 */
@Data
@AllArgsConstructor
class DataSourceConfig implements Serializable {
  private static final long serialVersionUID = 3178620210804628886L;
  private String driver;
  private String password;
  private String url;
  private String username;
}
