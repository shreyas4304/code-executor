
package com.example.codeexecutor.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Execution {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Lob
private String code;

private String language;
private String output;
private String status;
}
