package top.lazyr.service;

import org.lionsoul.ip2region.*;
import org.springframework.stereotype.Service;
import top.lazyr.model.pojo.Region;
import top.lazyr.util.IPUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class IPService {


    public Region ipParse(HttpServletRequest request){
        String ip = request.getRemoteHost();
        int port = request.getRemotePort();

        Region region = IPUtils.ip2Region(ip,port);
        return region;
    }

    public String getHtml(HttpServletRequest request){
        Region region = ipParse(request);
        StringBuffer html = new StringBuffer();
        html.append("<br/><br/><br/><br/><br/><br/>");
        html.append("<h1 align='center'>您访问该网站使用的ip和端口号为"+region.getIp()+":"+region.getPort()+"</h1>");
        html.append("<h1 align='center'>您现在位于"+region.getCountry()+region.getProvince()+region.getCity()+"</h1>");
        html.append("<h1 align='center'>您使用的ip供应商为"+region.getServerVendor()+"</h1>");
        return html.toString();
    }
}
