package nowon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import nowon.domain.dto.BoardDTO;
import nowon.domain.dto.BoardInsertDTO;
import nowon.domain.dto.MemberDTO;
import nowon.domain.dto.MemberLogDTO;


@WebServlet(urlPatterns = {"/member/join","/member/insert", "/member/login"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SqlSessionFactory sqlSessionFactory;
   
    
	
	@Override
	public void init() throws ServletException {
		sqlSessionFactory=
				(SqlSessionFactory)getServletContext().getAttribute("sqlSessionFactory");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
		}else if(key.equals("insert-2")) {
			request.setCharacterEncoding("utf-8");
			String _email = request.getParameter("email");
			String _pass = request.getParameter("pass");
			MemberLogDTO _dto = new MemberLogDTO(_email, _pass);
			MemberDTO dto = new MemberDTO();
			SqlSession sqlSession =sqlSessionFactory.openSession(true);
			List<MemberDTO> result=sqlSession.selectList("boardMapper.log");
		
			
			
			sqlSession.close();
			
			if(result!=null) {
				System.out.println("n");
			}
			
			
			path="/webapp/index.jsp";
			
			//list 페이지 이동 : 응답처리 
			//response.sendRedirect("list");
		}else if(key.equals("login")) {
			
			path="/WEB-INF/member/login.jsp";
			
			/*
			 * SqlSession sqlSession=sqlSessionFactory.openSession(); //MemberDTO result =
			 * sqlSession.selectOne("memberMapper.log", result);
			 * 
			 * //request.setAttribute("detail", result); //System.out.println(result);
			 * request.setCharacterEncoding("utf-8"); String email =
			 * request.getParameter("email"); String pass = request.getParameter("pass");
			 * MemberDTO dto = new MemberDTO(); MemberLogDTO dto2 = new MemberLogDTO(email,
			 * pass); sqlSession.close();
			 */
			
		
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
