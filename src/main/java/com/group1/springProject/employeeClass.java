//class
package com.group1.springProject;

import jakarta.persistence.*;
import lombok.*;

@Data//Define Data or Getter Setter instead of manual getter & setter methods from lombok
@Entity//Define Entity table
@NoArgsConstructor
@AllArgsConstructor//Define default constructors instead of manual constructor from lombok
@Table(name="empdetails")//used to create multiple tables
public class employeeClass {
    @Id//for primary key, below the ID annotation, the variable (here id) will become primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Flow of primary key, maintains: order, sequence or auto
    private long id;

    @Column(name = "name")//create column name
    private String name;

    @Column(name = "address")//same
    private String address;
}
