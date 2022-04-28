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


@WebServlet(urlPatterns = {"/board/list","/board/write", "/board/insert"})  
//각 페이지 별로 주소로 지정해줘야되는 경로를 지정
// 패턴이 일치하는 것만 처리해주는것
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public void init() throws ServletException {
		sqlSessionFactory=
				(SqlSessionFactory) getServletContext().getAttribute("sqlSessionFactory");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board 로 요청시 실행");
		//
		
			String uri=request.getRequestURI();
			String[] strs=uri.split("/");
			// split() 메소드가 적용되서 
			//"/"기준으로 문자열을 나누어준다 
			
		String key=strs[strs.length-1];
		// 나눠진 / 이후의 뜻 문자열만을 key 변수에 저장해준다. 

		System.out.println(key); 
		String path=null;

		
		
		// 이동할 페이지의 마지막 문자열이 어떤 것이냐에 따라서 
		// key에는 다른 문자열이 들어올것이고 그에 따라서 
		// equals()로 비교해줘서 해당 문자열에 해당되면 조건문이 실행되게 해서
		// 해당 페이지에 따른 기능을 실행해준다.
		if(key.equals("list")) {  
			SqlSession sqlSession=sqlSessionFactory.openSession();
			// SQL을 실행하려면 SqlSession 객체를 만들어준다.
			
			
			//board-mapper.xml에 있는 select문을 실행해준다.
			//sql select를 실행해 db에 있는 테이블 값을 검색해서 출력해주는 
			List<BoardDTO> result=sqlSession.selectList("boardMapper.all");
			//list 컬렉션을 통해서 테이블에 있는 복수의 튜블을 가변적으로 저장하는 공간을 만들어준다.
			//여기서 SqlSession참조변수.selectList를 해서 list에 해당 쿼리가 저장되는 
			sqlSession.close();
			
			request.setAttribute("list", result);
			


			path="/WEB-INF/board/list.jsp"; ///페이지이동
			
		}else if(key.equals("write")) {
			//write 페이지 이동
			path="/WEB-INF/board/write.jsp";
			
		}else if(key.equals("insert")) {
			request.setCharacterEncoding("utf-8");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			BoardInsertDTO dto = new BoardInsertDTO(subject, content, writer);
			SqlSession sqlSession =sqlSessionFactory.openSession(true);  // DB와 연동해서 쿼리를 실행  // (true)는 커밋을 의미함
			
			// 웹에서 받은 값을 쿼리 실행해서 DB에 넣어주는 
			
			int n = sqlSession.insert("boardMapper.save", dto); 
			sqlSession.close();
			System.out.println(n+"개 저장완료");
			
			//list 페이지 이동 : 응답처리 
			response.sendRedirect("list");
		}
		
		//페이지 이동 : 응답처리 
		if(path!=null) {
			request.getRequestDispatcher(path)
				.forward(request, response);
		}
		
	
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
