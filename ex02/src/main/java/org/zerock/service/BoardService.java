package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {

	//명백하게 반환해야 할 데이터가 있는 'select'를 해야 하는 메서드는 리턴타입을 지정할 수 있음
	public void register(BoardVO board);
	
	//특정 게시물 가져오기 (처음부터 메서드의 리턴타입을 결정해서 진행할 수 있음)
	public BoardVO get(long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(long bno);
	
	//전체 리스트 구하기
	public List<BoardVO> getList();
}
