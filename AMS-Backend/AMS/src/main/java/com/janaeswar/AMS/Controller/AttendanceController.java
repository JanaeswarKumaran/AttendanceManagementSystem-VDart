package com.janaeswar.AMS.Controller;
import com.janaeswar.AMS.Service.AttendanceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getAttendance(@PathVariable String employeeId){
        return attendanceService.getAttendance(employeeId);
    }

    @PostMapping("/addintime")
    public ResponseEntity<?> addInTime(@RequestParam String employeeId,
                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inTime) {
        return attendanceService.addInTime(employeeId, inTime);
    }

    @PostMapping("/addouttime")
    public ResponseEntity<?> addOutTime(@RequestParam String employeeId,
                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime outTime) {
        return attendanceService.addOutTime(employeeId, outTime);
    }
}
