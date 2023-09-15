package kr.co.teaspoon.controller;

import kr.co.teaspoon.dto.Dat;
import kr.co.teaspoon.service.DatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/dat/*")
public class DatController {

    @Autowired
    private DatService datService;

    @GetMapping("insert.do")
    public String insertForm(HttpServletRequest request, Model model) throws Exception {
        return "/dat/datInsert";
    }

    @PostMapping("insert.do")
    public String datInsert(HttpServletRequest request, Model model) throws Exception {
        Dat dat = new Dat();
        dat.setAuthor(request.getParameter("id"));
        dat.setContent(request.getParameter("content"));
        dat.setPar(Integer.parseInt(request.getParameter("par")));
        datService.datInsert(dat);
        return "redirect:/free/detail.do?fno="+request.getParameter("par");
    }

    @GetMapping("delete.do")
    public String datDelete(HttpServletRequest request, Model model) throws Exception {
        int dno = Integer.parseInt(request.getParameter("dno"));
        datService.datDelete(dno);
        return "redirect:list.do";
    }

}
