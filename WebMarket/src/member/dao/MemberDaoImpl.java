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

	@Override
	public boolean checkMember(String memId) {
		
		boolean isExist = false;
		
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			int cnt = session.selectOne("member.checkMember", memId);
			
			if(cnt > 0) {
				isExist = true;
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return isExist;
	}

	@Override
	public int insertMember(MemberVO memberVO) {

		SqlSession session = MyBatisUtil.getInstance();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("member.insertMember", memberVO);
			if(cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}

		return cnt;
	}

	@Override
	public MemberVO getMember(String memId) {
		
		SqlSession session = MyBatisUtil.getInstance(true);
		MemberVO memberVO = null;
		
		try {
			memberVO = session.selectOne("member.getMember", memId);
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return memberVO;
	}

}
