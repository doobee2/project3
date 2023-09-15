package kr.co.teaspoon.controller;

import kr.co.teaspoon.dto.Dat;
import kr.co.teaspoon.service.DatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView datDelete(HttpServletRequest request, Model model) throws Exception {
        int dno = Integer.parseInt(request.getParameter("dno"));
        int fno = Integer.parseInt(request.getParameter("fno"));
        datService.datDelete(dno);
        model.addAttribute("fno", fno);
        ModelAndView mav = new ModelAndView();
        mav.setView(new RedirectView(request.getContextPath() + "/free/detail.do"));
        return mav;
        //String referer = request.getHeader("Referer");      // 요청한 페이지를 기억해서 보냄
        //System.out.println(referer);
        //return "redirect:/" + referer;
//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("http://www.naver.com");
//        return redirectView;
    }

}
