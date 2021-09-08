package org.stc.clinicservice.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.stc.clinicservice.model.entity.Appointments;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentsRepository extends JpaRepository<Appointments,Long> {

    @Query("select ap from Appointments  ap where ap.appointmentDate between :startOfDay and :endOfDay")
    Page<Appointments>  findAppointmentsByAppointmentDateBetweenTwoDates(LocalDateTime startOfDay, LocalDateTime endOfDay, Pageable page);

    Page<Appointments> findAppointmentsByAppointmentDate(LocalDateTime appointmentDate, Pageable page);

    Page<Appointments>  findAppointmentsByPatientPatientId(Long patientId, Pageable page);

    Page<Appointments>  findAppointmentsByPatientPatientName(String patientName, Pageable page);

}
