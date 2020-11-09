package com.spacehotel.app.application.domain.entities;

import javax.persistence.*;

@Entity
@Table(name="login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String role;
    private boolean enabled;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_cliente")
    ClientEntity cliente;

    public LoginEntity(long id, String username, String password, String role, boolean enabled, ClientEntity clientEntity) {
        setId (id);
        setUsername (username);
        setPassword (password);
        setRole (role);
        setEnabled (enabled);
        setClientEntity (clientEntity);
    }


    public LoginEntity(String username, String password, String role, boolean enabled, ClientEntity clientEntity) {
        setUsername (username);
        setPassword (password);
        setRole (role);
        setEnabled (enabled);
        setClientEntity (clientEntity);
    }

    public LoginEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usuario) {
        this.username = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ClientEntity getClientEntity() {
        return cliente;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.cliente = clientEntity;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ClientEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClientEntity cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "usuario='" + username + '\'' +
                ", password='" + password + '\'' +
                ", clienteEntity=" + cliente +
                '}';
    }
}
