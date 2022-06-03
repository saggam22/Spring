package co.micol.lgy.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.lgy.board.vo.BoardVO;

public interface BoardMapper {
	
	//게시글 전체 리스트
	List<BoardVO> boardList(@Param("state") int state, @Param("key") String key);
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
