package com.n22.springboot.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * mybatis配置多数据源的配置DB2
 * @author zjw_guosj
 *
 */
@Configuration
@MapperScan(basePackages = MyBatisDataSourceConfigDB2.PACKAGE,sqlSessionFactoryRef = "sqlSessionFactoryDB2")
public class MyBatisDataSourceConfigDB2 {

		// dao扫描路径
		static final String PACKAGE = "com.n22.springboot.dao.db2";
		
		// mybatis mapper扫描路径
		static final String MAPPER_LOCATION = "classpath:mapper/db2/*.xml";
	
		@Bean("dataSourceDB2")
		@ConfigurationProperties("spring.datasource.druid.db2")
		public DataSource dataSource() {
			return DruidDataSourceBuilder.create().build();
		}
		
		@Bean("dataSourceTransactionManagerDB2")
		public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSourceDB2") DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
		
		@Bean("sqlSessionFactoryDB2")
		public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceDB2") DataSource dataSource) throws Exception {
			final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
			sqlSessionFactoryBean.setDataSource(dataSource);
			//如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
			sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
			return sqlSessionFactoryBean.getObject();
		}
}
