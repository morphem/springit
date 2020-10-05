package eu.blinkneuron.springit;

import eu.blinkneuron.springit.domain.Comment;
import eu.blinkneuron.springit.domain.Link;
import eu.blinkneuron.springit.repository.CommentRepository;
import eu.blinkneuron.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpringitApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringitApplication.class, args);
  }

//  @Bean
  CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
    return args -> {
      Link link =
          new Link(
              "Getting Started with Spring Boot 2", "https://therealdanvega.com/spring-boot-2");
      linkRepository.save(link);

      Comment comment = new Comment("This Spring Boor 2 link is awesome!", link);
      commentRepository.save(comment);
      link.addComent(comment);

      System.out.println("We just inserted a link and a comment");
    };
  }
}
