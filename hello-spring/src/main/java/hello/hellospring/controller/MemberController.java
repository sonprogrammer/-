package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){

        this.memberService = memberService;
    }
    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")//실제 회원을 등록하는 기능
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";//회원가입 끝나면 홈화면으로 다시 돌려보내기
    }
    @GetMapping(value = "/members") //멤버 조회기능
        public String list(Model model){
            List<Member> members = memberService.findMembers();
            model.addAttribute("members", members);
            return "members/memberList";
        }


}
