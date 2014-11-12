package demo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "characters")
public class Character extends AbstractPersistable<UUID> {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Override
    @Type(type = "pg-uuid")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "task_id", columnDefinition = "uuid")
    public UUID getId () {
        return super.getId();
    }
}
