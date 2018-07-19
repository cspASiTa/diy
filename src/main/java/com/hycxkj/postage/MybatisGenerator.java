package com.hycxkj.postage;

import com.hycxkj.plugin.util.MybatisGeneratorUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈少平
 * @description
 * @create in 2018/3/28 22:02
 */
public class MybatisGenerator {

    private static Map<String,String> LAST_INSERT_ID_TABLES = new HashMap<>();
    private static List<Map<String, Object>> tables = new ArrayList<>();
//    private static Object [] tableNames = {"postage_carry_mode","postage_package_condition","postage_postage_template"};
    private static Object [] tableNames = {"postage_package_condition"};
//    private static Object [] tableNames = {"provincial","city"};
//    private static Object [] domianNames = {"PostageCarryMode","PostagePackageCondition","PostageTemplate"};
    private static Object [] domianNames = {"PostagePackageCondition"};
//    private static Object [] domianNames = {"Provincial","City"};
    private static String bathPackage = "com.hycxkj";
    private static String module = "postage";

    public static void main(String[] args) throws Exception {
        lastInsertIdTables();
        addTables();
        MybatisGeneratorUtil.disableGeneratorServiceAndController();
        MybatisGeneratorUtil.generator(bathPackage,module,tables,LAST_INSERT_ID_TABLES);
    }

    public static void lastInsertIdTables() {
        LAST_INSERT_ID_TABLES.put("postage_package_condition","id");
//        LAST_INSERT_ID_TABLES.put("postage_shop_item","id");
//        LAST_INSERT_ID_TABLES.put("postage_postage_template","id");
    }

    public static void addTables() {
        Map<String,Object> map;
        for(int i = 0; i < tableNames.length; i++) {
            map = new HashMap<>(2);
            map.put("table_name", tableNames[i]);
            map.put("model_name", domianNames[i]);
            tables.add(map);
        }
    }
}
