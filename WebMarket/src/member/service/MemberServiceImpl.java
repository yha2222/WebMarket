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
	public List<MemberVO> getMemberList() {
		return memberDao.getMemberList();
	}

}
