package co.edu.unicauca.DesignPatterns.domain.entities;

import java.util.Objects;
import java.util.UUID;

/** Entidad de usuario con identidad y rol. */
public class User {
    private final UUID id;
    private String fullName;
    private String email;
    private Rol rol;

    public User(UUID id, String fullName, String email, Rol rol) {
        this.id = (id == null) ? UUID.randomUUID() : id;
        this.fullName = fullName;
        this.email = email;
        this.rol = rol;
    }

    public UUID getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public String displayName() { return fullName; }

    @Override public boolean equals(Object o){ return (o instanceof User u) && id.equals(u.id); }
    @Override public int hashCode(){ return Objects.hash(id); }
    @Override public String toString(){ return "User{id=" + id + ", fullName='" + fullName + "', rol=" + rol + "}"; }
}
