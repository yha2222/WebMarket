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

@WebServlet("/member/idcheck.do")
public class MemIdCheck extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memberService = MemberServiceImpl.getInstance();
		String memId = req.getParameter("memId");
		
		System.out.println("memId = " + memId);
		
		boolean isExist = memberService.checkMember(memId);
		
		if(isExist) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("isExist", "ok");
			String jsonStr = new Gson().toJson(jsonObject);
			resp.setContentType("application/json");
			resp.getWriter().write(jsonStr);
		} else {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("isExist", "fail");
			String jsonStr = new Gson().toJson(jsonObject);
			resp.setContentType("application/json");
			resp.getWriter().write(jsonStr);
		}
		

	}
}
