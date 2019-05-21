//fork.java
package exp3.tool;

import exp3.fruit.Fruit;

public class Fork implements Tool{
	public void usingTool(Fruit f) {
		f.eating();
		System.out.println("So using the forks");
	}
}
