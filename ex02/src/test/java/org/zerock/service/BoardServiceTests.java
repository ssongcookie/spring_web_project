package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setContent("새로 작성하는 내용");
		board.setTitle("새로 작성하는 글");
		board.setWriter("newbie");
		
		service.register(board);
		log.info("생성된 게시물의 번호 : "+board.getBno());
	}

	@Test
	public void testGet() {
		log.info(service.get(1));
	}

	@Test
	public void testUpdate() {
		BoardVO board = service.get(1);
		
		if (board == null) {
			return;
		}
		
		board.setTitle("수정된 제목");
		log.info("수정 결과 : "+service.modify(board));
	}
	
	@Test
	public void testDelete() {
		
		log.info("삭제 결과 : "+service.remove(1));
	}
	
	@Test
	public void testGetList() {
		//service.getList().forEach(board->log.info(board));
		service.getList(new Criteria(2,10)).forEach(board -> log.info(board));
	}
	
	
	
}
