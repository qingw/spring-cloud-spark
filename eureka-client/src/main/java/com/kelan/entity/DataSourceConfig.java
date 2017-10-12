package com.kelan.entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xd031 on 2017/9/27.
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * spring.datasource.password=password
 * spring.datasource.url=jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8
 * spring.datasource.username=username
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceConfig implements Serializable {
  private static final long serialVersionUID = 3178620210804628886L;
  private String driver;
  private String password;
  private String url;
  private String username;
  private String port;
}
