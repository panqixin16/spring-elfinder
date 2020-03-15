package cn.kong.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@Value("${token}")
    private String token;
	
    @RequestMapping("/")
    public String index(String token){
    	if(token==null || "".equals(token) || !token.equals(this.token))
    		return "redirect:/error/token";
        return "index";
    }
    
    @RequestMapping("/dist")
    public String dist(){
        return "dist/index";
    }
    
    @RequestMapping("/error/token")
    public String errorToken() {
    	return "error2";
    }
    
}
