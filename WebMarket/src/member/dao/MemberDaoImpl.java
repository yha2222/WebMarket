package member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import util.MyBatisUtil;
import vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	public static IMemberDao memberDao;
	
	public MemberDaoImpl() {
		
	}
	
	public static IMemberDao getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDaoImpl();
		}
		return memberDao;
	}

	@Override
	public List<MemberVO> selectAll() {
		List<MemberVO> memberList = new ArrayList<>();
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			memberList = session.selectList("member.getMemList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return memberList;
		
	}

}
