package common.log.scholar_of_yore.entity;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CommonLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String requestId;

    private String PSM;

    private String level;

    private String context;

}