package com.n22.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost/web/swagger-ui.html  访问地址
 * 在配置类中添加@EnableSwagger2注解来启用Swagger2，apis()定义了扫描的包路径。
 * Swagger常用注解
 * @Api:修饰整个类，描述Controller的作用；
 * @ApiOperation：描述一个类的一个方法，或者说一个接口；
 * @ApiParam:单个参数描述；
 * @ApiModel:用对象来接收参数；
 * @ApiProperty:用对象接收参数时，描述对象的一个字段；
 * @ApiResponse:HTTP响应其中1个描述；
 * @ApiResponses:HTTP响应整体描述；
 * @ApiIgnore:使用该注解忽略这个API；
 * @ApiError:发生错误返回的信息；
 * @ApiImplicitParam:一个请求参数；
 * @ApiImplicitParams:多个请求参数。
 * 
 * @author zjw_guosj
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(buildApiInf()).select()
				.apis(RequestHandlerSelectors.basePackage("com.n22.springboot.controller"))
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
	}

	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder().title("系统RESTful API文档")
				.contact(new Contact("XiaoAJie","https://mrbird.cc","guoshijie_vip@126.com")).version("1.0").build();
	}
	
}
