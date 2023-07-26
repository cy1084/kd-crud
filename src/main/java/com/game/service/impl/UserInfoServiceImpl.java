package com.game.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.game.dao.UserInfoDAO;
import com.game.dao.impl.UserInfoDAOImpl;
import com.game.service.UserInfoService;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uiDAO = new UserInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectUserInfoList(Map<String, String> userInfo) {

		return uiDAO.selectUserInfoList(userInfo);
	}

	@Override
	public Map<String, String> selectUserInfo(String uiNum) {

		return uiDAO.selectUserInfo(uiNum);
	}

	@Override
	public int insertUserInfo(Map<String, String> userInfo) {

		return uiDAO.insertUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(Map<String, String> userInfo) {

		return uiDAO.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfo(String uiNum) {

		return uiDAO.deleteUserInfo(uiNum);
	}

	@Override
	public boolean login(Map<String, String> userInfo, HttpSession session) {
		String uiId=userInfo.get("uiId");
		Map<String,String> tmp=uiDAO.selectUserInfoById(uiId); //디비 조회
		
		if(tmp != null) {	//있는 아이디로 조회
			String uiPwd=tmp.get("uiPwd"); //디비에 저장된 비밀번호를 뽑아와 비교
			if(uiPwd.equals(userInfo.get("uiPwd"))){//사용자가 입력한 비밀번호와 디비에 있는 비밀번호가 같으면 로그인 성공!
				session.setAttribute("user",tmp);
				return true;
			}
		}
		return false;
	}

}
