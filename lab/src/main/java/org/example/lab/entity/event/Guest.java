package org.example.lab.entity.event;

import jakarta.persistence.*;
import org.example.lab.enums.StatusGuest;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Guest  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StatusGuest statusGuest;

    @ManyToMany(mappedBy = "guests")
    private Set<Event> events = new HashSet<>();

    public Guest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusGuest getStatusGuest() {
        return statusGuest;
    }

    public void setStatusGuest(StatusGuest statusGuest) {
        this.statusGuest = statusGuest;
    }
}
