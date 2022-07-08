package edu.kalum.workerenrollment.core.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentProcessRequest implements Serializable {

    private String noExpediente;
    private String ciclo;
    private int mesInicioPago;
    private String carreraId;

}
