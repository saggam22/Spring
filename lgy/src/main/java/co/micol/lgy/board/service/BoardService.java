package co.micol.lgy.board.service;

import java.util.List;

import co.micol.lgy.board.vo.BoardVO;

public interface BoardService {

	//게시글 전체 리스트
	List<BoardVO> boardList(int state, String key);
	//게시글 한건 조회
	BoardVO boardSelect(BoardVO vo);
	//게시글 등록
	int boardInsert(BoardVO vo);
	//게시글 수정
	int boardUpdate(BoardVO vo);
	//게시글 삭제
	int boardDelete(BoardVO vo);
	//게시글 조회수
	int boardHitUpdate(int boardId);
	
}
