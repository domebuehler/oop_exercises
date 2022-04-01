package ch.hslu.oop.sw08;

import java.util.*;

public final class TemperaturVerlauf {

    private Collection<Temperatur> verlauf;

    public TemperaturVerlauf() {
        this.verlauf = new ArrayList<>();
    }

    public void add(Temperatur temperatur) {
        if (temperatur != null) {
            this.verlauf.add(temperatur);
        } else {
            System.out.println("null is not added!");
            return;
        }
    }

    public void addMultiple(Temperatur... temperatures) {
        if (temperatures.length > 0) {
            for (Temperatur temperatur : temperatures) {
                this.add(temperatur);
            }
        } else {
            System.out.println("no addable temperatures");
        }
    }

    public void clear() {
        this.verlauf.clear();
    }

    public int getCount() {
        return this.verlauf.size();
    }

    public Temperatur getTemperatur(int index) {
        List<Temperatur> verlaufListe = (List<Temperatur>) verlauf;
        if (verlaufListe.size() > 0 && index < verlaufListe.size()) {
            return verlaufListe.get(index);
        } else {
            System.out.println("index ist not valid or list is empty");
            return null;
        }
    }

    public Temperatur getMax() {
        if (this.verlauf.size() > 0) {
            return Collections.max(this.verlauf);
        } else {
            System.out.println("list is empty");
            return null;
        }
    }

    public Temperatur getMin() {
        if (this.verlauf.size() > 0) {
            return Collections.min(this.verlauf);
        } else {
            System.out.println("list is empty");
            return null;
        }
    }

    public Temperatur getAverage() {
        float average = 0;

        if (this.verlauf.size() > 0) {
            for (Temperatur temperatur : this.verlauf) {
                average += temperatur.getTempCelsius();
            }
            average = average / this.verlauf.size();
            return new Temperatur(average);
        } else {
            System.out.println("list is empty");
            return null;
        }
    }

    public Temperatur getAverageWithIterator() {
        float average = 0;

        if (this.verlauf.size() > 0) {
            Iterator<Temperatur> iterator = this.verlauf.iterator();
            while (iterator.hasNext()) {
                Temperatur temperatur = iterator.next();
                average += temperatur.getTempCelsius();
            }
            average = average / this.verlauf.size();
            return new Temperatur(average);
        } else {
            System.out.println("list is empty");
            return null;
        }
    }

    public Collection<Temperatur> getVerlauf() {
        return this.verlauf;
    }
}
