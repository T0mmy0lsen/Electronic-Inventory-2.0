package models;

public class System {
    int cpu, ram, mainboard, cabinet, graphiccard;

    public System(int cpu, int ram, int mainboard, int cabinet, int graphiccard) {
        this.cpu = cpu;
        this.ram = ram;
        this.mainboard = mainboard;
        this.cabinet = cabinet;
        this.graphiccard = graphiccard;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setMainboard(int mainboard) {
        this.mainboard = mainboard;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public void setGraphiccard(int graphiccard) {
        this.graphiccard = graphiccard;
    }

    public int getCpu() {
        return cpu;
    }

    public int getRam() {
        return ram;
    }

    public int getMainboard() {
        return mainboard;
    }

    public int getCabinet() {
        return cabinet;
    }

    public int getGraphiccard() {
        return graphiccard;
    }

}
