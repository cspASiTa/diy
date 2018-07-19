package com.hycxkj.plugin.util;

import com.hycxkj.common.annotation.PrimaryKey;
import org.apache.velocity.VelocityContext;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/28 21:17
 */
public class MybatisGeneratorUtil {
    // generatorConfig模板路径
    private static String generatorConfig_vm = "/template/generatorConfig.vm";

    private static boolean isGeneratorServiceAndController = true;
    private static boolean isRunMybatisGenerator = true;

    /**
     * @param bathPackage 基础的包名
     * @param module 模块的名字
     * @param tables  1个Map里面存放着2个元素 key1:table_name  key2:model_name
     * @param lastInsertIdTables  插入主键
     * @throws Exception
     */
    public static void generator(
            String bathPackage,
            String module,
            List<Map<String, Object>> tables,
            Map<String, String> lastInsertIdTables
            ) throws Exception {

        if(isRunMybatisGenerator) {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().startsWith("win")) {
                generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath().replaceFirst("/", "");
            } else {
                generatorConfig_vm = MybatisGeneratorUtil.class.getResource(generatorConfig_vm).getPath();
            }
            String generatorConfigXml = MybatisGeneratorUtil.class.getResource("/").getPath().replace("/target/classes/", "") + "/src/main/resources/generatorConfig-"+module+".xml";
            System.out.println("========== 开始生成generatorConfig.xml文件 ==========");
            try {
                VelocityContext context = new VelocityContext();

                String generator_javaModelGenerator_targetPackage = bathPackage + "." + module + ".bean";
                String generator_sqlMapGenerator_targetPackage = "resources/mybatis/mapper/" + module;
                String generator_javaClientGenerator_targetPackage =  bathPackage + "." + module + ".mapper";

                context.put("tables", tables);
                context.put("generator_javaModelGenerator_targetPackage", generator_javaModelGenerator_targetPackage);
                context.put("generator_sqlMapGenerator_targetPackage", generator_sqlMapGenerator_targetPackage);
                context.put("generator_javaClientGenerator_targetPackage", generator_javaClientGenerator_targetPackage);
                context.put("last_insert_id_tables", lastInsertIdTables);
                VelocityUtil.generate(generatorConfig_vm, generatorConfigXml, context);

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("========== 结束生成generatorConfig.xml文件 ==========");

            System.out.println("========== 开始运行 mybatisGenerator插件 ==========");
            String generatorFilePath = MybatisGeneratorUtil.class.getResource("/").getPath().replace("target/classes/","") + "/src/main/resources/generatorConfig-" + module + ".xml";
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File(generatorFilePath);
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("========== 结束运行 mybatisGenerator插件 ==========");
        }

        System.out.println("========== 开始生成 Service、ServiceImpl、controller ==========");
        if(isGeneratorServiceAndController) {
            tables.forEach(item -> {
                String modelClass = String.valueOf(item.get("model_name"));
                try {
                    Class cls = Class.forName(bathPackage + "." + module + ".bean." + modelClass);
                    String primaryKeyType = "";
                    String primaryKeyProperty = "";
                    Field[] fields = cls.getDeclaredFields();
                    for (Field field : fields) {
                        PrimaryKey annotation = field.getAnnotation(PrimaryKey.class);
                        if(!Objects.isNull(annotation)) {
                            primaryKeyType = field.getType().getSimpleName();
                            String fieldName = field.getName();
                            primaryKeyProperty = fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                            System.out.println("primaryKeyType "+ primaryKeyType);
                            System.out.println("primaryKeyProperty " + primaryKeyProperty);
                        }
                    }
                    ServiceGeneratorUtil.generator(bathPackage,module,modelClass,primaryKeyType,primaryKeyProperty);
                    ControllerGeneratorUtil.generator(bathPackage,module,modelClass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("========== 结束生成 Service、ServiceImpl、controller ==========");
    }

    /**
     * 不生成 service 和 控制层代码
     */
    public static void disableGeneratorServiceAndController() {
        isGeneratorServiceAndController = false;
    }

    /**
     * 不运行 mybatis generator 插件
     */
    public static void disableRunMybatisGenerator() {
        isRunMybatisGenerator = false;
    }
}
