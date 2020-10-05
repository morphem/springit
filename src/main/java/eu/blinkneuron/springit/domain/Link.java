package eu.blinkneuron.springit.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Link extends Auditable {

  @Id @GeneratedValue private Long id;
  @NonNull private String title;
  @NonNull private String url;

  @OneToMany(mappedBy = "link")
  private List<Comment> comments = new ArrayList<>();

  public void addComent(Comment comment) {
    this.comments.add(comment);
  }
}
