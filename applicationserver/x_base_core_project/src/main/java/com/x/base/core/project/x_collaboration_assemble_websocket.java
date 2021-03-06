package com.x.base.core.project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.x.base.core.entity.StorageType;
import com.x.base.core.project.gson.XGsonBuilder;

public class x_collaboration_assemble_websocket extends AssembleA {

	public static final String name = "协作";
	public static List<String> containerEntities = new ArrayList<>();
	public static List<StorageType> usedStorageTypes = new ArrayList<>();
	public static List<Class<? extends Compilable>> dependents = new ArrayList<>();

	static {
        containerEntities.add("com.x.collaboration.core.entity.SMSMessage");
		containerEntities.add("com.x.collaboration.core.entity.Notification");
		containerEntities.add("com.x.collaboration.core.entity.Dialog");
		containerEntities.add("com.x.collaboration.core.entity.Talk");
		dependents.add(x_base_core_project.class);
		dependents.add(x_collaboration_core_message.class);
		dependents.add(x_collaboration_core_entity.class);
		dependents.add(x_collaboration_service_message.class);
		dependents.add(x_organization_core_express.class);
	}

	protected void custom(File lib, String xLib) throws Exception {
		// File xLibDir = new File(xLib);
		// File libDir = new File(lib, "WEB-INF/lib");
		// for (Class<? extends Compilable> clz : dependents) {
		// FileUtils.copyDirectory(xLibDir, libDir, new
		// NameFileFilter(clz.getSimpleName() + "-" + VERSION + ".jar"));
		// }
	}

	public static void main(String[] args) {
		try {
			String str = args[0];
			str = StringUtils.replace(str, "\\", "/");
			Argument arg = XGsonBuilder.instance().fromJson(str, Argument.class);
			x_collaboration_assemble_websocket o = new x_collaboration_assemble_websocket();
			o.pack(arg.getDistPath(), arg.getRepositoryPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
