package java_adv02.io.member.impl;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java_adv02.io.member.Member;
import java_adv02.io.member.MemberRepository;


public class FileMemberRepository implements MemberRepository{
	
	private static final String FILE_PATH ="temp/members-file.dat";
	private static final String DELIMITER = ",";

	@Override
	public void add(Member member) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH,UTF_8,true))) {
			bw.write(member.getId()+DELIMITER+member.getName()+DELIMITER+member.getAge()); //회원 저장
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH,UTF_8))) {			
			String line;
			while((line = br.readLine())!= null) {
				String[] memberData = line.split(DELIMITER);
				members.add(new Member(memberData[0], memberData[1],Integer.valueOf(memberData[2])));
			}
			return members;
		} catch (FileNotFoundException e) {
			return new ArrayList<>();
		}catch (IOException e) {
			 throw new RuntimeException(e);
		 }
	}

}
