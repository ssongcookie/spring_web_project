package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor//필요한 파라미터 자동 주입
public class BoardServiceImpl implements BoardService{ //BoardService 인터페이스를 구현하는 구현체
	
	
	//@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	public void register(BoardVO board) {
		
		mapper.insertSelectKey(board);
		log.info("register : " +board);
	}
	
	public BoardVO get(long bno) {
		log.info("get : "+bno);
		
		return mapper.read(bno);	
	}
	
	public boolean modify(BoardVO board) {
		log.info("modify : "+board);		
		return mapper.update(board) == 1;
	}
	
	public boolean remove(long bno) {
		log.info("remove: "+bno);
		return mapper.delete(bno)==1;
	}
	
	/*public List<BoardVO> getList() {
		log.info("getList----------------");
		return mapper.getList();
		
	}*/

	public List<BoardVO> getList(Criteria cri) {
		log.info("get List with criteria : "+cri);
		return mapper.getListWithPaging(cri);
	}

	public int getTotalCount(Criteria cri) {
		log.info("get total count");
		
		
		return mapper.getTotalCount(cri);
	}
}
