package ru.maxima.models;

import lombok.*;

/**
 * 31.08.2021
 * 34. JdbcTemplate
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString(exclude = "owner")
public class Car {
    private Long id;
    private String color;
    private String model;

    private Account owner;
}
