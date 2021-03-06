package top.lazyr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lazyr.model.pojo.Region;
import top.lazyr.service.IPService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IPController {
    @Autowired
    private IPService service;

    @RequestMapping("/")
    public String  show(HttpServletRequest request){
                return service.getHtml(request);
    }

    @RequestMapping("/data")
    public Region ipParse(HttpServletRequest request){
        return service.ipParse(request);
    }
}
