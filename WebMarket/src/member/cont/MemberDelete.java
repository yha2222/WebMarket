package member.cont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member.service.IMemberService;
import member.service.MemberServiceImpl;

@WebServlet("/member/delete.do")
public class MemberDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memberService = MemberServiceImpl.getInstance();
		String memId = req.getParameter("memId");
		
		int cnt = memberService.deleteMember(memId);
		
		if(cnt > 0) {
			req.getSession().setAttribute("dlisSuccess", "ok");
		} else {
			req.getSession().setAttribute("dlisSuccess", "fail");
		}
		
		resp.sendRedirect("./list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
