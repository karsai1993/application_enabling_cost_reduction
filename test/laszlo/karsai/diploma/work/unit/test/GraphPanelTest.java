package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import laszlo.karsai.diploma.work.GraphPanel;

/**
 * This class helps validate the constructor of the GraphPanel class.
 * @author Karsai, Laszlo
 *
 */
public class GraphPanelTest {

	/**
	 * The function of this test case is to test the constructor of GraphPanel class.
	 */
	@Test
	public void testGraphPanelListOfDoubleStringString() {
		List<Double> scores = new ArrayList<>();
		scores.add(1.5);
		scores.add(3.5);
		String type = "memory";
		String method = "OperatingSystemMXBean";
		double delta = 0;
		GraphPanel graphPanel = new GraphPanel(scores,type,method);
		assertEquals(3.5, graphPanel.getScores().get(1), delta);
		assertEquals(type, graphPanel.getType());
		assertEquals(method, graphPanel.getMethod());
		assertFalse(graphPanel.getScores().size() == 3);
		scores.add(5.5);
		graphPanel.setScores(scores);
		assertTrue(graphPanel.getScores().size() == 3);
	}

}
