package com.cloud.icenter.base.file;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
import org.springframework.stereotype.Component;

import com.cloud.icenter.base.pojo.Progress;

 
@Component
public class FileUploadProgressListener implements ProgressListener {
    private HttpSession session;
 
    public void setSession(HttpSession session){
        this.session=session;
        Progress status = new Progress();
        session.setAttribute("status", status);
    }
 
    /*
     * pBytesRead 到目前为止读取文件的比特数 pContentLength 文件总大小 pItems 目前正在读取第几个文件
     */
    public void update(long pBytesRead, long pContentLength, int pItems) {
        Progress status = (Progress) session.getAttribute("status");
        status.setpBytesRead(pBytesRead);
        status.setpContentLength(pContentLength);
        status.setpItems(pItems);
    }
 
}
