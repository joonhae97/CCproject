package com.service;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ApplyDAO;
import db.ApplyDTO;

public class BoardMatchCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		ApplyDAO dao = new ApplyDAO();
		ApplyDTO applydata = dao.application(userid);// 마지막 신청자 신청정보
		Stack<ApplyDTO> matchinglist = new Stack<ApplyDTO>();// 마지막 신청자 조건에 부합
		ArrayList<ApplyDTO> list = dao.userlist();// 사용자정보리스트

		// 신청할 때 여러 항목을 선택할 수 있도록 했으므로 tokenizer를 이용해서 나눔.
		/*
		 * ArrayList<String> college = tokenizer(applydata.getCollege());
		 * ArrayList<String> hometown = new ArrayList<String>(); ArrayList<String> age =
		 * new ArrayList<String>(); ArrayList<String> height = new ArrayList<String>();
		 * ArrayList<String> interesting = new ArrayList<String>(); ArrayList<String>
		 * character = new ArrayList<String>();
		 */
		ArrayList<String> college = tokenizer(applydata.getCollege());
		ArrayList<String> hometown = tokenizer(applydata.getHometown());
		ArrayList<String> age = tokenizer(applydata.getAge());
		ArrayList<String> height = tokenizer(applydata.getHeight());
		ArrayList<String> interesting = tokenizer(applydata.getInteresting());
		ArrayList<String> character = tokenizer(applydata.getCharacter());
		// dao.list()할 떄 늦게 넣은 순으로 나오게함. 따라서 인덱스 0인부분에 신청자이고 그 신청자의 원하는 상대가 있는지 검사.
		System.out.println("start");
		/*
		 * StringTokenizer tok = new StringTokenizer(applydata.getCollege(), " "); while
		 * (tok.hasMoreTokens()) { String data = tok.nextToken(); college.add(data);
		 * System.out.println(data); }
		 * 
		 * tok = new StringTokenizer(applydata.getHometown(), " "); while
		 * (tok.hasMoreTokens()) { String data = tok.nextToken(); hometown.add(data);
		 * System.out.println(data); } tok = new StringTokenizer(applydata.getAge(),
		 * " "); while (tok.hasMoreTokens()) { String data = tok.nextToken();
		 * age.add(data); System.out.println(data); } tok = new
		 * StringTokenizer(applydata.getHeight(), " "); while (tok.hasMoreTokens()) {
		 * String data = tok.nextToken(); height.add(data); System.out.println(data); }
		 * tok = new StringTokenizer(applydata.getInteresting(), " "); while
		 * (tok.hasMoreTokens()) { String data = tok.nextToken(); interesting.add(data);
		 * System.out.println(data); } tok = new
		 * StringTokenizer(applydata.getCharacter(), " "); while (tok.hasMoreTokens()) {
		 * String data = tok.nextToken(); character.add(data); System.out.println(data);
		 * }
		 */

		// user정보들
		for (ApplyDTO data : list) {
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
				for (String check : height) {
					if (check.equals(data.getHeight())) {
						count++;
						break;
					}
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
				System.out.println("count : " + count);
				if (count >= 4) {
					ApplyDTO dto = new ApplyDTO();
					dto = dao.application(data.getUserid());
					matchinglist.push(dto);
				}
			}
		}
		/*
		 * for (ApplyDTO data : list.subList(1, list.size())) { int count = 0; //성별이 다를
		 * 경우만. if (!(data.getGender().equals(list.get(0).getGender()))) {
		 * System.out.println("hawi");
		 * System.out.println(data.getGender()+data.getUserid());
		 * System.out.println(list.get(0).getGender()); for (String check : college) {
		 * System.out.println("check : "+ check);
		 * System.out.println("college : "+data.getCollege()); if
		 * (check.equals(data.getCollege())) { count++; break; }} for (String check :
		 * hometown) { if (check.equals(data.getHometown())) { count++; break; }} for
		 * (String check : age) { if (check.equals(data.getAge())) { count++; break; }}
		 * for (String check : height) { if (check.equals(data.getHeight())) { count++;
		 * break; }} for (String check : interesting) { if
		 * (check.equals(data.getInteresting())) { count++; break; }} for (String check
		 * : character) { if (check.equals(data.getCharacter())) { count++; break; }} //
		 * 가장 먼저 신청한 사용자가 list의 끝에 있으므로 stack에 담아서 조건이 부합할 경우 // 가장 먼저 신청한 사용자가 먼저 최종 매칭
		 * 검사하게 함. System.out.println("count : "+count); if (count >= 4)
		 * matchinglist.add(data); } }
		 */

		// 마지막 신청자의 조건에 부합한 상대가있고
		// 그 상대의 조건에 마지막 신청자가 부합하는지 검사
		// 가장 먼저 신청한 상대가 먼저 검사하고 매칭
		ApplyDTO dto = new ApplyDTO();
		dto = dao.user(userid);
		String matchinginfo = "매칭되지 않았습니다.매칭되면 연결해드리겠습니다.";
		while (!matchinglist.empty()) {
			System.out.println("stack");
			ApplyDTO data = matchinglist.pop();

			college = tokenizer(data.getCollege());
			hometown = tokenizer(data.getHometown());
			age = tokenizer(data.getAge());
			height = tokenizer(data.getHeight());
			interesting = tokenizer(data.getInteresting());
			character = tokenizer(data.getCharacter());

			int count = 0;
			
			if (!(data.getGender().equals(dto.getGender()))) {
				for (String check : college) {
					if (check.equals(dto.getCollege())) {
						count++;
						break;
					}
				}
				for (String check : hometown) {
					if (check.equals(dto.getHometown())) {
						count++;
						break;
					}
				}
				for (String check : age) {
					if (check.equals(dto.getAge())) {
						count++;
						break;
					}
				}
				for (String check : height) {
					if (check.equals(dto.getHeight())) {
						count++;
						break;
					}
				}
				for (String check : interesting) {
					if (check.equals(dto.getInteresting())) {
						count++;
						break;
					}
				}
				for (String check : character) {
					if (check.equals(dto.getCharacter())) {
						count++;
						break;
					}
				}
				// 매칭될 경우
				System.out.println("최종 : " + count);
				if (count >= 4) {
					System.out.println(dto.getUserid());
					System.out.println(data.getUserid());
					String user1=dto.getUserid();
					String user2=data.getUserid();
					matchinginfo = user1 + "님과 " + user2 + "님이 매칭되셨습니다.";
					System.out.println("ㅁㄴ어라ㅣ머닝란"+matchinginfo);
					// 매칭된 두 사람의 신청정보 삭제
					dao.deleteApplication(dto.getUserid());
					dao.deleteApplication(data.getUserid());
					break;
				}
			}
			System.out.println(matchinginfo);
			System.out.println("end");
			request.setAttribute("matchinginfo", matchinginfo);
		}
	}
	//토큰으로 나눠서 ArrayList에 넣어서 반환해줌
	public ArrayList<String> tokenizer(String target) {
		ArrayList<String> result = new ArrayList<String>();
		StringTokenizer tok = new StringTokenizer(target, " ");
		while (tok.hasMoreTokens()) {
			String data = tok.nextToken();
			result.add(data);
			System.out.println(data);
		}
		return result;
	}
}