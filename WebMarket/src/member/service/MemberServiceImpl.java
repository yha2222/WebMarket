package member.service;

import java.util.List;

import org.apache.catalina.tribes.membership.MemberImpl;

import member.dao.IMemberDao;
import member.dao.MemberDaoImpl;
import vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	private IMemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = MemberDaoImpl.getInstance();
	}
	
	public static IMemberService getInstance() {
		return instance;
	}

	@Override
	public List<MemberVO> selectAll() {
		return memberDao.selectAll();
	}

	@Override
	public boolean checkMember(String memId) {
		return memberDao.checkMember(memId);
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		return memberDao.insertMember(memberVO); 
	}

	@Override
	public MemberVO getMember(String memId) {
		return memberDao.getMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) {
		return memberDao.updateMember(memVO);
	}

	@Override
	public int deleteMember(String memId) {
		return memberDao.deleteMember(memId);
	}



}
