package org.stc.clinicservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.stc.clinicservice.dto.Response;
import org.stc.clinicservice.exceptions.DoctorClinicExceptions;
import org.stc.clinicservice.exceptions.ErrorCodes;
import org.stc.clinicservice.model.entity.Appointments;
import org.stc.clinicservice.model.repository.AppointmentsRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentsRepository appointmentsRepository;

    @Autowired
    public AppointmentService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public Appointments saveAppointment(Appointments appointments) {
        if (appointments.getPatient().getPatientId() == null)
            throw new DoctorClinicExceptions(ErrorCodes.Appointment.Appointment_Should_Belong_To_Patient);
        return appointmentsRepository.save(appointments);

    }

    public Response findTodayAppointments(int pageNum,int pageSize) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDate = startOfDay.toLocalDate().atTime(LocalTime.MAX);
        Page<Appointments> appointmentsPage =  appointmentsRepository.findAppointmentsByAppointmentDateBetweenTwoDates(startOfDay, endOfDate,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new Response(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

    public Appointments cancelAppointment(Appointments appointments) {
        Appointments savedAppointment = appointmentsRepository.getById(appointments.getAppointmentId());
        if(savedAppointment == null)
            throw new DoctorClinicExceptions(ErrorCodes.Appointment.Not_Exsiting_Appointment);
        savedAppointment.setCancelNotice(appointments.getCancelNotice());
        return appointmentsRepository.save(savedAppointment);
    }

    public Response findAppointmentByDate(LocalDateTime appointmentDate,int pageNum,int pageSize){
        Page<Appointments> appointmentsPage = appointmentsRepository.findAppointmentsByAppointmentDate(appointmentDate,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new Response(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

    public Response getAppointmentByPatient(Long patientId, int pageNum, int pageSize){
        Page<Appointments> appointmentsPage =  appointmentsRepository.findAppointmentsByPatientPatientId(patientId,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new Response(appointmentsPage.getContent(),appointmentsPage.getTotalElements());
    }

    public Response getAppointmentByPatientName(String patientName, int pageNum, int pageSize){
        Page<Appointments> appointmentsPage = appointmentsRepository.findAppointmentsByPatientPatientName(patientName,
                PageRequest.of(pageNum, pageSize, Sort.Direction.DESC, "appointmentDate"));
        return new Response(appointmentsPage.getContent(),appointmentsPage.getTotalElements());

    }

}
