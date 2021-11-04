package estevezcristian.todowithspring.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "task")
@EqualsAndHashCode @ToString
public class Task {

    @Id
    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Column(name = "completed", nullable = false, columnDefinition = "TINYINT(1)")
    @Getter @Setter
    private Boolean completed;

    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "folder_id")
    private Folder folder;
}
