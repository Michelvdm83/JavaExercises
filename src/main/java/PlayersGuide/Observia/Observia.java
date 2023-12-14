package PlayersGuide.Observia;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Observia {
    static CharberryTree tree;
    static Notifier notifier;
    static Harvester harvester;

    public static void main(String[] args) {
        tree = new CharberryTree();
        harvester = new Harvester();
        notifier = new Notifier(harvester, tree);
        tree.addPropertyChangeListener(notifier);
        while (harvester.getTimesHarvested() < 10) {
            tree.maybeGrow();
        }
    }

}

class Harvester {
    private int timesHarvested = 0;

    public void harvest(CharberryTree tree) {
        tree.harvestFruit();
        timesHarvested++;
    }

    public int getTimesHarvested() {
        return timesHarvested;
    }
}

class Notifier implements PropertyChangeListener {
    Harvester harvester;
    CharberryTree tree;

    public Notifier(Harvester harvester, CharberryTree tree) {
        this.harvester = harvester;
        this.tree = tree;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue().equals(true)) {
            System.out.println("A charberry fruit has ripened!");
            harvester.harvest(tree);
        } else if (evt.getNewValue().equals(false)) {
            System.out.println("The fruit has been harvested!");
        }
    }
}

class CharberryTree {
    private final Random random = new Random();
    private boolean ripe;
    private final PropertyChangeSupport support;

    public CharberryTree() {
        support = new PropertyChangeSupport(this.ripe);
    }

    public void maybeGrow() {

        // Only a tiny chance of ripening each time, but we try a lot!
        if (random.nextDouble() < 0.00000001 && !ripe) {
            ripe = true;
            support.firePropertyChange("ripe", false, true);
        }
    }

    public void harvestFruit() {
        if (ripe) {
            ripe = false;
            support.firePropertyChange("ripe", true, false);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
}