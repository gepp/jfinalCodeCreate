package platform.codecreate.generate;
import java.util.HashMap;
import java.util.Map;

import platform.base.db.model.ConnectParamBean;
import platform.base.db.util.EntityUtil;
import platform.base.util.PlatformTool;
import platform.codecreate.configbaseinfo.model.ConfigBasicInfo;

public class Generator {
	static String filesep = "/";
	public static void generator(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
		String outFilePath = outfilepath + "//" + filedir;
		String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
		String basePackagePath = packagePath.replace("","");
		basePackagePath = basePackagePath.replace(".", filesep);
		String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
		String lowerCaseObjName = ObjName.toLowerCase();
		String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
		//String jsPathObj = "js/" + basePackagePath;
		String tableName = configBaseInfo.getStr("ENGLISH_NAME");
		String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
		Map ctx = new HashMap();
		ctx.put("packagePath", packagePath);
		ctx.put("ObjName", ObjName);
		ctx.put("lowerCaseObjName", lowerCaseObjName);
		ctx.put("firstLowObjName", firstLowObjName);
		ctx.put("ObjCN", ObjCN);
		//ctx.put("jsPathObj", jsPathObj);
		ctx.put("tableName", tableName);
		ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
		ctx.put("basePackagePath", basePackagePath);
		ctx.put("projectName", project_name);
		String filePath = packagePath.replace(".", filesep);
		String javaPath = outFilePath + filesep + "src" + filesep + filePath + filesep + lowerCaseObjName;
		String actionPath = javaPath + filesep + "action" + filesep;
		String domainPath = javaPath + filesep + "model" + filesep;
		//String jsPath = outFilePath + filesep + "WebContent/js" + filesep + basePackagePath + filesep;
		String jspPath = outFilePath + filesep + "WebContent/WEB-INF/jsp" + filesep + basePackagePath + filesep + lowerCaseObjName + filesep;
		PlatformTool.createDirPath(javaPath);
		PlatformTool.createDirPath(actionPath);
		PlatformTool.createDirPath(domainPath);
	//	PlatformTool.createDirPath(jsPath);
		PlatformTool.createDirPath(jspPath);
		PlatformTool.generateFile("modelVM/flatBootstrap/action.vm", ctx, actionPath + ObjName + "Action.java");
		PlatformTool.generateFile("modelVM/flatBootstrap/model.vm", ctx, domainPath + ObjName + ".java");
		//PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
		PlatformTool.generateFile("modelVM/flatBootstrap/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
		PlatformTool.generateFile("modelVM/flatBootstrap/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
		PlatformTool.generateFile("modelVM/flatBootstrap/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_modify.jsp");
		PlatformTool.generateFile("modelVM/flatBootstrap/jspview.vm", ctx, jspPath + lowerCaseObjName + "_view.jsp");
	}
	
	public static void generatorSSHFlatBootstrap(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
		String outFilePath = outfilepath + "//" + filedir;
		String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
		String basePackagePath = packagePath.replace("","");
		basePackagePath = basePackagePath.replace(".", filesep);
		String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
		String lowerCaseObjName = ObjName.toLowerCase();
		String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
		//String jsPathObj = "js/" + basePackagePath;
		String tableName = configBaseInfo.getStr("ENGLISH_NAME");
		String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
		Map ctx = new HashMap();
		ctx.put("packagePath", packagePath);
		ctx.put("ObjName", ObjName);
		ctx.put("lowerCaseObjName", lowerCaseObjName);
		ctx.put("firstLowObjName", firstLowObjName);
		ctx.put("ObjCN", ObjCN);
		//ctx.put("jsPathObj", jsPathObj);
		ctx.put("tableName", tableName);
		ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
		ctx.put("basePackagePath", basePackagePath);
		ctx.put("projectName", project_name);
		for(Object value:ctx.keySet()){
			System.out.print("key:"+value);
			System.out.println("-"+ctx.get(value));
		}
		String filePath = packagePath.replace(".", filesep);
		String javaPath = outFilePath + filesep + "src" + filesep + filePath + filesep + lowerCaseObjName;
		String actionPath = javaPath + filesep + "controller" + filesep;
		String domainPath = javaPath + filesep + "model" + filesep;
		String servicePath = javaPath + filesep + "service" + filesep;
		String serviceImplPath = javaPath + filesep + "service" + filesep+ "impl" + filesep;
		//String jsPath = outFilePath + filesep + "WebContent/js" + filesep + basePackagePath + filesep;
		String jspPath = outFilePath + filesep + "WebContent/WEB-INF/jsp" + filesep + basePackagePath + filesep + lowerCaseObjName + filesep;
		PlatformTool.createDirPath(javaPath);
		PlatformTool.createDirPath(actionPath);
		PlatformTool.createDirPath(domainPath);
		PlatformTool.createDirPath(servicePath);
		PlatformTool.createDirPath(serviceImplPath);
	//	PlatformTool.createDirPath(jsPath);
		PlatformTool.createDirPath(jspPath);
		PlatformTool.generateFile("modelVM/springFlatBootstrap/controller.vm", ctx, actionPath + ObjName + "Controller.java");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/model.vm", ctx, domainPath + ObjName + ".java");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/controller.vm", ctx, actionPath + ObjName + "Controller.java");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/iservice.vm", ctx,servicePath+"I"+ObjName+"Service" + ".java");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/serviceImpl.vm", ctx,serviceImplPath+ObjName+"ServiceImpl" + ".java");
		
		//PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
		PlatformTool.generateFile("modelVM/springFlatBootstrap/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_modify.jsp");
		//PlatformTool.generateFile("modelVM/springFlatBootstrap/jspview.vm", ctx, jspPath + lowerCaseObjName + "_view.jsp");
	 
	}
	
