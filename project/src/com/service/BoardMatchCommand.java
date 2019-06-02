package com.service;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ApplyDAO;
import db.ApplyDTO;
import db.UserDAO;
import db.UserDTO;

public class BoardMatchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		ApplyDAO Adao = new ApplyDAO();
		ApplyDTO applydata = Adao.application(userid);// 마지막 신청자 신청정보
		Stack<ApplyDTO> matchinglist = new Stack<ApplyDTO>();// 마지막 신청자 조건에 부합
		UserDAO Udao = new UserDAO();
		ArrayList<UserDTO> list = Udao.userlist();// 사용자정보리스트

		// 신청할 때 여러 항목을 선택할 수 있도록 했으므로 tokenizer를 이용해서 나눔.
		ArrayList<String> college = tokenizer(applydata.getCollege());// 사용자 정의 함수 tokenizer ' '로 토큰 분리한 것
		ArrayList<String> hometown = tokenizer(applydata.getHometown());
		ArrayList<String> age = tokenizer(applydata.getAge());
		int minheight = Integer.parseInt(applydata.getMinheight());
		int maxheight = Integer.parseInt(applydata.getMaxheight());
		ArrayList<String> interesting = tokenizer(applydata.getInteresting());
		ArrayList<String> character = tokenizer(applydata.getCharacter());

		// user정보들
		for (UserDTO data : list) {
			int count = 0;

			// 성별이 다를 경우만.
			if (!(data.getGender().equals(applydata.getGender()))) {
				for (String check : college) {
					if (check.equals(data.getCollege())) {
						count++;
						break;
					}
				}
				for (String check : hometown) {
					if (check.equals(data.getHometown())) {
						count++;
						break;
					}
				}
				for (String check : age) {
					if (check.equals(data.getAge())) {
						count++;
						break;
					}
				}
				if (Integer.parseInt(data.getHeight()) >= minheight
						&& Integer.parseInt(data.getHeight()) <= maxheight) {
					count++;
				}
				for (String check : interesting) {
					if (check.equals(data.getInteresting())) {
						count++;
						break;
					}
				}
				for (String check : character) {
					if (check.equals(data.getCharacter())) {
						count++;
						break;
					}
				}
				// 가장 먼저 신청한 사용자가 list의 끝에 있으므로 stack에 담아서 조건이 부합할 경우
				// 가장 먼저 신청한 사용자가 먼저 최종 매칭 검사하게 함.
				// 부합사용자들의 신청정보넣음.
				if (count >= 4) {
					ApplyDTO dto = new ApplyDTO();
					dto = Adao.application(data.getUserid());

					// 가장 먼저 신청한 사용자가 list의 끝에 있으므로 stack에 담아서 조건이 부합할 경우
					// 가장 먼저 신청한 사용자가 먼저 최종 매칭 검사하게 함.
					matchinglist.push(dto);
				}
			}
		}

		// 마지막 신청자의 조건에 부합한 상대가있고
		// 그 상대의 조건에 마지막 신청자가 부합하는지 검사
		// 가장 먼저 신청한 상대가 먼저 검사하고 매칭
		UserDTO Udto = new UserDTO();
		Udto = Udao.user(userid);
		String matchinginfo = "매칭되지 않았습니다.매칭되면 연결해드리겠습니다.";
		while (!matchinglist.empty()) {// 스택 빌때까지
			ApplyDTO data = matchinglist.pop();

			college = tokenizer(data.getCollege());
			hometown = tokenizer(data.getHometown());
			age = tokenizer(data.getAge());

			interesting = tokenizer(data.getInteresting());
			character = tokenizer(data.getCharacter());

			int count = 0;

			if (!(data.getGender().equals(Udto.getGender()))) {
				for (String check : college) {
					if (check.equals(Udto.getCollege())) {
						count++;
						break;
					}
				}
				for (String check : hometown) {
					if (check.equals(Udto.getHometown())) {
						count++;
						break;
					}
				}
				for (String check : age) {
					if (check.equals(Udto.getAge())) {
						count++;
						break;
					}
				}

				if (Integer.parseInt(Udto.getHeight()) >= Integer.parseInt(data.getMinheight())
						&& Integer.parseInt(Udto.getHeight()) <= Integer.parseInt(data.getMaxheight())) {
					count++;
				}
				for (String check : interesting) {
					if (check.equals(Udto.getInteresting())) {
						count++;
						break;
					}
				}
				for (String check : character) {
					if (check.equals(Udto.getCharacter())) {
						count++;
						break;
					}
				}

				// 매칭될 경우
				if (count >= 4) {
					matchinginfo = Udto.getUserid() + "님과 " + data.getUserid() + "님이 매칭되셨습니다.";

					// 매칭된 두 사람의 신청정보 삭제
					Adao.deleteApplication(Udto.getUserid());
					Adao.deleteApplication(data.getUserid());
					request.setAttribute("matchinginfo", matchinginfo);
					request.setAttribute("check", "true");
					return;
				}
			}
			request.setAttribute("matchinginfo", matchinginfo);
		}
	}

	// 토큰으로 나눠서 ArrayList에 넣어서 반환해줌
	public ArrayList<String> tokenizer(String target) {
		ArrayList<String> result = new ArrayList<String>();
		StringTokenizer tok = new StringTokenizer(target, " ");
		while (tok.hasMoreTokens()) {
			String data = tok.nextToken();
			result.add(data);
		}
		return result;
	}
}