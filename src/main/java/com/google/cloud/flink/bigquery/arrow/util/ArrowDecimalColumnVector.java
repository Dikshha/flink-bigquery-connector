/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.flink.bigquery.arrow.util;

import org.apache.arrow.vector.DecimalVector;
import org.apache.flink.table.data.DecimalData;
import org.apache.flink.table.data.vector.DecimalColumnVector;
import org.apache.flink.util.Preconditions;

/** Arrow column vector for DecimalData. */

public final class ArrowDecimalColumnVector implements DecimalColumnVector {

	/**
	 * Container which is used to store the sequence of DecimalData values of a
	 * column to read.
	 */
	private final DecimalVector decimalVector;

	public ArrowDecimalColumnVector(DecimalVector decimalVector) {
		this.decimalVector = Preconditions.checkNotNull(decimalVector, "DecimalVector is null");
	}

	@Override
	public DecimalData getDecimal(int i, int precision, int scale) {
		return DecimalData.fromBigDecimal(decimalVector.getObject(i), precision, scale);
	}

	@Override
	public boolean isNullAt(int i) {
		return decimalVector.isNull(i);
	}
}
