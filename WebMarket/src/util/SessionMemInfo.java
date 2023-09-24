package util;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class SessionMemInfo {
	private static SessionMemInfo instance = null;
	
	private SessionMemInfo() {}
	
	public static SessionMemInfo getInstance() {
		if(instance == null) instance = new SessionMemInfo();
		return instance;
	}
	
	public MemberVO getMemVO(String memberId) {
		MemberVO memVO = null;
		SqlSession session = MyBatisUtil.getInstance();
		
		try {
			
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return memVO;
	}
}
