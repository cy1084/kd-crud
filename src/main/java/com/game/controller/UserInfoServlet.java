package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;

@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		// String path="/WEB-INF/views";
		if ("list".equals(cmd)) {
			List<Map<String, String>> userInfoList = uiService.selectUserInfoList(null);
			request.setAttribute("userInfoList", userInfoList);
			// userInfoList는 30라인에서 죽는데, jsp를 forward 하기 위해선 34라인까지는 살아 있어야 함 
			// -> 그래서 request에 저장
			// path+="/user-info/list";
		} else if ("view".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
			// 키 값인 userInfo를 통해 view.jsp를 볼 수 있음
			// ${userInfo}
		} else if ("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("logout".equals(cmd)) {
			HttpSession session=request.getSession();
			session.invalidate();
			request.setAttribute("msg", "로그아웃 되었습니다.");
			request.setAttribute("url","/user-info/login");
			CommonView.forwardMessage(request, response); //포워딩 후 밑에서 포워딩을 또 하면 안되므로 return을 해서 
														  //한번 포워딩 한 후 두번째 포워딩은 막아버림
			return;
		}

		// path +=".jsp";
		// RequestDispatcher rd=request.getRequestDispatcher(path);
		// rd.forward(request, response);
		CommonView.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("uiId", request.getParameter("uiId"));
		userInfo.put("uiName", request.getParameter("uiName"));
		userInfo.put("uiPwd", request.getParameter("uiPwd"));
		userInfo.put("uiDesc", request.getParameter("uiDesc"));
		if(request.getParameter("uiBirth")!=null) {
			userInfo.put("uiBirth", request.getParameter("uiBirth").replace("-", ""));
		}

		if ("insert".equals(cmd)) {
			int result = uiService.insertUserInfo(userInfo);
			request.setAttribute("msg", "유저 등록 성공");
			request.setAttribute("url", "/user-info/login");
			if (result != 1) {
				request.setAttribute("msg", "유저 등록 실패");
				request.setAttribute("url", "/user-info/insert");
			}
		} else if ("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			userInfo.put("uiNum", uiNum);
			int result = uiService.updateUserInfo(userInfo);
			request.setAttribute("msg", "유저 수정 성공");
			request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
			if (result != 1) {
				request.setAttribute("msg", "유저 수정 실패");
				request.setAttribute("url", "/user-info/update?uiNum=" + uiNum);
			}
		} else if ("delete".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			int result = uiService.deleteUserInfo(uiNum);
			request.setAttribute("msg", "유저 삭제 성공");
			request.setAttribute("url", "/user-info/list");
			if (result != 1) {
				request.setAttribute("msg", "유저 삭제 실패");
				request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
			}
		} else if ("login".equals(cmd)) {
			request.setAttribute("msg", "아이디나 비밀번호를 확인하세요.");
			request.setAttribute("url", "/userInfo/login");
			HttpSession session = request.getSession();
			String uiId=request.getParameter("uiId");
			String uiPwd=request.getParameter("uiPwd");
			Map<String,String> ui=uiService.login(uiId); //uiId를 서비스로 보내어 selectUserInfoById 쿼리 실행
			if(ui != null) {
				String dbUiPwd=ui.get("uiPwd");
				if(uiPwd.equals(dbUiPwd)) {
					request.setAttribute("msg", "로그인 성공.");
					request.setAttribute("url", "/");
					//request는 화면 나오면 유지할 필요 없음
					
					session.setAttribute("user", ui); //user라는 키 값으로 ui 맵을 넣음
					//로그인 후엔 화면을 전환해도 계속 로그인 상태를 유지해야 하기 때문에 session으로!!
				}
			}

		}

		CommonView.forwardMessage(request, response);
	}
}
