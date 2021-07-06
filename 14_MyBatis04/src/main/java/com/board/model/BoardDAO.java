package com.board.model;

import java.util.List;

public interface BoardDAO {

	public int getListCount(); // 전체 게시물 수를 확인하는 메서드

	public List<BoardDTO> getBoardList(PageDTO dto); // 전체 리스트를 호출하는 추상 메서드

	public int insertBoard(BoardDTO dto);

	public void readCount(int no); // 조회수 증가

	public BoardDTO boardCont(int no); // 게시물 상세 내역

	public int updateBoard(BoardDTO dto);

	public int deleteBoard(int no);

	public void reSequence(int no);
	
	public int searchBoardCount(String field, String keyword); // 검색된 내용에 대한 게시물 수
	
	public List<BoardDTO> searchBoardList(PageDTO dto); // 게시물 검색 
}
