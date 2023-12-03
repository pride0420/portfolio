package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.gameMapper;

import com.example.demo.vo.gameanswer;
import com.example.demo.vo.gameplayer;

import jakarta.servlet.http.HttpSession;

@Controller
public class gameController {

	@Autowired()
	public gameMapper gamemapper;
	//前往遊戲開始頁
	@GetMapping("goGame")
	public String gotoGame() {
		return "game/gameindex";
	}
	//前往猜答案頁
	@GetMapping("gotoplay")
	public String gotoPlat() {
		return "game/playAB";
	}

	@Autowired()
	public HttpSession session;

	
	// ANSWER
	//新增答案
	@GetMapping("addanswer")
	public String addanswer() {
		int[] number = new int[9];
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}

		String n = show(number);
		
		gameanswer ans = new gameanswer(n);
		gamemapper.addGame(ans);
		List<Integer> ANS = gamemapper.queryanswerList(gamemapper.queryId());
		session.setAttribute("ANS", ANS);
		//刪除前面玩家猜的內容 防止遊戲中跳出在進來會造成錯亂
		gameplayer gp = gamemapper.queryplayer(gamemapper.queryplayerId());
		if (gp != null) {
			gamemapper.deletePlayer(gp.getId());
		}
		return "game/playAB";
	}

	// player
	//接收輸入的內容
	@GetMapping("addplayer")
	public String addPlayer(String playernub) {

		gameplayer gp = new gameplayer(playernub);
		gamemapper.addPlayer(gp);

		String ans = gamemapper.queryanswer(gamemapper.queryId()).getAnswernub();
		String play = gamemapper.queryplayer(gamemapper.queryplayerId()).getPlayernub();
		//將答案與玩家內容轉char陣列比對
		char[] asw = card(ans);
		char[] ply = card(play);
		int A = 0;
		int B = 0;

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 4; i++) {
				if (asw[i] == ply[i] && i == j) {
					A++;
				} else if (asw[i] == ply[j] && i != j) {
					B++;
				}
			}
		}
		gameplayer gpt = gamemapper.queryplayer(gamemapper.queryplayerId() - 1);
		//如果A!=4 或20次內的話 繼續遊戲 否則失敗退出
		if (A != 4) {

			gameplayer gpl = gamemapper.queryplayer(gamemapper.queryplayerId());

			gpl.setA(A);
			gpl.setB(B);
			if (gpt == null) {
				//如果是第一次猜的話 次數更新為1
				gpl.setReno(1);
				//未達20次或非第一次 次數則往上加  達20次則失敗
			} else if (20 - (gpt.getReno() + 1) == 0 && gpt != null) {
				gamemapper.deletePlayer(gamemapper.queryplayerId());
				return "game/gamelose";
			} else {
				gpl.setReno(gpt.getReno() + 1);
			}

			gpl.getId();
			gamemapper.update(gpl);
			session.setAttribute("PLAY", gpl);
			List<gameplayer> playall = gamemapper.query();
			session.setAttribute("PLAYALL", playall);
			
			String ul = "gameplay";
			session.setAttribute("UL", ul);
			return "porder/addChatSuccess";
			//猜對切換到成功頁
		} else {
			gamemapper.deletePlayer(gamemapper.queryplayerId());
			return "game/gameover";
		}
	}

	// 篩選隨機數 洗牌
	public static String show(int[] number) {
		Random r = new Random();
		for (int i = number.length - 1; i > 0; i--) {
			int s = r.nextInt(i + 1);
			int temp = number[i];
			number[i] = number[s];
			number[s] = temp;
		}
		String n = "";
		for (int i = 0; i < 4; i++) {
			n = n + number[i];
		}
		return n;
	}
	//答案比對
	public char[] card(String x) {
		char[] c = new char[4];
		for (int i = 0; i < 4; i++) {
			c[i] = x.charAt(i);
		}
		return c;
	}

}
