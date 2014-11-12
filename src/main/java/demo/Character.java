package demo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "characters")
public class Character extends AbstractPersistable<UUID> {

    private static final long serialVersionUID = 1L;

    @Id
    @Override
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "task_id", columnDefinition = "uuid")
    public UUID getId () {
        return super.getId();
    }
}
