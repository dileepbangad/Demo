package CRUDApplication.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeShifts {
    private  Integer id;
    private Integer stageId;
    private String shiftType;
    private Date sDate;
    private Date eDate;
}
