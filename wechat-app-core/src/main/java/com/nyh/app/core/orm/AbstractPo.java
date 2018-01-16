package com.nyh.app.core.orm;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"uuid"})
public class AbstractPo {
	
	protected String uuid;

}
