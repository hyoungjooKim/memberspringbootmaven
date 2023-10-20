package kr.rsmaven.member.service;

import kr.rsmaven.member.component.MemberDTO;

import java.util.List;

public interface MemberService {
    public MemberDTO getUser(String userid);
    public List<MemberDTO> getUserList();
    public void insertUser(MemberDTO user);
    public void updateUser(MemberDTO user,String userid);
    public void deleteUser(String userid);
    public int checkUser(String userid);
}
