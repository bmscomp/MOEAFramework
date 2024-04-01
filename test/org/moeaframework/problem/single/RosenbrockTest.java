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
package org.moeaframework.problem.single;

import org.junit.Assert;
import org.junit.Test;
import org.moeaframework.core.Settings;
import org.moeaframework.core.Solution;
import org.moeaframework.mock.MockSolution;
import org.moeaframework.problem.ProblemTest;

public class RosenbrockTest extends ProblemTest {
	
	@SuppressWarnings("resource")
	@Test
	public void test() {		
		Rosenbrock problem = new Rosenbrock();
		Solution solution = MockSolution.of(problem).at(1.0, 1.0);
		Assert.assertEquals(0.0, solution.getObjective(0), Settings.EPS);
	}

}
