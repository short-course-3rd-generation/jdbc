import java.util.List;

import datasource.Database;
import model.dao.ExpertDao;
import model.dto.Expert;

public class app {

	public static void main(String[] args) {
		//Database.getConnection();
		
		Expert expert=new Expert();
		expert.setName("Rachana");
		expert.setGender("female");
		expert.setSkill("Spring framework");
		expert.setCountry("Cambodia");
		expert.setPersonalInfo("I like to go everywhere");
		
		ExpertDao dao=new ExpertDao();
		//dao.createExpert(expert);
		
		List<Expert> list=dao.getExerts();
		list.forEach( a-> {
			System.out.println("--------------------");
			System.out.println(a.toString());
		});
		
	}
}
