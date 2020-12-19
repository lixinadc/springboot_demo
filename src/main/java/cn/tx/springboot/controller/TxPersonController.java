package cn.tx.springboot.controller;

import cn.tx.springboot.model.TxPerson;
import cn.tx.springboot.service.TxPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TxPersonController {

    @Autowired
    TxPersonService personService;

    @GetMapping("/main")
    public String main(Model model){
        List<TxPerson> pList = personService.selectPersons();
        model.addAttribute("pList", pList);
        return "main";
    }

    @GetMapping("/getPerson")
    public String main(int pid, Model model){
        TxPerson p = personService.getPeronById(pid);
        model.addAttribute("p", p);
        return "update";
    }

    @PostMapping("/save")
    public String save(TxPerson person){
        personService.insert(person);
        return "redirect:main";
    }

    @PostMapping("/login")
    public String login(TxPerson person,HttpSession session,Model model){
        Map<String,String> map =new HashMap<>();
        map.put("username",person.getUsername());
        map.put("password",person.getPassword());
        TxPerson personByUserPass = personService.getPersonByUserPass(map);
        if(personByUserPass!=null){
            session.setAttribute("user",personByUserPass);
            return "redirect:index";
        }else{
            model.addAttribute("tip","您的用户名密码不正确");
            return "login";
        }
    }


    @PostMapping("/update")
    public String update(TxPerson person){
        personService.updatePerson(person);
        return "redirect:main";
    }

    @GetMapping("/delete")
    public String delete(int pid){
        personService.delete(pid);
        return "redirect:main";
    }


    /*@PostMapping("/login")
    public String login(TxPerson person, HttpSession session, Model model){
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", person.getUsername());
        map.put("password", person.getPassword());
        TxPerson p = personService.getPersonByUserPass(map);
        if(p != null){
            session.setAttribute("user",p);
            return "redirect:index";
        }else{
            model.addAttribute("tip", "用户名或者密码错误");
            return "login";
        }


    }*/


}