	public static void generatorjavaskweb(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
		String outFilePath = outfilepath + "//" + filedir;
		String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
		String basePackagePath = packagePath.replace("","");
		basePackagePath = basePackagePath.replace(".", filesep);
		String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
		String lowerCaseObjName = ObjName.toLowerCase();
		String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
		//String jsPathObj = "js/" + basePackagePath;
		String tableName = configBaseInfo.getStr("ENGLISH_NAME");
		String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
		Map ctx = new HashMap();
		ctx.put("packagePath", packagePath);
		ctx.put("ObjName", ObjName);
		ctx.put("lowerCaseObjName", lowerCaseObjName);
		ctx.put("firstLowObjName", firstLowObjName);
		ctx.put("ObjCN", ObjCN);
		//ctx.put("jsPathObj", jsPathObj);
		ctx.put("tableName", tableName);
		ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
		ctx.put("basePackagePath", basePackagePath);
		ctx.put("projectName", project_name);
		String filePath = packagePath.replace(".", filesep);
		String javaPath = outFilePath + filesep + "src" + filesep + filePath + filesep + lowerCaseObjName;
		String actionPath = javaPath + filesep + "action" + filesep;
		String domainPath = javaPath + filesep + "model" + filesep;
		//String jsPath = outFilePath + filesep + "WebContent/js" + filesep + basePackagePath + filesep;
		String jspPath = outFilePath + filesep + "WebContent/WEB-INF/jsp" + filesep + basePackagePath + filesep + lowerCaseObjName + filesep;
		PlatformTool.createDirPath(javaPath);
		PlatformTool.createDirPath(actionPath);
		PlatformTool.createDirPath(domainPath);
	//	PlatformTool.createDirPath(jsPath);
		PlatformTool.createDirPath(jspPath);
		PlatformTool.generateFile("modelVM/javaskweb/action.vm", ctx, actionPath + ObjName + "Action.java");
		PlatformTool.generateFile("modelVM/javaskweb/model.vm", ctx, domainPath + ObjName + ".java");
		//PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
		PlatformTool.generateFile("modelVM/javaskweb/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
		PlatformTool.generateFile("modelVM/javaskweb/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
		PlatformTool.generateFile("modelVM/javaskweb/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_modify.jsp");
		PlatformTool.generateFile("modelVM/javaskweb/jspview.vm", ctx, jspPath + lowerCaseObjName + "_view.jsp");
	 
	}
	
	
	public static void generatorSSH(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
		String outFilePath = outfilepath + "//" + filedir;
		String packagePath = configBaseInfo.getStr("PACKAGE_PATCH"); //com.v8
		String basePackagePath = packagePath.replace("","");
		basePackagePath = basePackagePath.replace(".", filesep);
		String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
		String lowerCaseObjName = ObjName.toLowerCase();
		String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
		//String jsPathObj = "js/" + basePackagePath;
		String tableName = configBaseInfo.getStr("ENGLISH_NAME");
		String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
		Map ctx = new HashMap();
		ctx.put("packagePath", packagePath);
		ctx.put("ObjName", ObjName);
		ctx.put("lowerCaseObjName", lowerCaseObjName);
		ctx.put("firstLowObjName", firstLowObjName);
		ctx.put("ObjCN", ObjCN);
		//ctx.put("jsPathObj", jsPathObj);
		ctx.put("tableName", tableName);
		ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
		ctx.put("basePackagePath", basePackagePath);
		ctx.put("projectName", project_name);
		String filePath = packagePath.replace(".", filesep);
		
		String javaPath = outFilePath + filesep + "src" + filesep + filePath + filesep +"web"+filesep+lowerCaseObjName;
		String controllerPath=javaPath + filesep + "controller" + filesep;
		String formPath=javaPath + filesep + "form" + filesep;
		String servicePath=javaPath + filesep + "service" + filesep;
		String serviceImplPath=javaPath + filesep + "service"+filesep+ "impl" + filesep;
		String voPath=javaPath + filesep + "vo" + filesep;
		
		
		String jspPath = outFilePath + filesep + "webapps/WEB-INF/pages" + filesep + lowerCaseObjName + filesep;
		String springConfigPath = outFilePath + filesep + "webapps" + filesep ;

		
		
		PlatformTool.createDirPath(javaPath);
		PlatformTool.createDirPath(controllerPath);
		PlatformTool.createDirPath(servicePath);
		PlatformTool.createDirPath(formPath);
		PlatformTool.createDirPath(serviceImplPath);
		PlatformTool.createDirPath(voPath);
		ConnectParamBean cpb =new ConfigBasicInfo().getConnectParamBean("bdeb6709da5943a5aed4697e0fde8ae8");
		EntityUtil.createEntity(formPath + ObjName + "Form.java",lowerCaseObjName,packagePath,ObjName,tableName,cpb);
	//	PlatformTool.createDirPath(jsPath);
		PlatformTool.createDirPath(jspPath);
		PlatformTool.generateFile("modelVM/ssh/controller.vm", ctx, controllerPath + ObjName + "ListController.java");
		//PlatformTool.generateFile("modelVM/ssh/form.vm", ctx, formPath + ObjName + "Form.java");
		PlatformTool.generateFile("modelVM/ssh/searchform.vm", ctx, formPath + ObjName + "SearchForm.java");
		PlatformTool.generateFile("modelVM/ssh/service.vm", ctx, servicePath + ObjName + "Service.java");
		PlatformTool.generateFile("modelVM/ssh/serviceImpl.vm", ctx, serviceImplPath + ObjName + "ServiceImpl.java");
		PlatformTool.generateFile("modelVM/ssh/basevo.vm", ctx, voPath + ObjName + "Vo.java");
		PlatformTool.generateFile("modelVM/ssh/columnvo.vm", ctx, voPath + "ColumnsVo.java");

		
		
		//PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
//		PlatformTool.generateFile("modelVM/flatBootstrap/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
//		PlatformTool.generateFile("modelVM/flatBootstrap/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
		PlatformTool.generateFile("modelVM/ssh/jsp.vm", ctx, jspPath + lowerCaseObjName + "_query.jsp");
		PlatformTool.generateFile("modelVM/ssh/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_edit.jsp");
		PlatformTool.generateFile("modelVM/ssh/manage-release.vm", ctx, springConfigPath + lowerCaseObjName + "_manage-release.xml");

		
	 
	}
	public static void generatorArk(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
String outFilePath = outfilepath + "//" + filedir;
		
		String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
		String basePackagePath = packagePath.replace("", "");
		basePackagePath = basePackagePath.replace(".", filesep);
		String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
		String aLObjName = ObjName.toLowerCase();
		String fLObjName = PlatformTool.toFirstLowerString(ObjName);
		String jsPathObj = "js/" + basePackagePath;
		String tName = configBaseInfo.getStr("ENGLISH_NAME");
		String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
		Map ctx = new HashMap();
		ctx.put("packagePath", packagePath);
		ctx.put("ObjName", ObjName);
		ctx.put("aLObjName", aLObjName);
		ctx.put("fLObjName", fLObjName);
		ctx.put("ObjCN", ObjCN);
		ctx.put("jsPathObj", jsPathObj);
		ctx.put("tName", tName);
		ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
		ctx.put("basePackagePath", basePackagePath);
		ctx.put("projectName", project_name);
		String filePath = packagePath.replace(".", filesep);
		String javaPath = outFilePath + filesep + "src" + filesep + filePath + filesep + aLObjName;
		String actionPath = javaPath + filesep + "action" + filesep;
		String domainPath = javaPath + filesep + "model" + filesep;
		String jsPath = outFilePath + filesep + "WebContent/js" + filesep + basePackagePath + filesep;
		String jspPath = outFilePath + filesep + "WebContent/WEB-INF/jsp" + filesep + basePackagePath + filesep + aLObjName + filesep;
		PlatformTool.createDirPath(javaPath);
		PlatformTool.createDirPath(actionPath);
		PlatformTool.createDirPath(domainPath);
		PlatformTool.createDirPath(jsPath);
		PlatformTool.createDirPath(jspPath);
		PlatformTool.generateFile("modelVM/arkminiui/action.vm", ctx, actionPath + ObjName + "Action.java");
		PlatformTool.generateFile("modelVM/arkminiui/model.vm", ctx, domainPath + ObjName + ".java");
		PlatformTool.generateFile("modelVM/arkminiui/js.vm", ctx, jsPath + aLObjName + ".js");
		PlatformTool.generateFile("modelVM/arkminiui/jsp.vm", ctx, jspPath + fLObjName + ".jsp");
		PlatformTool.generateFile("modelVM/arkminiui/jspadd.vm", ctx, jspPath + fLObjName + "_add" + ".jsp");
		PlatformTool.generateFile("modelVM/arkminiui/jsplist.vm", ctx, jspPath + fLObjName + "_json.jsp");
		PlatformTool.generateFile("modelVM/arkminiui/jspmodify.vm", ctx, jspPath + fLObjName + "_modify.jsp");
		PlatformTool.generateFile("modelVM/arkminiui/jspview.vm", ctx, jspPath + fLObjName + "_view.jsp");
		PlatformTool.generateFile("modelVM/arkminiui/jspviewmodify.vm", ctx, jspPath + fLObjName + "_viewModify.jsp");
	}
	
	   public static void finalsimple(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
	       String outFilePath = outfilepath + "//" + filedir;
	        String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
	        String basePackagePath = packagePath.replace("","");
	        basePackagePath = basePackagePath.replace(".", filesep);
	        String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
	        String lowerCaseObjName = ObjName.toLowerCase();
	        String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
	        //String jsPathObj = "js/" + basePackagePath;
	        String tableName = configBaseInfo.getStr("ENGLISH_NAME");
	        String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
	        Map ctx = new HashMap();
	        ctx.put("packagePath", packagePath);
	        ctx.put("ObjName", ObjName);
	        ctx.put("lowerCaseObjName", lowerCaseObjName);
	        ctx.put("firstLowObjName", firstLowObjName);
	        ctx.put("ObjCN", ObjCN);
	        //ctx.put("jsPathObj", jsPathObj);
	        ctx.put("tableName", tableName);
	        ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
	        ctx.put("basePackagePath", basePackagePath);
	        ctx.put("projectName", project_name);
	        for(Object value:ctx.keySet()){
	            System.out.print("key:"+value);
	            System.out.println("-"+ctx.get(value));
	        }
	        String filePath = packagePath.replace(".", filesep);
	        String serviceJavaPath = outFilePath+filesep+"archetype-service" + filesep + "src"+filesep+"main"+filesep+"java" + filesep + filePath + filesep + lowerCaseObjName;
	        String actionJavaPath  = outFilePath+filesep+"archetype-admin" + filesep + "src" + filesep +"main"+filesep+"java" + filesep + filePath + filesep + lowerCaseObjName;
	        String domainPath = serviceJavaPath + filesep + "model" + filesep;
	        String servicePath = serviceJavaPath + filesep + "service" + filesep;
	        String serviceImplPath =serviceJavaPath + filesep + "service" + filesep+ "impl" + filesep;
	        String actionPath = actionJavaPath + filesep + "controller" + filesep;
	        String jspPath = outFilePath+filesep+"archetype-admin" + filesep + "src"+filesep+"main"+filesep+ "webapp/WEB-INF/jsp" + filesep + basePackagePath + filesep + lowerCaseObjName + filesep;
	        PlatformTool.createDirPath(serviceJavaPath);
	        PlatformTool.createDirPath(actionJavaPath);
	        PlatformTool.createDirPath(actionPath);
	        PlatformTool.createDirPath(domainPath);
	        PlatformTool.createDirPath(servicePath);
	        PlatformTool.createDirPath(serviceImplPath);
	        PlatformTool.createDirPath(jspPath);
 	        PlatformTool.generateFile("modelVM/finalsimple/model.vm", ctx, domainPath + ObjName + ".java");
	        PlatformTool.generateFile("modelVM/finalsimple/controller.vm", ctx, actionPath + ObjName + "Controller.java");
	        PlatformTool.generateFile("modelVM/finalsimple/iservice.vm", ctx,servicePath+"I"+ObjName+"Service" + ".java");
	        PlatformTool.generateFile("modelVM/finalsimple/serviceImpl.vm", ctx,serviceImplPath+ObjName+"ServiceImpl" + ".java");
	        
	        //PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
	        PlatformTool.generateFile("modelVM/finalsimple/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
	        PlatformTool.generateFile("modelVM/finalsimple/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
	        PlatformTool.generateFile("modelVM/finalsimple/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_modify.jsp");
	        PlatformTool.generateFile("modelVM/finalsimple/jspview.vm", ctx, jspPath + lowerCaseObjName + "_view.jsp");
	        
	        
	    }
	   
	   public static void generatorsuning(ConfigBasicInfo configBaseInfo, String filedir,String outfilepath,String project_name) {
	        String outFilePath = outfilepath + "//" + filedir;
	        String packagePath = configBaseInfo.getStr("PACKAGE_PATCH");
	        String basePackagePath = packagePath.replace("","");
	        basePackagePath = basePackagePath.replace(".", filesep);
	        String ObjName = configBaseInfo.getStr("TABLE_OBJECT_NAME");
	        String lowerCaseObjName = ObjName.toLowerCase();
	        //lowerCaseObjName="";
	        String firstLowObjName = PlatformTool.toFirstLowerString(ObjName);
	        String tableName = configBaseInfo.getStr("ENGLISH_NAME");
	        String ObjCN=configBaseInfo.getStr("SCENARIO_NAME");
	        Map ctx = new HashMap();
	        ctx.put("packagePath", packagePath);
	        ctx.put("ObjName", ObjName);
	        ctx.put("lowerCaseObjName", lowerCaseObjName);
	        ctx.put("firstLowObjName", firstLowObjName);
	        ctx.put("ObjCN", ObjCN);
	        //ctx.put("jsPathObj", jsPathObj);
	        ctx.put("tableName", tableName);
	        ctx.put("configBasicExtendInfoList", configBaseInfo.getExtendList());
	        ctx.put("basePackagePath", basePackagePath);
	        ctx.put("projectName", project_name);
	 
	        String filePath = packagePath.replace(".", filesep);
	        String modelPath=outFilePath + filesep + "ips-intf/src/main/java" + filesep + filePath + filesep +"entity/";
	        String servicePath=outFilePath + filesep + "ips-intf/src/main/java" + filesep + filePath + filesep +"service/";
	        String serviceImplPath=outFilePath + filesep + "ips-service/src/main/java" + filesep + filePath + filesep +"service/impl/";
	        String sqlMapPath=outFilePath + filesep + "ips-service/src/main/resources/conf/sqlMap/";
	        
	        //String jspPath = outFilePath + filesep + "WebContent/WEB-INF/jsp" + filesep + basePackagePath + filesep + lowerCaseObjName + filesep;
	        PlatformTool.createDirPath(modelPath);
	        PlatformTool.createDirPath(servicePath);
	        PlatformTool.createDirPath(serviceImplPath);
	        PlatformTool.createDirPath(sqlMapPath);
	        
	        PlatformTool.generateFile("modelVM/suning/model.vm", ctx, modelPath + ObjName + ".java");
	        PlatformTool.generateFile("modelVM/suning/service.vm", ctx, servicePath +ObjName+ "Service.java");
	        PlatformTool.generateFile("modelVM/suning/serviceImpl.vm", ctx, serviceImplPath + ObjName+"ServiceImpl.java");
	        PlatformTool.generateFile("modelVM/suning/sqlMap.vm", ctx, sqlMapPath + "sqlMap_"+lowerCaseObjName+".xml");

//	      PlatformTool.generateFile("modelVM/js.vm", ctx, jsPath + aLObjName + ".js");
//	      PlatformTool.generateFile("modelVM/flatBootstrap/jsp.vm", ctx, jspPath + lowerCaseObjName + ".jsp");
//	      PlatformTool.generateFile("modelVM/flatBootstrap/jspadd.vm", ctx, jspPath + lowerCaseObjName + "_add" + ".jsp");
//	      PlatformTool.generateFile("modelVM/flatBootstrap/jspmodify.vm", ctx, jspPath + lowerCaseObjName + "_modify.jsp");
//	      PlatformTool.generateFile("modelVM/flatBootstrap/jspview.vm", ctx, jspPath + lowerCaseObjName + "_view.jsp");
	     
	    }

}
