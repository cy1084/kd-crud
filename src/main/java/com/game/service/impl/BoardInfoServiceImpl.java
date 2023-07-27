package com.game.service.impl;

import java.util.List;
import java.util.Map;

import com.game.dao.BoardInfoDAO;
import com.game.dao.impl.BoardInfoDAOImpl;
import com.game.service.BoardInfoService;

public class BoardInfoServiceImpl implements BoardInfoService {
	private BoardInfoDAO biDAO = new BoardInfoDAOImpl();

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {

		return biDAO.selectBoardInfoList(board);
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {

		return biDAO.selectBoardInfo(biNum);
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {

		return biDAO.insertBoardInfo(board);
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {

		return biDAO.updateBoardInfo(board);
	}

	@Override
	public int deleteBoardInfo(String biNum) {

		return biDAO.deleteBoardInfo(biNum);
	}

}
