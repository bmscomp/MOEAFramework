/* Copyright 2009-2024 David Hadka
 *
 * This file is part of the MOEA Framework.
 *
 * The MOEA Framework is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * The MOEA Framework is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the MOEA Framework.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.moeaframework.problem.BBOB2016;

import org.moeaframework.core.Solution;

/**
 * Abstract class for transformations provided by the BBOB test suite.
 */
public abstract class BBOBTransformation extends BBOBFunction {

	/**
	 * The inner function that is being transformed.
	 */
	protected BBOBFunction function;
	
	/**
	 * Constructs a new instance of a BBOB test suite transformation.
	 * 
	 * @param function the inner function that is being transformed
	 */
	public BBOBTransformation(BBOBFunction function) {
		super(function.getNumberOfVariables());
		this.function = function;
	}
	
	@Override
	public Solution newSolution() {
		return function.newSolution();
	}

}
