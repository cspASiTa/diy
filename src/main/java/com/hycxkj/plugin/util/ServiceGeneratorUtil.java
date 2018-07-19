package com.hycxkj.plugin.util;

import org.apache.velocity.VelocityContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 8:14
 */
public class ServiceGeneratorUtil {
    // generatorConfig模板路径
    private static String service_vm = "/template/service.vm";
    private static String serviceImpl_vm = "/template/serviceImpl.vm";

    public static void generator(
            String packageName,
            String module,
            String modelClass,
            String primaryKeyType,
            String primaryKeyProperty) {
        String modelName = modelClass.substring(0,1).toLowerCase() + modelClass.substring(1);
        String servicePath ;
        String serviceImplPath ;
        VelocityContext context = new VelocityContext();
        context.put("createTime",new SimpleDateFormat("yyyy/MM/dd hh:mm").format(new Date()));
        context.put("packageName",packageName);
        context.put("module",module);
        context.put("modelClass",modelClass);
        context.put("modelName",modelName);
        context.put("primaryKeyType",primaryKeyType);
        context.put("primaryKeyProperty",primaryKeyProperty);
        servicePath = ServiceGeneratorUtil.class.getResource("/").getPath().replaceAll("/target/classes/","/src/main/java/" + packageName.replace(".","/") + "/" + module + "/service/");
        serviceImplPath = servicePath + "/impl/";
        System.out.println("servicePath " + servicePath);
        System.out.println("serviceImplPath " + serviceImplPath);
        File file = new File(servicePath);
        if(!file.exists()) {
            file.mkdirs();
        }
        File file1 = new File(serviceImplPath);
        if(!file1.exists()) {
            file1.mkdirs();
        }
        String service = modelClass + "Service.java";
        String serviceImpl = modelClass + "ServiceImpl.java";
        try {
            System.out.println("service  " + service);
            System.out.println("serviceImpl " +serviceImpl);
            VelocityUtil.generate(service_vm,servicePath + service,context);
            VelocityUtil.generate(serviceImpl_vm, serviceImplPath +serviceImpl ,context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
