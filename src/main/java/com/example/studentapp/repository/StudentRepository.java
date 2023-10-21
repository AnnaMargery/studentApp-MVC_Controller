package com.example.studentapp.repository;


import com.example.studentapp.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository- interfejs dost przez spring data jpa- zapewnia gotowe metody do wykonywania operacji nabazie danych, zwiazanych z encja
// pozwala na automatyczne implementowanie rekordow z bazy danych ( wykorzystanie PODSTAWOWYCH metod) bez koniecznosci wpisywania ich implementacji
// klasa modelowa Student Model i primary key tej klasy glownej
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

        //todo metody, query oprócz podstawowych dostepnych z jpsrepository


}
