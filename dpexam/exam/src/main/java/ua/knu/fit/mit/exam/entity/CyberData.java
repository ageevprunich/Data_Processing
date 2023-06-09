package ua.knu.fit.mit.exam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "exam_cybersecure")
public class CyberData {
    @Id
    @GeneratedValue
    private long id;
    private String login;
    private int password_length;
    private float personal_key;
    private String password;
}
