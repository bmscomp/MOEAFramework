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
package org.moeaframework.algorithm.single;

import org.junit.Assert;
import org.junit.Test;
import org.moeaframework.core.Solution;
import org.moeaframework.core.configuration.ConfigurationException;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.mock.MockRealProblem;
import org.moeaframework.problem.RosenbrockTestProblem;
import org.moeaframework.util.TypedProperties;

public class EvolutionStrategyTest {

	@Test
	public void testConfiguration() {
		EvolutionStrategy algorithm = new EvolutionStrategy(new MockRealProblem());
		
		TypedProperties properties = algorithm.getConfiguration();
		
		Assert.assertEquals("linear", properties.getString("method"));
		Assert.assertTrue(algorithm.getComparator() instanceof LinearDominanceComparator);
		
		properties.setString("method", "min-max");
		algorithm.applyConfiguration(properties);
		Assert.assertTrue(algorithm.getComparator() instanceof MinMaxDominanceComparator);
	}
	
	@Test(expected = ConfigurationException.class)
	public void testConfigurationInvalidIndicator() {
		EvolutionStrategy algorithm = new EvolutionStrategy(new MockRealProblem());
		
		algorithm.applyConfiguration(TypedProperties.withProperty("method", "foo"));
	}
	
	@Test
	public void testRosenbrock() {
		RosenbrockTestProblem problem = new RosenbrockTestProblem();
		EvolutionStrategy algorithm = new EvolutionStrategy(problem);
		algorithm.run(100000);
		
		Assert.assertEquals(1, algorithm.getResult().size());
		
		Solution solution = algorithm.getResult().get(0);
		
		Assert.assertArrayEquals(problem.getIdealVariables(), EncodingUtils.getReal(solution), 0.01);
		Assert.assertEquals(problem.getIdealObjectiveValue(), solution.getObjective(0), 0.01);
	}

}
