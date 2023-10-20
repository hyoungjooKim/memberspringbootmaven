package kr.rsmaven.member.mapper;

import kr.rsmaven.member.component.MemberDTO;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    public MemberDTO getUser(String userid);
    public List<MemberDTO> getUserList();
    public void insertUser(MemberDTO user);
    public void updateUser(@Param("user") MemberDTO user, @Param("userid") String userid);
    public void deleteUser(String userid);
    public int checkUser(String userid);
}
