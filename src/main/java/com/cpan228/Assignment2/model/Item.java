package com.cpan228.Assignment2.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Max(2021)
    private int year;
    @DecimalMin(value = "00.00", inclusive = true)
    @DecimalMax(value = "1000.00", inclusive = true)
    private BigDecimal price;
    private Brand brandFrom;

    @Builder.Default
    private LocalDate createdAt = LocalDate.now();
    
    public enum Brand {
        DIOR("Dior"), CHANEL("Chanel"), HERMES("Hermes"), PRADA("Prada"), LOUIS_VUITTON("Louis Vuitton");

        private String title;

        private Brand(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}
