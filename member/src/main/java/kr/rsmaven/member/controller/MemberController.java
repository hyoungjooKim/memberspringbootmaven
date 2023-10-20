package kr.rsmaven.member.controller;

import kr.rsmaven.member.component.MemberDTO;
import kr.rsmaven.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class MemberController {

    @Autowired
    private MemberService Service;

    @RequestMapping(value = "/{userid}", produces = "application/json; charset=utf-8")
    public MemberDTO getUser(@PathVariable String userid) {
        MemberDTO user = Service.getUser(userid);
        System.out.println(userid+"의 정보 확인");
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public List<MemberDTO> allUser(){
        List<MemberDTO> userList = Service.getUserList();
        System.out.println("전체 테이터베이스 정보 확인");
        return userList;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public String insert(@RequestBody MemberDTO user) {
        String result = "";

        if(user != null) {
            System.out.println("신규 유저 추가");
            System.out.println(user.toString());

            Service.insertUser(user);
            result = "생성 완료";
            return result;
        }else {
            result = "생성 미완료";
            return result;
        }
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.PATCH, produces = "application/json; charset=utf-8")
    public String update(@RequestBody MemberDTO user,@PathVariable String userid) {
        String result = "";
        int usercheck = Service.checkUser(userid);
        if(usercheck == 1) {
            System.out.println(userid+"의 정보 수정");
            Service.updateUser(user, userid);
            result = "수정 완료";
            return result;
        }else {
            result = "생성 미완료 - 계정 정보가 없습니다.";
            return result;
        }
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
    public String delete(@PathVariable String userid) {
        String result = "";
        int usercheck = Service.checkUser(userid);
        if(usercheck == 1) {
            System.out.println(userid+"의 정보 삭제");
            Service.deleteUser(userid);
            result = "삭제 완료";
            return result;
        }else {
            result = "삭제 미완료 - 계정 정보가 없습니다.";
            return result;
        }
    }
}
