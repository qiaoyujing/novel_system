package com.qj.novel;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MybatisPlusGenerator {
    public static void main(String[] arg) {

        AutoGenerator generator = new AutoGenerator();

        //1. 全局配置
        GlobalConfig config = new GlobalConfig();
        //  获取用户程序当前路径
        String projectPath = System.getProperty("user.dir");
        // 设置输出到的目录
        config.setOutputDir(projectPath + "/novel_base/src/main/java");
        config.setAuthor("QiaoJing");
        // 生成结束后是否打开文件夹
        config.setOpen(false);
        //  是否覆盖已有文件
        config.setFileOverride(false);
        // 设置service接口生成名称，这样生成接口就不会有I
        config.setServiceName("%sService");
        config.setBaseColumnList(true).setBaseResultMap(true);
        // 全局配置添加到 generator 上
        generator.setGlobalConfig(config);

        //2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //  数据库类型
//        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/novel?useUnicode=true&characterEncoding=UTF-8&amp;zeroDateTimeBehavior=convertToNull&generateSimpleParameterMetadata=true&autoReconnect=true");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("qiaojing123");

        // 数据源配置添加到 generator代码生成器主类
        generator.setDataSource(dataSourceConfig);

        //3. 包配置, 生成的代码放在哪个包下
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setModuleName("newss");// 父包模块名
        packageConfig.setParent("com.qj.novel");// 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        packageConfig.setService("service");// Service包名
        packageConfig.setEntity("entity");// Entity包名
        packageConfig.setServiceImpl("service.impl");// ServiceImpl包名
        packageConfig.setMapper("mapper");// Mapper包名
        packageConfig.setController("controller");// Contoller包名
        packageConfig.setXml("mapper.xml");// Mapper.xml包名
        // 包配置添加到 generator
        generator.setPackageInfo(packageConfig);

        //4. 策略配置 数据库表配置，通过该配置，可指定需要生成哪些表或者排除哪些表等信息，
        StrategyConfig strategyConfig = new StrategyConfig();
        // 下划线驼峰命名转换
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自定义继承类全称，带包名 (以下为示例)
//        strategyConfig.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategyConfig.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategyConfig.setEntityLombokModel(true);// 【实体】是否为lombok模型（默认 false）
        strategyConfig.setRestControllerStyle(true);// 生成 @RestController 控制器
//        strategyConfig.setSuperEntityColumns("id");// 写于父类中的公共字段
        String[] tables=new String[]{""};
        strategyConfig.setInclude(tables);// 需要包含的表名，允许正则表达式（与exclude二选一配置）
//        strategyConfig.setExclude("m_fnd_user1");// 需要排除的表名，允许正则表达式
//        strategyConfig.setControllerMappingHyphenStyle(true);// 驼峰转连字符
        strategyConfig.setEntityTableFieldAnnotationEnable(true);// 是否生成实体时，生成字段注解 默认false;
        // 把策略配置添加到代码生成器主类
        generator.setStrategy(strategyConfig);

//   5. 向代码生成器主类上配置模板引擎，这是是freemarker，mpg.execute()方法就是执行生成代码类。
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 开始生成
        generator.execute();
    }
}
