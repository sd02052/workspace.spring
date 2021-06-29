package com.sist.model;

import java.util.List;

public interface BoardDAO {

	int getListCount();
	
	List<BoardDTO> getBoardList(int startNo, int endNo);

	int insertBoard(BoardDTO dto);

	BoardDTO getBoardCont(int board_no);

	void hitBoard(int board_no);

	int updateBoard(BoardDTO dto);

	int deleteBoard(int board_no);

	void updateBoardNo(int board_no);

	List<BoardDTO> searchBoardList(String field, String keyword);
}
