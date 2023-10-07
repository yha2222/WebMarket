package member.dao;

import java.util.List;

import vo.MemberVO;

public interface IMemberDao {

	public List<MemberVO> selectAll();

	public boolean checkMember(String memId);

	public int insertMember(MemberVO memberVO);

	public MemberVO getMember(String memId);
}
