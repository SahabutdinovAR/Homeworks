package ru.maxima.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 20.08.2021
 * 33. Simple Program with JDBC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Account {
    private Long id;
    private String email;
    private String password;
}
