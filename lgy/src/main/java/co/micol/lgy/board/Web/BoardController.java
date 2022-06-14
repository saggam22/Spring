package co.micol.lgy.board.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.lgy.board.service.BoardService;
import co.micol.lgy.board.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardDao;
	
	@RequestMapping("/boardList.do")
	public String boadList(Model model) {
		model.addAttribute("boards", boardDao.boardList(1, "전체"));
		return "board/boardList";
	}
	
	@RequestMapping("/boardInsertForm.do")
	public String noticeInsertForm() {
		return "board/boardInsertForm";
	}
	
	@RequestMapping("/boardInsert.do")
	public String boardInsert(BoardVO vo) {
		boardDao.boardInsert(vo);
		return "redirect:boardList.do";
	}
	
	@RequestMapping("/boardSelect.do")
	public String boardSelect(BoardVO vo, Model model) {
		boardDao.boardHitUpdate(vo.getBoardId());
		model.addAttribute("content", boardDao.boardSelect(vo));
		return "board/boardContent";
	}
	
	@RequestMapping("/boardUpdateForm.do")
	public String boardUpdateForm(BoardVO vo, Model model) {
		model.addAttribute("board", boardDao.boardSelect(vo));
		return "board/boardUpdateForm";
	}
	
	@RequestMapping("/boardUpdate.do")
	public String boardUpdate(BoardVO vo) {
		boardDao.boardUpdate(vo);
		return "redirect:boardList.do";
	}
	
	@RequestMapping("/boardDelete.do")
	public String boardDelete(BoardVO vo) {
		boardDao.boardDelete(vo);
		return "redirect:boardList.do";
	}
	
	@ResponseBody
	@RequestMapping("/ajaxSearchList.do")
	public List<BoardVO> ajaxSearchList(@RequestParam("state") int state, @RequestParam("key") String key) {
		return boardDao.boardList(state, key);
	}
}
