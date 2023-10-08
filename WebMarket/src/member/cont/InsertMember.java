package member.cont;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@MultipartConfig
@WebServlet("/member/insert.do")
public class InsertMember extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		String memPhoto = writeImage(req.getParts());
		
		MemberVO memberVO = new MemberVO(memId, memPass, memName, memTel, memAddr, memPhoto);
		
		int cnt = memberService.insertMember(memberVO);
		
		if(cnt > 0) {
			req.getSession().setAttribute("isSuccess", "ok");
		} else {
			req.getSession().setAttribute("isSuccess", "fail");
		}
		
		resp.sendRedirect("./list.do");
	}

	public String writeImage(Collection<Part> parts) {

		String dir = getServletContext().getRealPath("./images");
		System.out.println(dir);
		String fileName = null;

		File uploadDir = new File(dir);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isFirstFile = true;

		for (Part part : parts) {
			fileName = part.getSubmittedFileName();

			// 만약 첫번째 파일이 아닐때
			if (fileName != null && !fileName.equals("")) {
				if (isFirstFile) {
					isFirstFile = false;
				}
				String saveFilePath = uploadDir + File.separator + fileName;

				try {
					part.write(saveFilePath);
					part.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return fileName;
	}
}
