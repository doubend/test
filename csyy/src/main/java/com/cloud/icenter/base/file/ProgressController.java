package com.cloud.icenter.base.file;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.icenter.base.controller.BaseAction;
import com.cloud.icenter.base.pojo.Progress;
import com.cloud.icenter.common.utils.SystemConfig;
 
@Controller
@SessionAttributes("status")
public class ProgressController extends BaseAction{
 
    @RequestMapping(value = "/upfile/progress", method={RequestMethod.GET,RequestMethod.POST} )
    @ResponseBody
    public void initCreateInfo(Map<String, Object> model) {
        Progress status = (Progress) model.get("status");
        if(status==null){
        	printJson(status);
        }
        printJson(status);
        //return status.toString();
    }
    
    @RequestMapping(value = "/upfile", method = RequestMethod.GET)
	public String timeout() {
		//setAttribute("syncLogin", SystemConfig.getProperty("sync.login"));
		return "system/file";
	}
    
    @RequestMapping(value = "/upfile/file", method={RequestMethod.GET,RequestMethod.POST})
    public void uploadFile(@RequestParam(value = "file") MultipartFile... files) throws IOException {
        for (MultipartFile f : files) {
            if (f.getSize() > 0) {
                File targetFile = new File(System.getProperties().getProperty("user.home")+"/"+f.getOriginalFilename());
                f.transferTo(targetFile);//写入目标文件
            }
        }
        printJson("{mes:ok}");
        //return "{mes:ok}";
    }
    
}
