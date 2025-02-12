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

import org.apache.arrow.vector.Float4Vector;
import org.apache.flink.table.data.vector.FloatColumnVector;
import org.apache.flink.util.Preconditions;

/** Arrow column vector for Float. */

public final class ArrowFloatColumnVector implements FloatColumnVector {

	/**
	 * Container which is used to store the sequence of float values of a column to
	 * read.
	 */
	private final Float4Vector floatVector;

	public ArrowFloatColumnVector(Float4Vector floatVector) {
		this.floatVector = Preconditions.checkNotNull(floatVector, "Float4Vector is null");
	}

	@Override
	public float getFloat(int i) {
		return floatVector.get(i);
	}

	@Override
	public boolean isNullAt(int i) {
		return floatVector.isNull(i);
	}
}
