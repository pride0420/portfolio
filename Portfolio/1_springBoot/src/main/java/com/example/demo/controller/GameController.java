package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.GameMapper;

import com.example.demo.vo.GameAnswer;
import com.example.demo.vo.GamePlayer;

import jakarta.servlet.http.HttpSession;

@Controller
public class GameController {

	@Autowired()
	public GameMapper gamemapper;

	// 前往遊戲開始頁
	@GetMapping("goGame")
	public String gotoGame() {
		return "game/gameindex";
	}

	// 前往猜答案頁
	@GetMapping("gotoplay")
	public String gotoPlat() {
		return "game/playAB";
	}

	@Autowired()
	public HttpSession session;

	// ANSWER
	// 新增答案
	@GetMapping("addanswer")
	public String addAnswer() {
		int[] number = new int[9];
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}
		// 呼叫洗牌方法
		String n = show(number);

		GameAnswer ans = new GameAnswer(n);
		gamemapper.addGame(ans);
		List<Integer> ANS = gamemapper.queryAnswerList(gamemapper.queryAnswerId());
		session.setAttribute("ANS", ANS);
		// 刪除前面玩家猜的內容 防止遊戲中跳出在進來會造成錯亂
		GamePlayer gp = gamemapper.queryPlayer(gamemapper.queryPlayerId());
		if (gp != null) {
			gamemapper.deletePlayer(gp.getId());

		}
		session.removeAttribute("PLAYALL");
		return "game/playAB";
	}

	// player
	// 接收輸入的內容
	@GetMapping("addplayer")
	public String addPlayer(String playernub) {
		// 判斷是否符合規則
		boolean y = PB(playernub);
		if (!y) {
			return "game/gameError";
		} else {

			GamePlayer gp = new GamePlayer(playernub);
			gamemapper.addPlayer(gp);

			String ans = gamemapper.queryAnswer(gamemapper.queryAnswerId()).getAnswernub();
			String play = gamemapper.queryPlayer(gamemapper.queryPlayerId()).getPlayernub();
			// 將答案與玩家內容轉char陣列比對
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
			GamePlayer gpt = gamemapper.queryPlayer(gamemapper.queryPlayerId() - 1);
			// 如果A!=4 或20次內的話 繼續遊戲 否則失敗退出
			if (A != 4) {

				GamePlayer gpl = gamemapper.queryPlayer(gamemapper.queryPlayerId());

				gpl.setA(A);
				gpl.setB(B);
				if (gpt == null) {
					// 如果是第一次猜的話 次數更新為1
					gpl.setReno(1);
					// 未達20次或非第一次 次數則往上加 達20次則失敗
				} else if (20 - (gpt.getReno() + 1) == 0 && gpt != null) {
					gamemapper.deletePlayer(gamemapper.queryPlayerId());
					return "game/gamelose";
				} else {
					gpl.setReno(gpt.getReno() + 1);
				}

				// gpl.getId();
				// 更新AB的數量
				gamemapper.updatePlayer(gpl);

				session.setAttribute("PLAY", gpl);
				List<GamePlayer> playall = gamemapper.queryPlayerAll();
				session.setAttribute("PLAYALL", playall);

				String ul = "gameplay";
				session.setAttribute("UL", ul);
				return "porder/empty";

				// 猜對切換到成功頁
			} else {
				gamemapper.deletePlayer(gamemapper.queryPlayerId());
				return "game/gameover";
			}
		}
	}

	// 另外方法區
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

	// 轉陣列 用於答案比對
	public char[] card(String x) {

		char[] c = new char[4];
		for (int i = 0; i < 4; i++) {
			c[i] = x.charAt(i);
		}
		return c;
	}

	// 實現規則
	public boolean PB(String x) {
		boolean z = true;

		if (x.length() != 4) {
			z = false;
		} else {
			char[] play = card(x);
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (play[i] == play[j] && i != j || play[i] == '0') {
						z = false;
					}
				}
			}
		}
		return z;
	}

}
