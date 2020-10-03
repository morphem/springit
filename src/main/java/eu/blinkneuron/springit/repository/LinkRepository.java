package eu.blinkneuron.springit.repository;

import eu.blinkneuron.springit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {}
