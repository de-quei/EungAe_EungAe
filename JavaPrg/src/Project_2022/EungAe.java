package Project_2022;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public static boolean loginFlag = false;
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
		System.out.printf("    %d.  %s\t%s\t%s", num, name, sex, contents);
	}
	public String toString() {
		String result = String.format("    %d.  %s\t%s\t%s", num, name, sex, contents);
		return result;
	}
	public static void login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("    >아이디 입력 : ");
		String id = sc.next();

		System.out.print("    >패스워드 입력 : ");
		String password = sc.next();
		
		// 로그인 성공 여부
		boolean successLogin = false;

		//1.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2.
		String url = "jdbc:mysql://localhost:3306/eungae_eungae?serverTimezone=UTC";
		String user = "root";
		String Password = "1234";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, Password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.
		String sql = "SELECT * FROM useraccount WHERE id=?"; 
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			//3. Query준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1,  id);
			
			//4. Query 실행 및 리턴
			rs = pstm.executeQuery();
			if (rs.next()) {
				String passwordFromDb = rs.getString("password"); //
				
				if (passwordFromDb.equals(password)) {
					successLogin = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5. DB종료
			try {
				rs.close();
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// 로그인 성공 여부를 검사한다.
		if (successLogin) {
			System.out.println("    [로그인에 성공하였습니다.]");
			loginFlag = true;
		} else {
			System.out.println("    [로그인에 실패하였습니다.]");
		}
	}
	public static void logout() {
		if(loginFlag) {
			System.out.println("    [로그아웃되었습니다.]");
			loginFlag = false;
		}else {
			System.out.println("    [먼저 로그인 해주십시오.]");
		}
	}
}
public class EungAe {
	
	static final String rootPath = System.getProperty("user.dir");
	static final String NoticeBoard = rootPath + "contentsDB.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<String> N_list = new ArrayList<String>(); // textfile 불러오기 리스트 선언
		
		while(true) {
		System.out.println();
		System.out.println("        UU  UU                            AAAAA          ");
		System.out.println("EEEEE   UU  UU    NN    NN               AA   AA    EEEEE");
		System.out.println("EE      UU  UU    NNN   NN   GGGGGG      AAAAAAA    EE   ");
		System.out.println("EEEEE   UU  UU    NN N  NN   GG      ★   AA   AA    EEEEE");
		System.out.println("EE       UUUU     NN   NNN   GG GGG      AA   AA    EE   ");
		System.out.println("EEEEE             NN    NN   GG  GG                 EEEEE");
		System.out.println("                             GGGGGG                      ");
		
		System.out.println();
		System.out.println("           EEEEE                      GGGGGG                      ");
		System.out.println("           EE      UU  UU             GG                     EEEEE");
		System.out.println("           EEEEE   UU  UU   NN   NN   GG GGG   ★   AAAAA     EE   ");
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
    	System.out.println("     6. 게시판");
    	System.out.println("     7. 전국 보건소 전화번호");
    	System.out.println("     8. 종료");
    	System.out.print("     >>>");
    	int select = sc.nextInt();
			
			switch(select) {
			case 1: // 서비스 안내
				File note = new File("../textfile/guide.txt");
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
							System.out.println(N_list.get(i));// 순서대로 출력
						}
				break;
			case 2: // 서비스 시작
				boolean exist = true;
				while(exist) {
					System.out.println();
					System.out.println("    현재 생애 주기를 선택하여 주십시오.");
					System.out.println("    [1]. 임신 / [2]. 출산 / [3]. 육아 / [4]. 종료");
					System.out.print("    >>>");
					int Menu_num1 = sc.nextInt();
					if(Menu_num1 == 4) {
						case2_exist();
						exist = false;
						break;
					}
					while(Menu_num1 < 1 || Menu_num1 > 3) {
						System.out.print("    다시 입력하여주십시오 >>> ");
						Menu_num1 = sc.nextInt();
						if(Menu_num1 == 4) {
							case2_exist();
							exist = false;
							break;
						}
						break;
					}
					System.out.println();
					System.out.println("    필요한 서비스의 분야를 선택하여 주십시오.");
					System.out.println("    [1]. 경제 / [2]. 의료 / [3]. 사회복지 / [4]. 종료");
					System.out.print("    >>>");
					int Menu_num2 = sc.nextInt();
					if(Menu_num1 == 4) {
						case2_exist();
						exist = false;
						break;
					}
					while(Menu_num2 < 1 || Menu_num2 > 3) {
						System.out.print("    다시 입력하여주십시오 >>> ");
						Menu_num2 = sc.nextInt();
						if(Menu_num1 == 4) {
							case2_exist();
							exist = false;
							break;
						}
						break;
					}
					if(Menu_num1 == 1) { //임신
						if(Menu_num2 == 1) { //경제
							File note1_1 = new File("../textfile/p_e.txt");
									try{
									        BufferedReader br = new BufferedReader(new FileReader(note1_1));
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
						}else if(Menu_num2 == 2) { // 임신 & 의료
							File note1_2 = new File("../textfile/p_m.txt");
									try{
									        BufferedReader br = new BufferedReader(new FileReader(note1_2));
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
						}else if(Menu_num2 == 3) { // 임신 & 사회복지
							File note1_3 = new File("../textfile/p_s.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note1_3));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){ 
								e.getStackTrace();
							} catch (FileNotFoundException e){ 
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
							break;
						}
					}else if(Menu_num1 == 2) { //출산
						if(Menu_num2 == 1) { // 경제
							File note2_1 = new File("../textfile/b_e.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note2_1));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){
								e.getStackTrace();
							} catch (FileNotFoundException e){ 
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
					        break;
						}else if(Menu_num2 == 2) { // 출산 & 의료
							File note2_2 = new File("../textfile/doesn'tExist.txt");
									try{
									        BufferedReader br = new BufferedReader(new FileReader(note2_2));
									        String str = br.readLine();
							                while(str != null){
							                	N_list.add(str); 
							                	str = br.readLine();
							                }

									        br.close();
									} catch (NullPointerException e){
										e.getStackTrace();
									} catch (FileNotFoundException e){ 
										e.getStackTrace();
									} catch (IOException e){ 
										e.getStackTrace();
									}
							        
							        for(int i = 0; i < N_list.size(); i++){ 
										System.out.println(N_list.get(i)); 
									}
							        break;
						}else if(Menu_num2 == 3) { //출산 & 사회복지
							File note2_3 = new File("../textfile/doesn'tExist.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note2_3));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){ 
								e.getStackTrace();
							} catch (FileNotFoundException e){ 
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
							break;
						}
					}else if(Menu_num1 == 3) { // 육아
						if(Menu_num2 == 1) { // 경제
							File note3_1 = new File("../textfile/c_e.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note3_1));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){ 
								e.getStackTrace();
							} catch (FileNotFoundException e){
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
							break;
						}else if(Menu_num2 == 2) { //육아 & 의료
							File note3_2 = new File("../textfile/doesn'tExist.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note3_2));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){ 
								e.getStackTrace();
							} catch (FileNotFoundException e){
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
							break;
						}else if(Menu_num2 == 3) { //육아 & 사회복지
							File note3_3 = new File("../textfile/c_s.txt");
							try{
							        BufferedReader br = new BufferedReader(new FileReader(note3_3));
							        String str = br.readLine();
					                while(str != null){
					                	N_list.add(str); 
					                	str = br.readLine();
					                }

							        br.close();
							} catch (NullPointerException e){ 
								e.getStackTrace();
							} catch (FileNotFoundException e){
								e.getStackTrace();
							} catch (IOException e){ 
								e.getStackTrace();
							}
					        
					        for(int i = 0; i < N_list.size(); i++){ 
								System.out.println(N_list.get(i)); 
							}
							break;
						}
					break;
					}
					break;
				}
				break;
			case 3:{
				join();
				break;
			}
			case 4:{
				PersonInfo.login();
				break;
			}
			case 5:{
				PersonInfo.logout();
				break;
			}
			case 6:{ //게시판 기능 
				if(PersonInfo.loginFlag) {
					List<PersonInfo> person = new ArrayList<>();
					readTxt(person); //텍스트 파일 읽기
					run(person);
					break;
				}else {
					System.out.println("    [사용자 로그인이 필요합니다.]");
					break;
				}
			}
			case 7:{
				File note3_3 = new File("../textfile/Health_tel.txt");
				try{
				        BufferedReader br = new BufferedReader(new FileReader(note3_3));
				        String str = br.readLine();
		                while(str != null){
		                	N_list.add(str); 
		                	str = br.readLine();
		                }

				        br.close();
				} catch (NullPointerException e){ 
					e.getStackTrace();
				} catch (FileNotFoundException e){
					e.getStackTrace();
				} catch (IOException e){ 
					e.getStackTrace();
				}
		        
		        for(int i = 0; i < N_list.size(); i++){ 
					System.out.println(N_list.get(i)); 
				}
				break;
			}
			case 8:{
				System.out.println();
				System.out.println("    =============================================");
				System.out.println("    *          이용해주셔서 정말 감사합니다!           *");
				System.out.println("    *   더욱 더 발전하는 응애응애가 되도록 하겠습니다     *");
				System.out.println("    =============================================");
				System.exit(0);
				break;
			}
			
			}
		}
	}
	public static void join() {
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("    >가입 아이디 입력 : ");
		String id = sc.next();
		System.out.print("    >가입 패스워드 입력 : ");
		String pw = sc.next();
		System.out.print("    >성함 입력 : ");
		String name = sc.next();
		System.out.print("    >전화번호 입력 (입력예시 : 010-0000-0000) : ");
		String tel = sc.next();
		System.out.print("    >성별 입력 (입력예시 : 여성, 남성..) : ");
		String sex = sc.next();
		
		//1.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2.
		String url = "jdbc:mysql://localhost:3306/eungae_eungae?serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.
		String sql = " INSERT INTO useraccount "
				   + " VALUES (?, ?, ?, ?, ?) ";
		
		
		PreparedStatement pstm = null;
		
		try {
			//3. Query준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1,  id);
			pstm.setString(2,  pw);
			pstm.setString(3,  name);
			pstm.setString(4,  tel);
			pstm.setString(5,  sex);
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
		System.out.println("    *******************************");
		System.out.println("    *          게   시   판         *");
		System.out.println("    *******************************");
		
		while(runx) {
			Scanner sc = new Scanner(System.in);
			System.out.println("    1.리스트  2. 등록  3. 삭제  4. 검색  5. 종료");
			System.out.println("    ----------------------------------------");
			System.out.print("    메뉴 번호 >>> ");
			num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println();
				System.out.println("    <1 리스트>");
				showinfo(person);
				System.out.println();
				break;
			case 2:
				System.out.println();
				System.out.println("    <2. 등록>");
				add(sc, person);
				break;
			case 3:
				System.out.println();
				System.out.println("    <3. 삭제>");
				System.out.print("    번호 >>> ");
				delete(sc, person);
				break;
			case 4:
				System.out.println();
				System.out.println("    <4. 검색>");
				System.out.print("    이름 혹은 내용 일부 입력 >>> ");
				serchstr = sc.next();
				search(person, serchstr);
				System.out.println();
				break;
			case 5:
				System.out.println();
				System.out.println("    *****************************");
				System.out.println("    *          감사합니다          *");
				System.out.println("    *****************************");
				runx = false;
				break;
			default:
				System.out.println("    [다시 입력해 주세요]");
				System.out.println();
				break;
			}
			
		}
		
		}
	
		//이름에서 단어를 포함하는 검색 기능
		private static void search(List<PersonInfo> person, String str) {
			for(int i = 0; i < person.size(); i++) {
				PersonInfo searchperson = (PersonInfo) person.get(i);
				if(searchperson.getName().contains(str) || searchperson.getContents().contains(str)) {
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
			System.out.println("    [삭제되었습니다.]");
		}
		
		//게시판 리스트를 보여주는 기능
		private static void showinfo(List<PersonInfo> person) {
			for(int i = person.size()-1; i >= 0; i--) {
				System.out.println(person.get(i).toString());
			}
		}
		
		//추가하기 기능
		private static void add(Scanner sc, List<PersonInfo> person) {
			String name;
			String sex;
			String contents;
			System.out.print("    >이름 : ");
			name = sc.next();
			System.out.print("    >성별 : ");
			sex = sc.next();
			System.out.print("    >내용 : ");
			contents = sc.next();
			person.add(new PersonInfo(name, sex, contents));
			update(person);
			System.out.println();
			wirteTxt(person);
			System.out.println("    [등록되었습니다.]");
		}
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
		public static void case2_exist() {
			System.out.println();
			System.out.println("    *****************************");
			System.out.println("    *          감사합니다          *");
			System.out.println("    *****************************");
		}
	}
