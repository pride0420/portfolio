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

	@GetMapping("goGame")
	public String gotoGame() {
		return "game/gameindex";
	}

	@GetMapping("gotoplay")
	public String gotoPlat() {
		return "game/playAB";
	}

	@Autowired()
	public HttpSession session;

	// ANSWER
	@GetMapping("addanswer")
	public String addanswer() {
		int[] number = new int[9];
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}

		String n = show(number);
		;
		gameanswer ans = new gameanswer(n);
		gamemapper.addGame(ans);
		List<Integer> ANS = gamemapper.queryanswerList(gamemapper.queryId());
		session.setAttribute("ANS", ANS);
		gameplayer gp = gamemapper.queryplayer(gamemapper.queryplayerId());
		if (gp != null) {
			gamemapper.deletePlayer(gp.getId());
		}
		return "game/playAB";
	}

	// player
	@GetMapping("addplayer")
	public String addPlayer(String playernub) {

		gameplayer gp = new gameplayer(playernub);
		gamemapper.addPlayer(gp);

		String ans = gamemapper.queryanswer(gamemapper.queryId()).getAnswernub();
		String play = gamemapper.queryplayer(gamemapper.queryplayerId()).getPlayernub();
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

		if (A != 4) {

			gameplayer gpl = gamemapper.queryplayer(gamemapper.queryplayerId());

			gpl.setA(A);
			gpl.setB(B);
			if (gpt == null) {
				gpl.setReno(1);
			} else if (20 - (gpt.getReno() + 1) == 0 && gpt != null) {
				gamemapper.deletePlayer(gamemapper.queryplayerId());
				return "game/gamelose";
			} else {
				gpl.setReno(gpt.getReno() + 1);
			}

			gpl.getId();
			System.out.println(gpl.getReno());
			gamemapper.update(gpl);
			session.setAttribute("PLAY", gpl);
			List<gameplayer> playall = gamemapper.query();
			session.setAttribute("PLAYALL", playall);
			String ul = "gameplay";
			session.setAttribute("UL", ul);
			return "porder/addChatSuccess";
		} else {
			gamemapper.deletePlayer(gamemapper.queryplayerId());
			return "game/gameover";
		}
	}

	// 篩選隨機數
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

	public char[] card(String x) {
		char[] c = new char[4];
		for (int i = 0; i < 4; i++) {
			c[i] = x.charAt(i);
		}
		return c;
	}

}
