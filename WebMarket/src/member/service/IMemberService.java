package member.service;

import java.util.List;

import vo.MemberVO;

public interface IMemberService {

	public List<MemberVO> selectAll();

	public boolean checkMember(String memId);

	public int insertMember(MemberVO memberVO);

	public MemberVO getMember(String memId);

	public int updateMember(MemberVO memVO);

	public int deleteMember(String memId);

}
