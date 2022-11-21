package Project_2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PersonInfo{
	private int num;
	private String sex;
	private String name;
	private String contents;
	public PersonInfo(String name, String sex, String contents) {
		this.name = name;
		this.sex = sex;
		this.contents = contents;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void showInfo() {
		System.out.printf("%d.  %s\t%s\t%s", num, name, sex, contents);
	}
	@Override
	public String toString() {
		String result = String.format("%d.  %s\t%s\t%s", num, name, sex, contents);
		return result;
	}
}
public class EungAe {
	
	static final String rootPath = System.getProperty("user.dir");
	static final String NoticeBoard = rootPath + "contentsDB.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.println();
		System.out.println("        UU  UU                            AAAAA          ");
		System.out.println("EEEEE   UU  UU    NN    NN               AA   AA    EEEEE");
		System.out.println("EE      UU  UU    NNN   NN   GGGGGG      AAAAAAA    EE   ");
		System.out.println("EEEEE   UU  UU    NN N  NN   GG      ★  AA   AA    EEEEE");
		System.out.println("EE       UUUU     NN   NNN   GG GGG      AA   AA    EE   ");
		System.out.println("EEEEE             NN    NN   GG  GG                 EEEEE");
		System.out.println("                             GGGGGG                      ");
		
		System.out.println();
		System.out.println("           EEEEE                      GGGGGG                      ");
		System.out.println("           EE      UU  UU             GG                     EEEEE");
		System.out.println("           EEEEE   UU  UU   NN   NN   GG GGG   ★  AAAAA     EE   ");
		System.out.println("           EE      UU  UU   NNN  NN   GG  GG      AA   AA    EEEEE");
		System.out.println("           EEEEE   UU  UU   NN N NN   GGGGGG      AAAAAAA    EE   ");
		System.out.println("                    UUUU    NN  NNN               AA   AA    EEEEE");
		System.out.println("                            NN   NN               AA   AA         ");
    	System.out.println();
    	System.out.println("     < 메뉴 선택>");
    	System.out.println();
    	System.out.println("     1. 서비스 안내");
    	System.out.println("     2. 서비스 시작");
    	System.out.println("     3. 회원가입");
    	System.out.println("     4. 로그인");
    	System.out.println("     5. 로그아웃");
    	System.out.println("     6. ※게시판※");
    	System.out.println("     7. 지역 별 문의처 전화번호");
    	System.out.println("     8. 종료");
    	System.out.print("     >>>");
    	int select = sc.nextInt();
			
			switch(select) {
			case 1:
				ArrayList<String> N_list = new ArrayList<String>(); // 리스트 선언

				File note = new File("C:/Users/user/Desktop/textfile/guide.txt");
						try{
						        BufferedReader br = new BufferedReader(new FileReader(note));
						        String str = br.readLine();
				                while(str != null){
				                	N_list.add(str); //ArrayList에 저장
				                	str = br.readLine();
				                }

						        br.close();
						} catch (NullPointerException e){ // null이 있을 경우
							e.getStackTrace();
						} catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
							e.getStackTrace();
						} catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
							e.getStackTrace();
						}
				        
				        for(int i = 0; i < N_list.size(); i++){ // 저장된 Array의 크기만큼 루프
							System.out.println(N_list.get(i)); // 순서대로 출력
						}
				break;
			case 2:
					System.out.println("    현재 생애 주기를 선택하여 주십시오.");
					System.out.println("    1. 임신 / 2. 출산 / 3. 육아");
					System.out.print("    >>>");
					int Menu_num1 = sc.nextInt();
					System.out.println("    필요한 서비스의 분야를 선택하여 주십시오.");
					System.out.println("    [1]. 경제 / [2]. 의료 / [3]. 사회복지");
					System.out.print("    >>>");
					int Menu_num2 = sc.nextInt();
					
					if(Menu_num1 == 1) {
						if(Menu_num2 == 1) {
							ArrayList<String> N_list1 = new ArrayList<String>(); // 리스트 선언

							File note1 = new File("C:/Users/user/Desktop/textfile/p_e.txt");
									try{
									        BufferedReader br = new BufferedReader(new FileReader(note1));
									        String str = br.readLine();
							                while(str != null){
							                	N_list1.add(str); //ArrayList에 저장
							                	str = br.readLine();
							                }

									        br.close();
									} catch (NullPointerException e){ // null이 있을 경우
										e.getStackTrace();
									} catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
										e.getStackTrace();
									} catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
										e.getStackTrace();
									}
							        
							        for(int i = 0; i < N_list1.size(); i++){ // 저장된 Array의 크기만큼 루프
										System.out.println(N_list1.get(i)); // 순서대로 출력
									}
							break;
						}else if(Menu_num2 == 2) {
							ArrayList<String> N_list2 = new ArrayList<String>(); // 리스트 선언

							File note2 = new File("C:/Users/user/Desktop/textfile/p_m.txt");
									try{
									        BufferedReader br = new BufferedReader(new FileReader(note2));
									        String str = br.readLine();
							                while(str != null){
							                	N_list2.add(str); //ArrayList에 저장
							                	str = br.readLine();
							                }

									        br.close();
									} catch (NullPointerException e){ // null이 있을 경우
										e.getStackTrace();
									} catch (FileNotFoundException e){ // 파일을 찾을 수 없는 경우
										e.getStackTrace();
									} catch (IOException e){ // 파일 읽기 중 에러가 발생한 경우
										e.getStackTrace();
									}
							        
							        for(int i = 0; i < N_list2.size(); i++){ // 저장된 Array의 크기만큼 루프
										System.out.println(N_list2.get(i)); // 순서대로 출력
									}
							break;
						}else if(Menu_num2 == 3) {
							System.out.println("    <1. 출산 교실과 용품 지원>");
							System.out.println("    - 내용: 아이용품 만들기, 산후우울증 극복, 성공적인 모유수유, 순산체도, 다양한 임신/출산 교육 프로그램 제공");
							System.out.println("    - 신청: 관할 보건소 문의 (운영기간 및 신청일 정보 수집)");
							break;
						}
					}else if(Menu_num1 == 2) {
						if(Menu_num2 == 1) {
							System.out.println();
							System.out.println("    <1. 첫만남 이용권>");
							System.out.println("    - 1회 200만우너의 출산지원금을 일시금으로 지급");
							System.out.println("    - 기존에는 지자체별 지급이였으나, 보건복지부의 통합으로 지역 상관없이 동일하게 지원 가능");
							System.out.println();
							System.out.println("    <2. 출산 축하금>");
							System.out.println("    - 2022년부터 출산 축하금으로 200만원 일시 지원");
							System.out.println("    - 지차체 별개로 국가에서 지급");
							break;
						}else if(Menu_num2 == 2) {
							System.out.println();
							System.out.println("    ※ 데이터가 부족합니다! ※");
							break;
						}else if(Menu_num2 == 3) {
							System.out.println();
							System.out.println("    ※ 데이터가 부족합니다! ※");
							break;
						}
					}else if(Menu_num1 == 3) {
						if(Menu_num2 == 1) {
							System.out.println();
							System.out.println("    <1. 영아수당 & 양육수당>");
							System.out.println("    - 어린이집, 아이돌봄서비스를 이용하지 않는 영유아 아동의 양육수당 지급");
							System.out.println("    - 내용: 24개월 미만 영아 -> 월 30만원");
							System.out.println("    -      만 2세 이상에서 만 7세 미만 -> 월 10만원 ");
							System.out.println();
							System.out.println("    <2. 아동수당>");
							System.out.println("    - 영아수당, 양육수당과는 별개의 서비스");
							System.out.println("    - 만 8세까지 매월 10만원의 아동수당 지급.");
							System.out.println();
							System.out.println("    <3. 아빠 육아휴직 보너스제>");
							System.out.println("    - 조건: 부모가 차례로 같은 자녀에 대해 휴직을 사용하는 경우");
							System.out.println("    - 내용: 사용한 사람에게 첫 3개월까지 통상임금의 100%(상한액 월 250만원)지급");
							break;
						}else if(Menu_num2 == 2) {
							System.out.println();
							System.out.println("    ※ 데이터가 부족합니다! ※");
							break;
						}else if(Menu_num2 == 3) {
							System.out.println();
							System.out.println("    <1. 육아휴직 급여>");
							System.out.println("    - 조건: 만 8세 이하 또는 초등학교 2학년까지의 자녀를 양육하고 있어야 함.");
							System.out.println("    - 내용: 통상임금의 80% / 1~12개월까지 모두 동일하게 수령 가능");
							System.out.println();
							System.out.println("    <2. 3+3 부모 육아휴직제>");
							System.out.println("    - 조건: 생후 12개월 이하의 자녀를 둔 부모가 육아휴직을 사용할 때, 사용가능");
							System.out.println("    - 내용: 첫 3개월 동안 육아휴직 급여를 100% 수령 가능");
							System.out.println("    - 첫 달: 200만원 / 두 번째 달: 250만원 / 세 번째 달: 300만원");
							break;
						}
					break;
				}
			case 3:{
				join();
				break;
			}
			case 4:{
				break;
			}
			case 5:{
				break;
			}
			case 6:{ //게시판 기능 
				List<PersonInfo> person = new ArrayList<>();
				readTxt(person); //텍스트 파일 읽기
				run(person);
				break;
			}
			case 7:{
				break;
			}
			case 8:{
				break;
			}
			
			}
			
		}
	}
	public static void join() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가입 아이디 입력 : ");
		String id = sc.next();
		System.out.print("가입 패스워드 입력 : ");
		String password1 = sc.next();
		System.out.print("성함 입력 : ");
		String name = sc.next();
		System.out.print("전화번호 입력 : ");
		String tel = sc.next();
		
		//1.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2.
		String url = "jdbc:mysql://localhost:3306/eungae_eungae?serverTimezone=UTC";
		String user = "root";
		String password = "0000";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.
		String sql = " INSERT INTO useraccount "
				   + " VALUES (?, ?, ?, ?) ";
		
		
		PreparedStatement pstm = null;
		
		try {
			//3. Query준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1,  id);
			pstm.setString(2,  password1);
			pstm.setString(3,  name);
			pstm.setString(4,  tel);
			//4. Query 실행 및 리턴
			int res = pstm.executeUpdate();
			if(res > 0) {
				System.out.println("가입 성공");
			} else {
				System.out.println("가입 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. DB종료
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		 //메뉴 출력 메소드
	   
	}
	private static void run(List<PersonInfo> person) {
		boolean runx = true;
		int num = 0;
		String serchstr = "";
		
		System.out.println("*******************************");
		System.out.println("*          게   시   판         *");
		System.out.println("*******************************");
		
		while(runx) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
			System.out.println("----------------------------------------");
			System.out.print("메뉴 번호 >>> ");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println();
				System.out.println("<1. 리스트>");
				showinfo(person);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("<2. 등록>");
				add(sc, person);
				break;
			case 3:
				System.out.println();
				System.out.println("<3. 삭제>");
				System.out.print("번호 >>> ");
				delete(sc, person);
				break;
			case 4:
				System.out.println();
				System.out.println("<4. 검색>");
				System.out.print("이름 >>> ");
				serchstr = sc.next();
				search(person, serchstr);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("*****************************");
				System.out.println("*          감사합니다          *");
				System.out.println("*****************************");
				runx = false;
				break;
			default:
				System.out.println("[다시 입력해 주세요]");
				System.out.println();
				break;
			}
			
		}
	}
		//이름에서 단어를 포함하는 검색 기능
		private static void search(List<PersonInfo> person, String str) {
			for(int i = 0; i < person.size(); i++) {
				PersonInfo searchperson = (PersonInfo) person.get(i);
				if(searchperson.getName().contains(str)) {
					System.out.println(searchperson.toString());
				}
			}
		}
		
		//삭제 기능
		private static void delete(Scanner sc, List<PersonInfo> person) {
			int del = sc.nextInt();
			person.remove(del-1);
			update(person);
			System.out.println();
			wirteTxt(person);
			System.out.println("[삭제되었습니다.]");
		}
		
		//리스트 보여주기 기능
		private static void showinfo(List<PersonInfo> person) {
			for(int i = 0; i < person.size(); i++) {
				System.out.println(person.get(i).toString());
			}
		}
		
		//추가하기 기능
		private static void add(Scanner sc, List<PersonInfo> person) {
			String name;
			String sex;
			String contents;
			System.out.print(">이름 : ");
			name = sc.next();
			System.out.print(">성별 : ");
			sex = sc.next();
			System.out.print(">내용 : ");
			contents = sc.next();
			person.add(new PersonInfo(name, sex, contents));
			update(person);
			System.out.println();
			wirteTxt(person);
			System.out.println("[등록되었습니다.]");
		}
		
		//업데이트 기능
		private static void update(List<PersonInfo> person) {
			for(int i = 0; i < person.size(); i++) {
				PersonInfo n = (PersonInfo) person.get(i);
				n.setNum(i+1);
			}
		}
		private static List<PersonInfo> readTxt(List<PersonInfo> person){
			Reader fr = null;
			BufferedReader br = null;
			try {
				fr = new FileReader(NoticeBoard);
				br = new BufferedReader(fr);
				String line = "";
				String[] words = new String[3];
				while((line = br.readLine()) != null) {
					words = line.split(",");
					person.add(new PersonInfo(words[0], words[1], words[2]));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					br.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			update(person);
			return person;
		}
		private static void wirteTxt(List<PersonInfo> person) {
			Writer fw = null;
			BufferedWriter bw = null;
			try {
				fw = new FileWriter(NoticeBoard);
				bw = new BufferedWriter(fw);
				
				for(int i = 0; i < person.size(); i++) {
					PersonInfo writeperson = (PersonInfo) person.get(i);
					bw.write(writeperson.getName() + ",");
					bw.write(writeperson.getSex()+",");
					bw.write(writeperson.getContents());
					bw.write("\r\n");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					bw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

