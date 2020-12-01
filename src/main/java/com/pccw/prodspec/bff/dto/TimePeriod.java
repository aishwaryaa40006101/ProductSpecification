package com.pccw.prodspec.bff.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@AllArgsConstructor
public class TimePeriod implements Serializable {

	private static final long serialVersionUID = 1L;

	private OffsetDateTime endDateTime = null;
	private OffsetDateTime startDateTime = null;
}
