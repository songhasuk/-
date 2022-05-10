package nowon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import nowon.domain.dto.BoardDTO;
import nowon.domain.dto.BoardInsertDTO;
import nowon.domain.dto.MemberDTO;
import nowon.domain.dto.MemberLogDTO;


@WebServlet(urlPatterns = {"/member/join","/member/insert", "/member/select", "/member/login", "/member/logout", "/member/delete"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Object MemberLogDTO = null;
    private SqlSessionFactory sqlSessionFactory;
   
    
	
	@Override
	public void init() throws ServletException {
		sqlSessionFactory=
				(SqlSessionFactory)getServletContext().getAttribute("sqlSessionFactory");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		StringBuffer url = request.getRequestURL();
		System.out.println(url);
		String uri = request.getRequestURI();
		System.out.println(uri);
		String[] strs = uri.split("/");
		String key = strs[strs.length-1]; //주소값 마지막을 구분해주기 위한 -1
		
		String path = null; // 보여줄 페이지(jsp)정보를 저장해주는 
		if(key.equals("join")) {
			path = "/WEB-INF/member/join.jsp";
		
		}else if(key.equals("insert")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			MemberDTO dto = new MemberDTO(email, name, pass);
			SqlSession sqlSession =sqlSessionFactory.openSession(true);
			
			int n = sqlSession.insert("memberMapper.save", dto);
			sqlSession.close();
			System.out.println(n+"번째 회원가입");
			
			String msg = name+"님! 회원가입 축하합니다.<br>"
						+"로그인 후 이용 가능합니다";
			request.setAttribute("msg", msg);
			path="/WEB-INF/member/login.jsp";
			
			
			
			
			//list 페이지 이동 : 응답처리 
			//response.sendRedirect("list");
		}else if(key.equals("select")) {
			request.setCharacterEncoding("utf-8");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			MemberLogDTO _dto = new MemberLogDTO(email, pass);
			MemberDTO dto = new MemberDTO();
			SqlSession sqlSession =sqlSessionFactory.openSession(true);
			int result=sqlSession.selectOne("memberMapper.log", _dto );
			
			sqlSession.close();
			
			String msg;
			
			
			
			if(result != 0) {
			msg = "【"+_dto.getEmail()+"님이 로그인 하셨습니다.】<br>";
			session.setAttribute("msg", msg);
			response.sendRedirect("/DBConn");
			}else {
				msg = "회원가입부터 하세요<br>";
				request.setAttribute("msg", msg);
				path="/WEB-INF/member/login.jsp";
			}
			System.out.println(dto.getName());
			
			
			
			//list 페이지 이동 : 응답처리 
			//response.sendRedirect("list");
		}else if(key.equals("login")) {
			
			path="/WEB-INF/member/login.jsp";
			
		
		}else if(key.equals("logout")){
			session.invalidate();
			response.sendRedirect("/DBConn");
		}
		
		
		
		
		
		
		if(path!=null) { // 실제 페이지 이동을 실행하는 코드
			request.getRequestDispatcher(path)
				.forward(request, response);
		}
}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
