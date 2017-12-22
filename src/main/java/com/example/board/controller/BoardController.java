package com.example.board.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.domain.BoardVo;
import com.example.board.service.BoardService;

@Controller
public class BoardController {

	@Resource(name="com.example.board.service.BoardService")
	BoardService boardService;
	
	@RequestMapping("/list") // 게시판 리스트 화면
	public String boardList(HttpServletRequest request, String search, String search_text, Model model) throws Exception{
		BoardVo vo = new BoardVo();
		
		if(search!=null && !search.equals("all")) {
			if(search.equals("subject")) {
				vo.setSubject(request.getParameter("search_text"));
			}else if(search.equals("name")) {
				vo.setName(request.getParameter("search_text"));
			}
		}
		List<BoardVo> list = boardService.boardListService(vo);
		
		model.addAttribute("list", list);
		
		return "list";
		
	}
	
	@RequestMapping("/view/{idx}")
	private String boardView(@PathVariable int idx, Model model) throws Exception{
		model.addAttribute("vo", boardService.boardViewService(idx));
		
		boardService.hitPlusService(idx);
		
		return "view";
	}
	
	@RequestMapping("/insert")
	private String boardInsertForm() {
		return "insert";
	}
	
	@RequestMapping("/insertProc")
	private String boardInsertProc(HttpServletRequest request) throws Exception{
		BoardVo vo = new BoardVo();
		
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setName(request.getParameter("name"));
		vo.setPwd(request.getParameter("pwd"));
		
		boardService.boardInsertService(vo);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/update/{idx}")
	private String boardUpdateForm(@PathVariable int idx, Model model) throws Exception{
		model.addAttribute("vo", boardService.boardViewService(idx));
		
		return "update";
	}
	
	@RequestMapping("/updateProc")
	private String boardUpdateProc(HttpServletRequest request) throws Exception{
		BoardVo vo = new BoardVo();
		
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		
		boardService.boardUpdateService(vo);
		
		return "redirect:/detail/" + request.getParameter("idx");
	}
	
	@RequestMapping("/delete/{idx}")
	private String boardDelete(@PathVariable int idx) throws Exception {

		boardService.boardDeleteService(idx);
		
		return "redirect:/list";
	}
}
