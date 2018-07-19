package com.hycxkj.plugin.util;

import org.apache.velocity.VelocityContext;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/29 15:45
 */
public class ControllerGeneratorUtil {

    private static String controller_vm = "/template/controller.vm";

    public static void generator(
            String packageName,
            String module,
            String modelClass){

        String modelName = modelClass.substring(0,1).toLowerCase() + modelClass.substring(1);
        VelocityContext context = new VelocityContext();
        context.put("createTime",new SimpleDateFormat("yyyy/MM/dd hh:mm").format(new Date()));
        context.put("packageName",packageName);
        context.put("module",module);
        context.put("modelClass",modelClass);
        context.put("modelName",modelName);
        String controllerPath = ControllerGeneratorUtil.class.getResource("/").getPath().replaceAll("/target/classes/","/src/main/java/" + packageName.replace(".","/") + "/" + module + "/controller/");
        File file = new File(controllerPath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String controllerJava = modelClass + "Controller.java";
        try {
            VelocityUtil.generate(controller_vm,controllerPath + controllerJava,context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
