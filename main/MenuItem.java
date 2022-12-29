package main;

import java.util.ArrayList;


import java.util.HashMap;

public class MenuItem extends EditRawMaterial {
  private int cost;
  public MenuItem(String name, int cost) {
    super();
	this.name = name;
    this.cost = cost;
  }

  public int getCost() {
    return cost;
  }

  public HashMap<String, Integer> getRawMaterials() {
    return rawMaterials;
  }

  public void addRawMaterial(String material, int cost) {
    rawMaterials.put(material, cost);
  }

  public void removeRawMaterial(String material) {
    rawMaterials.remove(material);
  }
}
