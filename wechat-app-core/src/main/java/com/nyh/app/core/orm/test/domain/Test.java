package com.nyh.app.core.orm.test.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nyh.app.core.orm.test.po.TestPo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true, includeFieldNames = true)
public class Test extends TestPo {

}
