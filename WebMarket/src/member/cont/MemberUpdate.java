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

import member.service.IMemberService;
import member.service.MemberServiceImpl;
import vo.MemberVO;

@MultipartConfig
@WebServlet("/member/update.do")
public class MemberUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IMemberService memberService = MemberServiceImpl.getInstance();
		String memId = req.getParameter("memId");
		MemberVO memberVO = memberService.getMember(memId);
		
		req.setAttribute("memVO", memberVO);
		req.getRequestDispatcher("../views/memberUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		IMemberService memberService = MemberServiceImpl.getInstance();
		String fileName = writeImage(req.getParts());
		
		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		MemberVO memVO = new MemberVO(memId, memPass, memName, memTel, memAddr, fileName);
		
		int cnt = memberService.updateMember(memVO);
		
		if(cnt > 0) {
			req.getSession().setAttribute("udisSuccess", "ok");
		} else {
			req.getSession().setAttribute("udisSuccess", "fail");
		}
		
		MemberVO memberVO = memberService.getMember(memId);
		req.setAttribute("memberVO", memberVO);
		resp.sendRedirect("./list.do");
		//req.getRequestDispatcher("/views/memDetail.jsp").forward(req, resp);
	}
	
	
	public String writeImage(Collection<Part> parts) {
		
		String dir = getServletContext().getRealPath("/images");
		String fileName = null;
		
		File uploadDir = new File(dir);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		boolean isFirstFile = true;
		
		for (Part part : parts) {
			fileName = part.getSubmittedFileName();
			

			if (fileName != null && !fileName.equals("")) {
				if (isFirstFile) {
					isFirstFile = false;

				}

				String saveFilePath = "";
				saveFilePath = uploadDir + File.separator + fileName;

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
