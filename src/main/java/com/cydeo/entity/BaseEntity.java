package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,updatable = false)
    private LocalDateTime insertTime;
    @Column(nullable = false)
    private LocalDateTime updateTime;

    private boolean isDeleted=false;

    @PrePersist
    private void onInsert(){
        this.insertTime=LocalDateTime.now();
        this.updateTime=LocalDateTime.now();
    }
    @PreUpdate
    private void onPreUpdate(){
   this.updateTime=LocalDateTime.now();
    }

}
