package OA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Dinosaur implements Comparable<Dinosaur> {
    public static final double G = 9.8;
    public static final int PEDAL = 2;

    String name;
    double strideLen;
    double feetLen;
    double speed;

    public Dinosaur(String name, double feetLen, double strideLen) {
        this.name = name;
        this.feetLen = feetLen;
        this.strideLen = strideLen;
        speed = calculateSpeed();
    }

    public double calculateSpeed() {
        return (strideLen / feetLen - 1) * Math.sqrt(G * PEDAL);
    }

    @Override
    public int compareTo(Dinosaur o) {
        if (speed == o.speed) {
            return 0;
        }

        return speed < o.speed ? -1 : 1;
    }

    public String toString() {
        return name + ":" + speed;
    }
}

public class DinosaurSpeed {
    Map<String, List<Double>> dinosaurData;
    List<Dinosaur> dinosaurList;
    String file1;
    String file2;

    public DinosaurSpeed(String file1, String file2) {
        this.file1 = file1;
        this.file2 = file2;
        dinosaurData = new HashMap<>();
        dinosaurList = new ArrayList<>();
    }

    public void printDinosaur() {
        readCSV(file1, 2, true);
        readCSV(file2, 1, false);

        for (Map.Entry<String, List<Double>> entry : dinosaurData.entrySet()) {
            String name = entry.getKey();
            List<Double> data = entry.getValue();

            dinosaurList.add(new Dinosaur(name, data.get(0), data.get(1)));
        }

        Collections.sort(dinosaurList);

        System.out.println(dinosaurList);
    }

    private void readCSV(String filename, int index, boolean pedalFilter) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // skip the header of the table
            // Dinosaur, Pedal, Feet length
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                double val = Double.parseDouble(data[index].trim());
                if (pedalFilter) {
                    if (data[1].trim().equals("Bipedal")) {
                        List<Double> list = new ArrayList<>();
                        list.add(val);
                        dinosaurData.put(name, list);
                    }
                } else {
                    if (dinosaurData.containsKey(name)) {
                        dinosaurData.get(name).add(val);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DinosaurSpeed dinosaurTest = new DinosaurSpeed("./src/OA/data1.csv", "./src/OA/data2.csv");
        dinosaurTest.printDinosaur();
    }
}
