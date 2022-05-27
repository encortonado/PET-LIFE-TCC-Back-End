package br.com.bortolo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetLifeApplication implements CommandLineRunner {

	// @Autowired
	// private S3Service s3Service;

	public static void main(String[] args) {
		SpringApplication.run(PetLifeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// s3Service.uploadFile("C:\\Users\\mlealsou\\Pictures\\imaplano.jpg");
	}

}
