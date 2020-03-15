package cn.kong.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.kong.elfinder.param.Node;
import cn.kong.web.config.ElfinderConfiguration;
import cn.kong.web.utils.FileInfo;
import cn.kong.web.utils.FileUtils;
import cn.kong.web.utils.Result;
import cn.kong.web.utils.ResultCodeEnum;

@Controller
@RequestMapping("/tree")
public class FileInfoController {
	@Autowired
    private ElfinderConfiguration elfinderConfiguration;
	
	@RequestMapping("/all/{appKey}")
	@ResponseBody
    public Result<FileInfo> index(@PathVariable String appKey){
		System.out.println("appKey: " + appKey);
		String dirPath = "";
		String host = "";
		List<Node> elfinderConfigurationVolumes = elfinderConfiguration.getVolumes();		
		for (Node node : elfinderConfigurationVolumes) {
			String appkey = node.getAppkey();
			if(appKey!=null && appkey.equals(appKey)) {
				String path = node.getPath();
				host = node.getHost();
				if(path !=null && !path.trim().isEmpty()) {
					dirPath = path.trim();
				}
			}
		}
		
		FileInfo fileInfo = null;
		try {
			fileInfo = FileUtils.listDirectorywithRelativePath(dirPath);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Result.failure(ResultCodeEnum.EXCEPTION).setMsg("获取文件列表异常：" + e.getMessage());
		}
		Map<String, Object> map = new HashMap<>();
		map.put("host", host);
		
        return Result.success(fileInfo).setExtra(map);
    }
}
