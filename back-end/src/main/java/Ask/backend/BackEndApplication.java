package Ask.backend;


import models.question;
import models.user;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.pojo;

import java.util.ArrayList;
import java.util.Arrays;


@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		pojo n=new pojo();
		user n1 = new user();
		question n2=new question();
		n2.setQuestionText("zzzzzzzdddddddddd");
		n1.setEmail("zzzzz");
		n1.setBirthDate("ssss");
		n1.setPassword("2222");
		n1.setAnsweredQuestions(new ArrayList<>());
		n1.setAskedQuestions(Arrays.asList(n2));
		n1.setUserName("zzzas");

		n.writeTOdb("users", user.class,n1);

	}



}
